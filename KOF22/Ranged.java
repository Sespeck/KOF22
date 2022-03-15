
public class Ranged {

	//to do: set low strike in driver
	
	@Override
	public int specAttack(){
		if(this.getDurability()<=0){
		return 0;
		}
		
		iny r = randInt(0,this.getStrike());
		
		this.setDurability(this.getSurability()-1);
		
		return r;
	
	}
}
