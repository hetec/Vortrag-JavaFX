package vortrag;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignIn_fxml extends Application{
	@Override
	public void start(Stage s) throws Exception {
		final Parent root = FXMLLoader.load(getClass().getResource("signIn.fxml"));
		
		s.setScene(new Scene(root));
		s.setTitle("Sign in via fxml");
		s.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
