
public class Magic extends Weapon{

	//logic for Magic, if hero runs out of mana, attack with Magic return 0
	

 	public Magic(){
 		this.name = "Magic";
 		this.strike = 6;
 		this.durability = this.hero.getMana();	
 	}
 	

	@Override
	public int attack() {
		if(this.hero.getMana() <= 0) {
			return 0;
		}
		
		int r = randInt(2,this.getStrike());
		
		this.Hero.setMana(this.Hero.getMana()-2);
		return r;
	}
	
	@Override
	public int specAttack(){
		if(this.hero.getMana() <= 0) {
			return 0;
		}
		
		int r = randInt(4,this.getStrike());
		this.Hero.setMana(this.Hero.getMana()-4);

		return r;
	}
	
	
	

}
