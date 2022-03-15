

public class Melee extends weapons{

	//to do in Driver: set up high strength
	
	@Override
<<<<<<< Updated upstream
	public int specAttack() {
		if(this.durability <= 0) {
=======
	protected int specAttack() {
		if(this.getDurability() <= 0) {
>>>>>>> Stashed changes
			return 0;
		}
		// Melee is a weapon that has a high strength based special attack but takes a high durability cost. 
		// normally min strike for other weapon starts at 1, Melee start at 5;
		// Durability cost of other weapon is 1, Melee's is 3 
		int r = randInt(5,this.getStrike());
		
		//is this a secure way to write code than "this.durability -= 3"?
		this.setDurability(this.getDurability() -3);
		return r;
	}


}
