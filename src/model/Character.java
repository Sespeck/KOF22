package model;
import java.util.Random;

public abstract class Character {
    protected String name;
    protected int power;
    protected int hitPoints;
    protected boolean alive;
    protected int hp; 

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
        this.hp = hp; // get the hitPoints for resetting later
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
     * A setter
     * reset the hitPoint for a character
     */
    public void resetHp(){
        this.hitPoints = this.hp;
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
