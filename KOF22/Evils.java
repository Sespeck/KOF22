public class Evils extends CharaterList{
    private ArrayList<Character> evilList;
    public Evils(){
        evilList = new ArrayList<evil>();
     
     /*  Constructor of a character(change to hero and evil respectively)
        public Character(String name, int hp, int power){
        this.alive = true;
        this.name = name;
        this.hitPoints = hp;
        this.power = power;
        }
        */
      	
    	evilList.add(new BadGuy("zombie", 200, 10));
    	evilList.add(new BadGuy("werewolf", 200, 10));
    	evilList.add(new BadGuy("goblin", 200, 10));
    }

     public void out(int index){
        // Out the evil from the evilList
    }

    public String print(){
        for(int x = 0; x<evilList.getSize(); x++){
			System.out.print(" " + evilList.get(x) + " ");
		}
    }
}