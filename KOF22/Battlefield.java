import java.util.Scanner;

public class BattleField {
    
    public static void main(String [] args){
    	// Initiate the list of heros and evils
        Heroes heroes = new Heroes();
    	Evils evils = new Evils();

        // Greeting 
    	System.out.println("Welcome to King of Fighter 2022 Special Edition!");
        System.out.println("Here are our honorable heroes and treacherous evils teaming up for the biggest honor: King of Fighter of Year 2022.");
        System.out.println("Welcome our heroes:");
        heroes.printHeroes;
        System.out.println("Welcome our evils:");
        evils.printEvils;
        System.out.println("Now, let the fight begin!");
        
        // Round loop 
        int count = 0;
        boolean end = false; 
        
        while (!end){
            count++;
            System.out.println(String.format("================Round %d================", round));
            int heroIndex = RandomCharacter.select(heroes);
            int evilIndex = RandomCharacter.select(evils);
            Character hero = heroes.get(heroIndex);
            Character evil = evils.get(evilIndex);

            System.out.println(String.format("Welcome the hero %s and the evil %s", hero.getName(), evil.getName()));
            System.out.println("Choose a weapon for the hero by keying in the number");
            Weapons weapons = new Weapons();
            weapons.print();
            
            Weapon weapon;
            OptionScanner weaponOption = new OptionScanner(new int[]{1,2,3});
            switch (weaponOption.getInput()){
                case 1:  
                    weapon = new Melee();
                    break;
                case 2:
                    weapon = new Ranged();
                    break;
                case 3:
                    weapon = new Magic();
                    break;
            }

            // Attack loop
            // return 0 when the hero wins, 1 when the evil wins.
            System.out.println(String.format("The battle between %s and %s starts now.", hero.getName(), evil.getName()));
            Battle battle = new Battle(hero, evil, weapon);
            int win = battle.run();

            System.out.println(String.format("Congratulations, %s wins this round!", win == 0? hero.getName() : evil.getName()));
            System.out.println(String.format("%s has been defeated and is eliminated.", win == 1? hero.getName() : evil.getName()));

            // Elimiate the defeated from the combatants.
            if (win == 0){
                evils.remove(evilIndex);
                hero.resotre();
            }
            else{
                heroes.remove(heroindex);
                evil.restore();
            }
            // Check if the battle is over
            if (heroes.isEmpty() || evils.isEmpty()){
                end = true;
            }
        }

        // Print the winnder for KOF 2022
        if(heroes.isEmpty()){
            System.out.println("Congratuations to evils winning the honorable title of King of Fighters 2022!");
        }

        if(evils.isEmpty()){
            System.out.println("Congratuations to heroes winning the honorable title of King of Fighters 2022!");
        }
    }

}

class RandomCharacter{
    public static select(CharacterList l){
        return (int)(Math.random()*(l.size()+1));
    }
}

class OptionScanner{
    int userInput=0;
    boolean OK = false;
    public OptionScanner(int[] options){
        while (!OK){
            try {
                userInput=Integer.parseInt(scan.nextLine());
                if(!Arrays.asList(options).contains(userInput)){
                    System.out.println("That is not an option, please try again." );
                    continue;
                }
                OK = true;
            }
            catch(NumberFormatException e){
                System.out.println("That is not an option, please try again." );
            }
        }
    }
    
    public int getInput(){
        return userInput;
    }
}

class Battle{
    Character hero, evil;
    Weapon weapon;
    

    public Battle(Character hero, Character evil, Weapon weapon){
        this.hero = hero;
        this.evil = evil;
        this.weapon = weapon;
    }
    // return 0 when the hero wins, 1 when the evil wins
    public int run(){
        int count = 0;
        int evilAttack, heroAttack;

        while(hero.isAlive() && evil.isAlive()){
            count++;
            System.out.println(String.format("================Attack %d================", round));
            System.out.println("Select an attack method for the hero by keying in a number(1,2,3)\n
                1.Ordinary attack  2. Attack with weapon  3. Special attack with weapon");
    
            OptionScanner attackOption = new OptionScanner(new int[]{1,2,3});
            switch (attackOption.getInput()){
                case 1:  {
                    evilAttack = evil.attack();
                    hero.takeDamage(evilAttack);
                    if(hero.isAlive()){
                        heroAttack = hero.attack()
                        evil.takeDamage(heroAttack);
                        
                    } 
                    else break;                 
                    }
                    break;
                case 2:  {
                    hero.takeDamage(evil.attack());
                    if(hero.isAlive()) evil.takeDamage(hero.specAttack());
                    else break;    
                    }
                    break;
                case 3:  {
                    hero.takeDamage(evil.attack());
                    if(hero.isAlive()) evil.takeDamage(hero.specAttackWithWeapon());
                    else break;
                    }
                    break;
            }

            System.out.println(String.format("Evil: attack %d, HP %d", evilAttack, evil.getHp()));
            if(hero.isAlive())
                System.out.println(String.format("Hero: attack %d, HP %d", heroAttack, hero.getHp()));
            else 
                System.out.println(String.format("%s gets knocked out, HP %d", hero.getName(), hero.getHp()));

        }

        return hero.isAlive ? 0 : 1;
    }
    
}