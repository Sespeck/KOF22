package model;

import java.util.ArrayList;

public class Heroes implements CharacterList{
    private ArrayList<Hero> heroList;
	public Object printHeroes;
    public Heroes(){
        heroList = new ArrayList<Hero>();

        heroList.add(new Hero("Hero1", 15, 3, 12));   	
    	heroList.add(new Hero("Hero2", 15, 3, 12));
    	heroList.add(new Hero("Hero3", 15, 3, 12));
    	heroList.add(new Hero("Hero4", 15, 3, 12));   	
    	heroList.add(new Hero("Hero5", 15, 3, 12));

    }

    public void out(int index){
        heroList.remove(index);
    }


	public Hero get(int heroIndex) {
		return heroList.get(heroIndex);
	}

	@Override
	public int size() {
		return heroList.size();
	}
}