import java.util.Random;

public abstract class Character {
    protected String name;
    protected int power;
    protected int hitPoints;
    protected boolean alive;

    /**
     * A constructor for a character who has name, hitpoints, power and if alive or not.
     * @param name
     * @param hp
     * @param power
     */

    public Character(String name, int hp, int power){
        this.alive = true;
        this.name = name;
        this.hitPoints = hp;
        this.power = power;
    }
    
    /**
     *  A getter
     * @return the name of a character
     */
    public String getName() {
    	return this.name;
    }
    
    /**
     * A getter
     * @return a character hitPoints
     */
    public int getHp(){
        return  this.hitPoints;
    }

    /**
     * Print out a character information
     * @return a formatted string
     */
    public String toString(){  	
        return "Name: " + this.name + "\nHit Points: "+ this.hitPoints + "\nPower: "+this.power 
        		+ "\n";
    }
    
    /**
     * Check a character is alive or not
     * @return a boolean value that represents the status of a character
     */
    public boolean isAlive(){
        return this.alive;
    }

    /**
     * A method to return from 1 to power range
     * @return a random integer, its range is [1, maxPower]
     */
    public int attack(){
        Random r = new Random();
        return r.nextInt(this.power)+1;
    }

    /**
     * A method to record the damage, to deduct the hitPoints of a character
     * @param damage
     */
    public void takeDamage(int damage){
        hitPoints -= damage;
        if (hitPoints<=0){
            hitPoints = 0;
            alive = false;
        }
    }

}
class Hero extends Character {
    private int mana;
    private Weapon weapon;

    /**
     * A constructor for hero
     * @param name hero's name
     * @param hp hero's hitPoints
     * @param power hero's power
     * @param mana hero's mana
     */
    public Hero(String name, int hp, int power, int mana){
        super(name, hp, power);
        this.mana = mana;
    }
    /**
     * Print out a character information
     * @return a formatted string
     */
    @Override
    public String toString(){  	
        return super.toString() + "Mana: "+ this.mana + "\n";
    }

    /**
     * A getter
     * @return the mana value of a hero
     */
    public int getMana(){
        return this.mana;
    }

    /**
     * A attack method that belongs to a hero
     * @return the weapon attack value
     */
    public int attackWithWeapon(){
        return weapon.attack();
    }

    /**
     * A special attack method with weapon
     * @return the weapon special attack value
     */
    public int specAttackWithWeapon(){
        return weapon.specAttack();
    }

}
class Evil extends Character {

    public Evil(String name, int hp, int power){
        super(name, hp, power);
    }

    /**
     * enum phrases
     */
    public enum Phrases{
        brain,
        howl,
        blowUp;

        Phrases phrases;

        public void wordsLike(){
            switch (phrases){
                case brain:
                    System.out.println("La dohsola fasoray!"); // Your delicious brains!
                    break;
                case howl:
                    System.out.println("Fa! Soso so doh lasomeefa sotee!"); // Howl! This is the scariest night!
                    break;
                case blowUp:
                    System.out.println("So sodoh mee rayfa sotee ray!"); // I like to blow things up!
                    break;
            }
        }
    }

    /**
     * Bad guy is speaking before each attach
     * @return 
     */
    public Phrases speak(){
        return Phrases.values()[new Random().nextInt(Phrases.values().length)];
    }
    
    @Override
    public int attack(){
        this.speak();
        Random r = new Random();
        return r.nextInt(this.power)+1;
    }

}

