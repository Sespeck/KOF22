import java.util.concurrent.ThreadLocalRandom;

abstract class Weapon {
	
	
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


	protected String toString(){
		return “Name: ” + this.name + "\nDurability: " + this.durability + "\nStrike: " + this.strike + "\n";
	}
	
	protected void setName(String name){
		this.name = name;
	}
	
	protected void setDurability(int number){
		this.durability = number;
	}
	
	protected int getDurability(){
		return this.durability;
	}
	
	protected void setStrike(int number){
		this.strike = number;
	}
	
	protected int getStrike(){
		return this.strike;
	}
	
	protected void setHero(Hero hero){
		this.hero = hero;
	}
	
	protected Hero getHero(){
		return this.hero;
	}


}



