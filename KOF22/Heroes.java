public class Heroes implements CharaterList{
    private ArrayList<Character> heroList;
    public Heroes(){
        heroList = new ArrayList<Hero>();
        // 
        heroList.add(new Hero("sakura", 20, 3, 10));   	
    	heroList.add(new Hero("chunli", 20, 3, 10));
    	heroList.add(new Hero("ken", 20, 3, 10));
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