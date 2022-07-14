package model;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Weapon {
	
	
	private String name;
	private int durability;
	private int strike;
	private Hero hero;
	
	
	protected abstract int specAttack();
	
	/*
	* returns an int representing attack value;
	*/
	protected int attack() {
		if(this.getDurability() <= 0) {
			return 0;
		}
		int r = randInt(1, this.getStrike());
		this.setDurability(this.getDurability()-2);
		return r;
	}
	
	
	/*
	* returns a random number between [min, max]
	*/
	protected int randInt(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min,max+1);
	}


	public String toString(){
		return "Name: " + this.getName() + "\nDurability: " + this.getDurability() + "\nStrike: " + this.getStrike() + "\n";
	}
	
	protected void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	protected void setDurability(int number){
		this.durability = number;
	}
	
	public int getDurability(){
		return this.durability;
	}
	
	protected void setStrike(int number){
		this.strike = number;
	}
	
	public int getStrike(){
		return this.strike;
	}
	
	protected void setHero(Hero hero){
		this.hero = hero;
	}
	
	public Hero getHero(){
		return this.hero;
	}


}



