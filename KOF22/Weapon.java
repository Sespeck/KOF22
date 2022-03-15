import java.util.concurrent.ThreadLocalRandom;

abstract class Weapon {
	
	protected int durability;
	protected int strike;
	protected Hero hero;
	
	protected abstract int specAttack();
	
	protected int attack() {
		if(this.durability <= 0) {
			return 0;
		}
		int r = randInt(1, this.strike);
		this.durability --;
		return r;
	}
	
	
	//cite: https://www.yawintutor.com/generate-random-integers-within-a-specific-range-in-java/#:~:text=Generate%20Random%20Integers%20within%20a%20Specific%20range%20in,the%20random%20class%20%28%29.%20...%20More%20items...%20
	protected int randInt(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min,max+1);
	}

	
	
	
	
}



