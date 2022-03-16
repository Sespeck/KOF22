
public class Magic {

	//logic for Magic, if hero runs out of mana, attack with Magic return 0
	
 	this.name = "Magic";
 	this.strike = 6;
 	this.durability = this.hero.getMana();
 	

	@Override
	public int attack() {
		if(this.hero.getMana() <= 0) {
			return 0;
		}
		
		int r = randInt(1,this.getStrike());
		
		this.Hero.setMana(this.Hero.getMana()-1);
		return r;
	}
	
	@Override
	public int specAttack(){
		if(this.hero.getMana() <= 0) {
			return 0;
		}
		
		int r = randInt(3,this.getStrike());
		
		this.Hero.setMana(this.Hero.getMana()-3);
		return r;
	}
	
	
	

}
