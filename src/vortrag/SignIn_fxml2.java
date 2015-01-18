package vortrag;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignIn_fxml2 extends Application{
	@Override
	public void start(Stage s) throws Exception {
		final FXMLLoader loader = new FXMLLoader(getClass().getResource("signIn2.fxml"));
		loader.setController(new FxController2());
		final Parent root = loader.load();
		s.setScene(new Scene(root));
		s.setTitle("Sign in via fxml");
		s.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
