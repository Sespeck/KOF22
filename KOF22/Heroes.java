public class Heroes extends CharaterList{
    private ArrayList<Character> heroList;
    public Heroes(){
        ArrayList<Hero> heroList = new ArrayList<Hero>();

        heroList.add(new Hero("sakura", 100, 20, 10, 15));   	
    	heroList.add(new Hero("chunli", 100, 25, 10, 15));
    	heroList.add(new Hero("ken", 120, 20, 10, 15));
    }

    public void out(int index){
        heroList.remove(index);
    }

    public String print(){
        for(int x = 0; x<heroList.getSize(); x++){
			System.out.print(heroList.get(x).getName() + " ");
		}
    }
}