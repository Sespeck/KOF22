package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwitchSceneController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToRemarkScene1(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("RemarkScene1.fxml"));	
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToRemarkScene2(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("RemarkScene2.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToRemarkScene3(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("RemarkScene3.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToHeroesInfo(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("HeroesInfo.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToCombatantScene(ActionEvent event) throws IOException {		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("CombatantScene.fxml"));
		root = loader.load();
		
		CombatantSceneController combatantSceneController = loader.getController();
		combatantSceneController.createCharacters();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}	
	
	public void backToStart(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void exitGame(ActionEvent event) throws IOException{
		Platform.exit();
	}

}
