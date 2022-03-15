
public class Magic {

	@Override
	protected int specAttack() {
		if(this.hero.getMana() <= 0) {
			return 0;
		}
		
		int damage = 3;
		
		this.Hero.setMana(this.Hero.getMana()-1);
		return damage;
	}

}
