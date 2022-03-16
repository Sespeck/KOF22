
public class Ranged {


	this.name = "Ranged";
	this.durability = 5;
	this.strike = 5;
	
	@Override
	public int specAttack(){
		if(this.getDurability()<=0){
		return 0;
		}
		
		int r = randInt(0,this.getStrike());
		
		this.setDurability(this.getSurability()-1);
		
		return r;
	
	}
}
