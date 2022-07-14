package application;

import java.io.IOException;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Weapon;

public class AttackSceneController {
	private Parent root;
	private Stage stage;
	private Scene scene;
	
	private Data data;
	
	private int win = -1; // win = 0, hero wins, win = 1, evil wins
    
    @FXML
	private Button normalAttack, attackWithWeapon, specAttackWithWeapon, switchToCombatantSceneButton;
	@FXML
	private Label heroHP, heroMana, evilHP, weaponDurability;
	@FXML
	private ImageView heroImage, evilImage, weaponImage, animationPunch, animationCannonStrike, animationSupremePower,evilAttackAnimation, heroKO, evilKO;
	
	public void setBattle(Weapon weapon, Data data) {
		switchToCombatantSceneButton.setDisable(true);
		
		this.data = data;
        this.data.selectedHero.setWeapon(weapon);
        
        Image image1 = new Image(getClass().getResourceAsStream(String.format("%s.png", data.getSelectedHero().getName())));
        Image image2 = new Image(getClass().getResourceAsStream(String.format("%s.png", data.getSelectedEvil().getName())));
        Image image3 = new Image(getClass().getResourceAsStream(String.format("%sRound.png", weapon.getName())), 200, 200, true, true);
		heroImage.setImage(image1);
		evilImage.setImage(image2);
		weaponImage.setImage(image3);  
		
		
		Image image4 = new Image(getClass().getResourceAsStream("PunchAnimation.gif"));		
        Image image5 = new Image(getClass().getResourceAsStream("CannonStrikeAnimation.gif"));
        Image image6 = new Image(getClass().getResourceAsStream("SupremePowerAnimation.gif"));        
        Image image7 = new Image(getClass().getResourceAsStream("EvilAttackAnimation.gif"));        
        animationPunch.setImage(image4);
        animationCannonStrike.setImage(image5);
        animationSupremePower.setImage(image6);
        evilAttackAnimation.setImage(image7);
		
		updateStatus();
	}
	
	public void punch(ActionEvent event) {

		TranslateTransition translate = new TranslateTransition();
		translate.setNode(animationPunch); 
		translate.setDuration(Duration.millis(2000)); 
		translate.setCycleCount(1); 
		translate.setFromX(0);
		translate.setToX(2000);
		translate.play();
	
		data.getSelectedEvil().takeDamage(data.getSelectedHero().attack());  
		System.out.println("punch");
		updateStatus();

		if (checkAlive()== 1) return;
	
		TranslateTransition translate2 = new TranslateTransition();
		translate2.setNode(evilAttackAnimation); 
		translate2.setDuration(Duration.millis(2000)); 
		translate2.setCycleCount(1); 
		translate2.setFromX(0);
		translate2.setFromY(0);  	
		translate2.setToX(-2000);
		translate2.play(); 
		
		
		data.getSelectedHero().takeDamage(data.getSelectedEvil().attack());	
		System.out.println("Evil attacks");
		updateStatus();
		checkAlive();
	}
	
	public void cannonStrike(ActionEvent event) {
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(animationCannonStrike); 
		translate.setDuration(Duration.millis(2000)); 
		translate.setCycleCount(1); 
		translate.setFromX(0);
		translate.setFromY(0);  	
		translate.setToX(2000);
		translate.play();
		
		data.getSelectedEvil().takeDamage(data.getSelectedHero().attackWithWeapon());  
		System.out.println("cannon strike");
		updateStatus();
		// Check if the Mana and Durability become 0 and disable buttons
		if (data.getSelectedHero().getWeapon().getDurability() == 0 
				|| data.getSelectedHero().getMana() == 0 ) {
			attackWithWeapon.setDisable(true);
			specAttackWithWeapon.setDisable(true);
		}
		if (checkAlive()== 1) return;
		
		
		TranslateTransition translate2 = new TranslateTransition();
		translate2.setNode(evilAttackAnimation); 
		translate2.setDuration(Duration.millis(2000)); 
		translate2.setCycleCount(1); 
		translate2.setFromX(0);
		translate2.setFromY(0);  	
		translate2.setToX(-2000);
		translate2.play();
		
		data.getSelectedHero().takeDamage(data.getSelectedEvil().attack());	
		System.out.println("Evil attacks");
		updateStatus();
		checkAlive();
	}
	
	public void supremePower(ActionEvent event) {
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(animationSupremePower); 
		translate.setDuration(Duration.millis(2000)); 
		translate.setCycleCount(1); 
		translate.setFromX(0);
		translate.setFromY(0);  	
		translate.setToX(2000);
		translate.play();
		
		data.getSelectedEvil().takeDamage(data.getSelectedHero().specAttackWithWeapon());  
		System.out.println("supreme power");
		updateStatus();
		// Check if the Mana and Durability become 0 and disable buttons
		if (data.getSelectedHero().getWeapon().getDurability() == 0 
				|| data.getSelectedHero().getMana() == 0 ) {
			attackWithWeapon.setDisable(true);
			specAttackWithWeapon.setDisable(true);
		}

		if (checkAlive()== 1) return;
		
		TranslateTransition translate2 = new TranslateTransition();
		translate2.setNode(evilAttackAnimation); 
		translate2.setDuration(Duration.millis(2000)); 
		translate2.setCycleCount(1); 
		translate2.setFromX(0);
		translate2.setFromY(0);  	
		translate2.setToX(-2000);
		translate2.play();
		
		data.getSelectedHero().takeDamage(data.getSelectedEvil().attack());	
		System.out.println("Evil attacks");
		updateStatus();
		checkAlive();
	}
	
	
	private void disableButtons() {
		normalAttack.setDisable(true);
		attackWithWeapon.setDisable(true);
		specAttackWithWeapon.setDisable(true);
		
		//Enable continue button
		switchToCombatantSceneButton.setDisable(false);
	}

	private void updateStatus() {
		heroHP.setText(Integer.toString(data.getSelectedHero().getHp()));
	    heroMana.setText(Integer.toString(data.getSelectedHero().getMana()));
	    evilHP.setText(Integer.toString(data.selectedEvil.getHp()));
	    weaponDurability.setText(Integer.toString(data.getSelectedHero().getWeapon().getDurability()));
	}
	
	private int checkAlive() {
		if(!data.getSelectedEvil().isAlive()) {
			win = 0;		
			disableButtons();			
			System.out.println("Hero wins");
			Image image = new Image(getClass().getResourceAsStream("KO.png"));
			evilKO.setImage(image);
			return 1;
		}
		
		if(!data.getSelectedHero().isAlive()) {
			win = 1;
			disableButtons();
			System.out.println("Evil wins");
			Image image = new Image(getClass().getResourceAsStream("KO.png"));
			heroKO.setImage(image);
			return 2;
		}	
		else return 0;
	}
			
	
	public void switchToCombatantScene(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("CombatantScene.fxml"));
		root = loader.load();
		
		CombatantSceneController combatantSceneController = loader.getController();
		combatantSceneController.removeCharacter(win, data);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
}
