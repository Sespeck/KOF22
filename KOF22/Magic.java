
public class Magic {

	@Override
	public int attack() {
		if(this.hero.getMana() <= 0) {
			return 0;
		}
		
		iny r = randInt(1,this.getStrike());
		
		this.Hero.setMana(this.Hero.getMana()-1);
		return r;
	}
	
	@Override
	public int specAttack(){
		if(this.hero.getMana() <= 0) {
			return 0;
		}
		
		iny r = randInt(3,this.getStrike());
		
		this.Hero.setMana(this.Hero.getMana()-3);
		return r;
	}
	
	
	

}
