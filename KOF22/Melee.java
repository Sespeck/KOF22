

public class Melee extends weapons{

	//to do in Driver: set up high strength
	
	@Override
	protected int specAttack() {
		if(this.durability <= 0) {
			return 0;
		}
		// Melee is a weapon that has a high strength based special attack but takes a high durability cost. 
		// normally min strike for other weapon starts at 1, Melee start at 5;
		// Durability cost of other weapon is 1, Melee's is 3 
		int r = randInt(5,this.strike);
		
		//is this a secure way to write code than "this.durability -= 3"?
		this.durability = this.durability -3;
		return r;
	}


}
