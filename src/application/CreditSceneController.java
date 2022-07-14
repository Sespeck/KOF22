package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class CreditSceneController {
	
	public void exitGame(ActionEvent event) throws IOException{
		Platform.exit();
	}
}
