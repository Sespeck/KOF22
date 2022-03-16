
public class Ranged {


	this.name = "Ranged";
	this.durability = 6;
	this.strike = 6;
	
	@Override
	public int specAttack(){
		if(this.getDurability()<=0){
		return 0;
		}
		
		int r = randInt(0,this.getStrike());
		
		this.setDurability(this.getSurability()-2);
		
		return r;
	
	}
}
