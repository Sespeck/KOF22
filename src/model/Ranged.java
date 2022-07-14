package model;
public class Ranged extends Weapon{
	
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
		
		int r = randInt(4,this.getStrike());
		
		this.setDurability(this.getDurability()-2);
		
		return r;
	
	}
}
