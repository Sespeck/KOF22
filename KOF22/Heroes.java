public class Heroes extends CharaterList{
    private ArrayList<Character> heroList;
    public Heroes(){
        heroList = new ArrayList<hero>();
     
     /*
     public Hero(String name, int hp, int power, int mana){
        super(name, hp, power);
        this.mana = mana;
    }
    */
        heroList.add(new Hero("sakura", 100, 20, 10, 5));   	
    	heroList.add(new Hero("chunli", 100, 25, 10, 5));
    	heroList.add(new Hero("ken", 120, 20, 10, 5));
    }

    public void out(int index){
        heroList.remove(index);
    }

    public String print(){
        for(int x = 0; x<heroList.getSize(); x++){
			System.out.print(" " + heroList.get(x) + " ");
		}
    }
}