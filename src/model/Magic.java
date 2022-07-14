package model;
public class Magic extends Weapon{

	//logic for Magic, if hero runs out of mana, attack with Magic return 0
	private Hero hero;

 	public Magic(Hero hero){
 		this.setName("Magic");
 		this.setStrike(6);
 		this.hero = hero;
 		this.setDurability(this.hero.getMana());	
 	}


	@Override
	public int attack() {
		if(this.hero.getMana() <= 0) {
			return 0;
		}
		
		int r = randInt(2,this.getStrike());
		
		this.hero.setMana(this.hero.getMana()-4);
		return r;
	}
	
	@Override
	public int specAttack(){
		if(this.hero.getMana() <= 0) {
			return 0;
		}
		
		int r = randInt(4,this.getStrike());
		this.hero.setMana(this.hero.getMana()-4);

		return r;
	}
	
	
	

}
