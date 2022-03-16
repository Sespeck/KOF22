import java.util.concurrent.ThreadLocalRandom;

abstract class Weapon {
	
	
	protected String name;
	protected int durability;
	protected int strike;
	protected Hero hero;
	
	
	protected abstract int specAttack();
	
	/*
	* returns an int representing attack value;
	*/
	protected int attack() {
		if(this.durability <= 0) {
			return 0;
		}
		int r = randInt(1, this.strike);
		this.durability --;
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
	
	
	
	
}



