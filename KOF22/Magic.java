
public class Magic extends Weapon{

	//logic for Magic, if hero runs out of mana, attack with Magic return 0
	

 	public Magic(){
 		this.setName("Magic");
 		this.setStrike(6);
 		this.setDurability(this.getHero().getMana());	
 	}
 	

	@Override
	public int attack() {
		if(this.getHero().getMana() <= 0) {
			return 0;
		}
		
		int r = randInt(2,this.getStrike());
		
		this.getHero().setMana(this.getHero().getMana()-2);
		return r;
	}
	
	@Override
	public int specAttack(){
		if(this.getHero().getMana() <= 0) {
			return 0;
		}
		
		int r = randInt(4,this.getStrike());
		this.getHero().setMana(this.getHero().getMana()-4);

		return r;
	}
	
	
	

}
