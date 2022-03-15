
public class BattleArena {
    public static void main(String [] args){
    	
    	ListADT<Character> heroList = new ListADTImpl<Character>();
    	
    	ListADT<Character> badGuyList = new ListADTImpl<Character>();
    	
    	heroList.addBack(new Hero("sakura", 100, 20, 10));   	
    	heroList.addBack(new Hero("chunli", 100, 25, 10));
    	heroList.addBack(new Hero("ken", 120, 20, 10));
    	
    	badGuyList.addBack(new BadGuy("zombie", 200, 10));
    	badGuyList.addBack(new BadGuy("werewolf", 200, 10));
    	badGuyList.addBack(new BadGuy("goblin", 200, 10));
    	
    	for(int x = 0; x<heroList.getSize(); ++x)
		{
			System.out.println(heroList.get(x));
		}
    	
    	System.out.println("==========\n");
    	for(int x = 0; x<badGuyList.getSize(); ++x)
		{
			System.out.println(badGuyList.get(x));
		}
        
    }
}
