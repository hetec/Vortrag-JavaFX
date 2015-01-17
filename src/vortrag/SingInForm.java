package vortrag;

import org.controlsfx.*;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;
import org.controlsfx.control.action.Action;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SingInForm extends Application{
	private Pane createForms(){
		Text heading = new Text("Welcome to BA-Leipzig");
		Label usernameLbl = new Label("Username:");
		Label passwordLbl = new Label("Password:");
		TextField usernameTf = new TextField();
		PasswordField passwordPf = new PasswordField();
		Button submitBtn = new Button("SUBMIT");
		Button cancelBtn = new Button("CANCEL");
		Button resetBtn	= new Button("RESET");
		
		Text greeting = new Text();
		resetBtn.setOnAction(event -> {
			usernameTf.setText("");
			passwordPf.setText("");
		});
		submitBtn.setOnAction((event) -> {
			greeting.setText("Hello, " + usernameTf.getText());
		});
		cancelBtn.setOnAction(e -> {
			Action a = Dialogs.create()
					.title("Cancel Dialog")
					.actions(Dialog.ACTION_NO, Dialog.ACTION_YES)
					.styleClass(Dialog.STYLE_CLASS_NATIVE)
					.message("Do you want to exit the sign in dialog?")
					.showConfirm();
			
			if(a == Dialog.ACTION_YES){
				System.exit(0);
			}
					
		});
		
		HBox buttonBox = new HBox();
		buttonBox.getChildren().addAll(submitBtn,cancelBtn,resetBtn);
		buttonBox.setSpacing(10);
		buttonBox.setAlignment(Pos.BASELINE_RIGHT);
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(15,15,15,15));
		
		grid.add(heading, 0, 0, 2, 1); //colspan = 2 --> across two cells
		grid.add(usernameLbl, 0, 2);
		grid.add(passwordLbl, 0, 3);
		grid.add(usernameTf, 1, 2);
		grid.add(passwordPf, 1, 3);
		grid.add(buttonBox, 1, 4);
		grid.add(greeting, 0, 6, 2, 1);
		
		return grid;
	}
	
	private void configStage(Stage s){
		s.setTitle("Sign In");
		Image img = new Image("/vortrag/BA_logo.png");
		s.getIcons().add(img);
		s.centerOnScreen();
		s.setResizable(true);
	}
	
	public void start(Stage stage){
		stage.setScene(new Scene(this.createForms()));
		this.configStage(stage);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
