package application;

import javafx.geometry.Point2D;
import java.util.ArrayList;
import java.util.List;

import model.Evil;
import model.Evils;
import model.Hero;
import model.Heroes;


public class Data {
	Heroes heroes;
	Evils evils;
	Hero selectedHero;
	Evil selectedEvil;
	int heroIndex;
	int evilIndex;
	List<Point2D> LayoutPositions;
	ArrayList<String> heroDefeated;
	ArrayList<String> evilDefeated;
	
	public Data() {
		heroes = new Heroes();
		evils = new Evils();
		heroDefeated = new ArrayList<String>();
		evilDefeated = new ArrayList<String>();		
		LayoutPositions = new ArrayList<Point2D>(); 
		LayoutPositions.add(new Point2D(105,35)); // Hero 1 Position
		LayoutPositions.add(new Point2D(332,35)); // Hero 2 Position
		LayoutPositions.add(new Point2D(542,35)); // Hero 3 Position
		LayoutPositions.add(new Point2D(760,35)); // Hero 4 Position
		LayoutPositions.add(new Point2D(979,35)); // Hero 5 Position
		LayoutPositions.add(new Point2D(105,370)); // Evil 1 Position
		LayoutPositions.add(new Point2D(332,370)); // Evil 2 Position
		LayoutPositions.add(new Point2D(542,370)); // Evil 3 Position
		LayoutPositions.add(new Point2D(760,370)); // Evil 4 Position
		LayoutPositions.add(new Point2D(979,370)); // Evil 5 Position
	}

	public Heroes getHeroes() {
		return heroes;
	}

	public void setHeroes(Heroes heroes) {
		this.heroes = heroes;
	}

	public Evils getEvils() {
		return evils;
	}

	public void setEvils(Evils evils) {
		this.evils = evils;
	}

	public Hero getSelectedHero() {
		return selectedHero;
	}

	public void setSelectedHero(Hero selectedHero) {
		this.selectedHero = selectedHero;
	}

	public Evil getSelectedEvil() {
		return selectedEvil;
	}

	public void setSelectedEvil(Evil selectedEvil) {
		this.selectedEvil = selectedEvil;
	}

	public int getHeroIndex() {
		return heroIndex;
	}

	public void setHeroIndex(int heroIndex) {
		this.heroIndex = heroIndex;
	}

	public int getEvilIndex() {
		return evilIndex;
	}

	public void setEvilIndex(int evilIndex) {
		this.evilIndex = evilIndex;
	}

	public List<Point2D> getLayoutPositions() {
		return LayoutPositions;
	}
	
	
}
