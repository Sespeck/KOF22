public class Heroes extends CharaterList{
    private ArrayList<Character> heroList;
    public Heroes(){
        heroList = new ArrayList<hero>();
     
     /*  Constructor of a character(change to hero and evil respectively)
        public Character(String name, int hp, int power){
        this.alive = true;
        this.name = name;
        this.hitPoints = hp;
        this.power = power;
        }
        */
        heroList.add(new Hero("sakura", 100, 20, 10));   	
    	heroList.add(new Hero("chunli", 100, 25, 10));
    	heroList.add(new Hero("ken", 120, 20, 10));
    }

    public void out(int index){
        // Out the hero from the heroList
    }

    public String print(){
        for(int x = 0; x<heroList.getSize(); x++){
			System.out.print(" " + heroList.get(x) + " ");
		}
    }
}