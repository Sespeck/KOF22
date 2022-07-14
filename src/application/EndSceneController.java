package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class EndSceneController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	ImageView endSceneBackground;
	
	@FXML 
	Label endSceneRemark;
	
	public void setEndScene(int endGame){
		// Evils won
		if (endGame == 1) {
			Image image = new Image(getClass().getResourceAsStream("EvilWins.gif"));
			endSceneBackground.setImage(image);
			endSceneRemark.setText("Your feeble skills are no match for the power of the dark side!");
		}
		// Heroes won
		else {
			Image image = new Image(getClass().getResourceAsStream("HeroWins.gif"));
			endSceneBackground.setImage(image);			
			endSceneRemark.setText("May the peace live forever on this land guarded by our honorable heroes.");
		}
	}

	public void switchToCreditScene(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("CreditScene.fxml"));
		root = loader.load();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	
	
	
}

	