package application;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class SceneTransition {
	public static void sceneTransitionAnimation(ActionEvent event, Parent root) {
		Scene s = ((Button)event.getSource()).getScene();
		root.translateXProperty().set(s.getWidth());
		
		AnchorPane parentContainer = (AnchorPane) s.getRoot();
		parentContainer.getChildren().add(root);
		
		Timeline timeline = new Timeline();
		KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
		KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
		timeline.getKeyFrames().add(kf);
		timeline.setOnFinished(event1 ->{
			parentContainer.getChildren().remove(0);
		});	
		timeline.play();
	}
}
