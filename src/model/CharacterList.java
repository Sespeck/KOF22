package model;
public interface CharacterList {
    // Eliminate losers
    void out(int index);
  
    Character get(int index);
    
	int size();

}