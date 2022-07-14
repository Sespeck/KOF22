package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception{		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
//			Parent root = FXMLLoader.load(getClass().getResource("RemarkScene3.fxml"));
//			Parent root = FXMLLoader.load(getClass().getResource("CreditScene.fxml"));
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			primaryStage.setHeight(800);
			primaryStage.setWidth(1366);
			primaryStage.setResizable(false);
			primaryStage.show();
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
		
	}
		
	public static void main(String[] args) {
		Application.launch(args); 		
	}
}
