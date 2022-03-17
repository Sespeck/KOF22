public class Evils implements CharaterList{
    private ArrayList<Character> evilList;
    public Evils(){
        evilList = new ArrayList<Evil>();
        
    	evilList.add(new Evil("zombie", 20, 3));
    	evilList.add(new Evil("werewolf", 20, 3));
    	evilList.add(new Evil("goblin", 20, 3));
    }

     public void out(int index){
        evilList.remove(index);
    }

    public String print(){
        for(int x = 0; x<evilList.getSize(); x++){
			System.out.print(evilList.get(x) + " ");
		}
    }
}