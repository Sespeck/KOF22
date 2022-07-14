package application;

import java.io.IOException;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Magic;
import model.Melee;
import model.Ranged;
import model.Weapon;

public class WeaponSceneController {
	private Stage stage;
	private Scene scene;
	private Parent root;

	private Data data;
	private Weapon weapon;
	@FXML
	private RadioButton magicButton, meleeButton, rangedButton;
	
	@FXML
	ImageView heroImage;
	
	@FXML 
	Button switchToAttackSceneButton;
  
	public void getWeapon(ActionEvent event) {
	  
		if(magicButton.isSelected()) {
			weapon = new Magic(data.selectedHero);
			System.out.println("Magic");
		}
		else if(meleeButton.isSelected()) {
			weapon = new Melee();
			System.out.println("Melee");
		}
		else if(rangedButton.isSelected()) {
			weapon = new Ranged();
			System.out.println("Ranged");
		}
		switchToAttackSceneButton.setDisable(false);
	}
	
	public void switchToAttackScene(ActionEvent event) throws IOException {
		
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AttackScene.fxml"));
		root = loader.load();
				
		AttackSceneController attackSceneController = loader.getController();
		attackSceneController.setBattle(weapon, data);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void setCharacters(Data data) {
		this.data = data;		
		Image image = new Image(getClass().getResourceAsStream(String.format("%s.png", data.getSelectedHero().getName())));
		heroImage.setImage(image);
		switchToAttackSceneButton.setDisable(true);
	}

}
