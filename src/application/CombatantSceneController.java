package application;

import java.io.IOException;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.CharacterList;



public class CombatantSceneController {
	
	private Parent root;
	private Stage stage;
	private Scene scene;
	private Data data;	
	private int endGame;

	@FXML
	ImageView heroCircle, evilCircle, koImage, hero1KO, hero2KO, hero3KO, hero4KO, hero5KO, evil1KO, evil2KO, evil3KO, evil4KO, evil5KO;
	
	@FXML
	private Button switchToWeaponSceneButton, characterPickerButton, switchToEndSceneButton;
	
	@FXML
	private Label congratulations;
	
	@FXML
	private Group congratulationsGroup;
	
	public void createCharacters(){
		data = new Data();
	}
		
	public void removeCharacter(int win, Data data){
		
		this.data = data;
		data.selectedHero.resetHp();
		data.selectedHero.resetMana();
		data.selectedEvil.resetHp();
		
		if (win == 0) {
			data.getEvils().out(data.getEvilIndex());
		
			System.out.println(String.format("Evil %s index %d is out", data.selectedEvil.getName(), data.evilIndex));
			System.out.println(String.format("Evils size: %d", data.evils.size()));
			data.evilDefeated.add(data.selectedEvil.getName());
		}
		else {
			data.getHeroes().out(data.getHeroIndex());
			System.out.println(String.format("Hero %s index %d is out", data.getSelectedHero().getName(), data.getHeroIndex()));
			System.out.println(String.format("Heroes size: %d", data.getHeroes().size()));
			data.heroDefeated.add(data.selectedHero.getName());
		}
		for (String x: data.evilDefeated) {
			System.out.println(x);
			switch (x) {
            case "Evil1" : evil1KO.setImage(koImage.getImage());
                     break;
            case "Evil2" : evil2KO.setImage(koImage.getImage());
                     break;
            case "Evil3" : evil3KO.setImage(koImage.getImage());
                     break;
            case "Evil4" : evil4KO.setImage(koImage.getImage());
                     break;
            case "Evil5" : evil5KO.setImage(koImage.getImage());
                     break;
			}
			
		}
		for (String x: data.heroDefeated) {
			System.out.println(x);
			switch (x) {
            case "Hero1" : hero1KO.setImage(koImage.getImage());
                     break;
            case "Hero2" : hero2KO.setImage(koImage.getImage());
                     break;
            case "Hero3" : hero3KO.setImage(koImage.getImage());
                     break;
            case "Hero4" : hero4KO.setImage(koImage.getImage());
                     break;
            case "Hero5" : hero5KO.setImage(koImage.getImage());
                     break;
			}
			
		}

		endGame = endGame();
	}

	public int endGame() {
		if (data.heroes.size()==0) {
			characterPickerButton.setDisable(true);
			congratulations.setText("Unfortunately, evils have won the battle!");
			TranslateTransition translate = new TranslateTransition();
			translate.setNode(congratulationsGroup); 
			translate.setDuration(Duration.millis(1000)); 
			translate.setCycleCount(1); 
			translate.setFromX(0);
			translate.setFromY(0);  	
			translate.setToY(-445);
			translate.play(); 
			return 1;
		}
		else if (data.evils.size() == 0) {
			characterPickerButton.setDisable(true);
			congratulations.setText("Congratulations to our heroes!");
			TranslateTransition translate = new TranslateTransition();
			translate.setNode(congratulationsGroup); 
			translate.setDuration(Duration.millis(1000)); 
			translate.setCycleCount(1); 
			translate.setFromX(0);
			translate.setFromY(0);  	
			translate.setToY(-445);
			translate.play(); 
			return 2;
		}
		return 0;
	}
	
	public void switchToWeaponScene(ActionEvent event) throws IOException {		
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("WeaponScene.fxml"));
		root = loader.load();
		
		WeaponSceneController weaponSceneController = loader.getController();
		weaponSceneController.setCharacters(data);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void characterPicker(ActionEvent event) throws IOException {
		data.setHeroIndex(selectCharacter(data.heroes));
		data.setEvilIndex(selectCharacter(data.evils));
		data.setSelectedHero(data.heroes.get(data.heroIndex));
		data.setSelectedEvil(data.evils.get(data.evilIndex));
		
		int heroItem = Integer.parseInt(data.selectedHero.getName().substring(4))-1;
		int evilItem = Integer.parseInt(data.selectedEvil.getName().substring(4))+4;
		heroCircle.setLayoutX(data.LayoutPositions.get(heroItem).getX()-6);
		heroCircle.setLayoutY(data.LayoutPositions.get(heroItem).getY()+55);
		evilCircle.setLayoutX(data.LayoutPositions.get(evilItem).getX()-6);
		evilCircle.setLayoutY(data.LayoutPositions.get(evilItem).getY()+55);
		System.out.println(data.getSelectedHero().toString());
		System.out.println(data.getSelectedEvil().toString());
		
		switchToWeaponSceneButton.setDisable(false);
	}
	
	private int selectCharacter(CharacterList l){
        return (int)(Math.random()*l.size());
    }
	
	public void switchToEndScene(ActionEvent event) throws IOException {		
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EndScene.fxml"));
		root = loader.load();
		
		EndSceneController endSceneController = loader.getController();
		endSceneController.setEndScene(endGame);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
				
	}
    
}








