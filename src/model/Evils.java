package model;

import java.util.ArrayList;

public class Evils implements CharacterList{
    private ArrayList<Evil> evilList;
    
    public Evils(){
        evilList = new ArrayList<Evil>();
        
    	evilList.add(new Evil("Evil1", 20, 3));
    	evilList.add(new Evil("Evil2", 20, 3));
    	evilList.add(new Evil("Evil3", 20, 3));
    	evilList.add(new Evil("Evil4", 20, 3));
    	evilList.add(new Evil("Evil5", 20, 3));
    }

     public void out(int index){
        evilList.remove(index);
    }

 	public Evil get(int evilIndex) {
		return evilList.get(evilIndex);
	}

	@Override
	public int size() {
		return evilList.size();
	}
}