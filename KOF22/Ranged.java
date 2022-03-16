
public class Ranged {
	
	public Ranged(){
 		this.setName("Ranged");
 		this.setStrike(6);
 		this.setDurability(6);	
 	}
	
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
