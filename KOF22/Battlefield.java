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
        Scanner weaponOption = new Scanner(System.in);
        while (!end){
            count++;
            System.out.println(String.format("================Round %d================", round));
            int heroIndex = RandomCharacter.select(heroes);
            int evilIndex = RandomCharacter.select(evils);
            Character hero = heroes.get(heroIndex);
            Character evil = evils.get(evilIndex);

            System.out.println(String.format("Welcome the hero %s and the evil %s", hero.getName(), evil.getName()));
            System.out.println("Choose a weapon for the hero by keying in the number");
            // weapons.printWeapons();
            // TODO: try block
            int weaponNumber = weaponOption.nextInt();
            // Weapon weapon = new Weapon(weaponNumber);

            // Attack loop
            // return 0 when the hero wins, 1 when the evil wins.
            System.out.println(String.format("The battle between %s and %s starts now.", hero.getName(), evil.getName()));
            Battle battle = new Battle(hero, evil, weapon);
            int win = battle.run();
            
            // Elimiate the defeated from the combatants.
            if (win == 0){
                evils.remove(evilIndex);
            }
            else{
                heroes.remove(heroindex);
            }

            System.out.println(String.format("Congratulations, %s wins this round!", win == 0? hero.getName() : evil.getName()));
            System.out.println(String.format("%s has been defeated and is eliminated.", win == 1? hero.getName() : evil.getName()));

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

class Battle{
    Character hero, evil;
    Weapon weapon;
    Scanner attackOption = new Scanner(System.in);

    public Battle(Character hero, Character evil, Weapon weapon){
        this.hero = hero;
        this.evil = evil;
        this.weapon = weapon;
    }
    // return 0 when the hero wins, 1 when the evil wins
    public int run(){
        int count = 0;

        while(hero.isAlive() && evil.isAlive()){
            count++;
            System.out.println(String.format("================Attack %d================", round));
            System.out.println("Select an attack method for the hero by keying in a number(1,2,3)\n
                1.Ordinary attack  2. Attack with weapon  3. Special attack with weapon");
            // TODO: evil phrase
            // TODO: try block
            int attackNumber = attackOption.nextInt();
            switch (attackNumber){
                case 1:  {
                    hero.hitpoints += evil.attack();
                    evil.hitpoints += hero.attack();
                }
                    break;
                case 2:  {
                    hero.hitpoints += evil.attack();
                    evil.hitpoints += weapon.attack();
                }
                    break;
                case 3:  {
                    hero.hitpoints += evil.attack();
                    evil.hitpoints += weapon.specAttack();
                }
                    break;
            }

            //print the attacks and status of characters(mana), weapon durability

        }

        return hero.isAlive ? 0 : 1;
    }
    
}