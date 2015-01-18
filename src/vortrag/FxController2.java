package vortrag;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class FxController2 implements Initializable{
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Text greeting;
	@FXML
	private Button signin;
	
	@Override
	public void initialize(final URL location, final ResourceBundle resources){
		signin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				greeting.setText("Hello, " + username.getText());
			}
		});
	}
	
}

