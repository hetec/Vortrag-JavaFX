package vortrag.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class FxController {
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Text greeting;
	
	@FXML
	protected void handleSubmitAction(final ActionEvent e){
		greeting.setText("Hello, " + username.getText());
	}
}
