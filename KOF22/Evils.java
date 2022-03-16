public class Evils extends CharaterList{
    private ArrayList<Character> evilList;
    public Evils(){
        evilList = new ArrayList<Evil>();
    
    	evilList.add(new BadGuy("zombie", 200, 10));
    	evilList.add(new BadGuy("werewolf", 200, 10));
    	evilList.add(new BadGuy("goblin", 200, 10));
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