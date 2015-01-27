package vortrag.basics;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

public class SignInForm_css extends Application{
	private Pane createForms(Stage stage){
		final Stage s = stage;
		Text heading = new Text("Welcome to BA-Leipzig");
		
		heading.setStyle(
				"-fx-font-family: Arial;"
				+ " -fx-font-size: 20px;"
				+ " -fx-font-weight: bold;"
				+ " -fx-fill: dimgray");
		
		Label usernameLbl = new Label("Username:");
		Label passwordLbl = new Label("Password:");
		TextField usernameTf = new TextField();
		PasswordField passwordPf = new PasswordField();
		Button submitBtn = new Button("SUBMIT");
		submitBtn.setId("submit");
		submitBtn.setStyle("-fx-font-weight: bold; -fx-font-size: 10px;");
		Button cancelBtn = new Button("CANCEL");
		cancelBtn.setId("cancel");
		cancelBtn.setStyle("-fx-font-weight: bold; -fx-font-size: 10px");
		Button resetBtn	= new Button("RESET");
		resetBtn.setStyle("-fx-font-weight: bold; -fx-font-size: 10px"+ "");
		resetBtn.setId("reset");
		CheckBox cssOn = new CheckBox("Switch to dark theme");
		cssOn.setOnAction((e) -> {
			if(cssOn.selectedProperty().get() == true){
				System.out.println("TRUE");
				s.getScene().getStylesheets().remove(this.getClass().getResource("light.css").toExternalForm());
				s.getScene().getStylesheets().add(this.getClass().getResource("dark.css").toExternalForm());
			}else{
				System.out.println("FALSE");
				s.getScene().getStylesheets().remove(this.getClass().getResource("dark.css").toExternalForm());
				s.getScene().getStylesheets().add(this.getClass().getResource("light.css").toExternalForm());
			}
		});
		Text greeting = new Text();
		greeting.getStyleClass().add("greeting");

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
		grid.setPadding(new Insets(30,30,30,30));
		
		grid.add(heading, 0, 0, 2, 1); //colspan = 2 --> across two cells
		grid.add(usernameLbl, 0, 2);
		grid.add(passwordLbl, 0, 3);
		grid.add(usernameTf, 1, 2);
		grid.add(passwordPf, 1, 3);
		grid.add(buttonBox, 1, 4);
		grid.add(cssOn, 0, 6, 2, 1);
		grid.add(greeting, 0, 8, 2, 1);
		//grid.setGridLinesVisible(true);
		GridPane.setHalignment(greeting, HPos.CENTER);
		return grid;
	}
	
	private void configStage(Stage s){
		s.setTitle("Sign In");
		Image img = new Image("/resources/BA_logo.png");
		s.getIcons().add(img);
		s.centerOnScreen();
		s.setResizable(true);
	}
	
	public void start(Stage stage){
		stage.setScene(new Scene(this.createForms(stage)));
		stage.getScene().getStylesheets().add("vortrag/basics/light.css");
		this.configStage(stage);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
	
}
