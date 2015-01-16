package testing;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import javafx.application.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FirstJavaFxExample extends Application{

	private HBox createUsernameInField(){
		HBox username = new HBox(5);
		username.setPadding(new Insets(0,0,0,20));
		username.setSpacing(50);
		Label lblUsername = new Label("Username:");
		TextField tfUsername = new TextField();
		username.setAlignment(Pos.BASELINE_RIGHT);
		username.getChildren().addAll(lblUsername, tfUsername);
		return username;
	}
	
	private HBox createSignInButtons(){
		HBox submitButtons = new HBox(10);
		Button btnSubmit = new Button("submit");
		btnSubmit.setMaxSize(100, 20);
		Button btnCancel = new Button("cancel");
		btnCancel.setMaxSize(100, 20);
		submitButtons.setAlignment(Pos.BASELINE_RIGHT);
		submitButtons.getChildren().addAll(btnSubmit,btnCancel);
		return submitButtons;
	}
	
	private HBox createPasswordField(){
		HBox password = new HBox(5);
		password.setPadding(new Insets(0,0,0,20));
		password.setSpacing(50);
		Label lblPassword = new Label("Password:");
		PasswordField pfPassword = new PasswordField();
		password.setAlignment(Pos.BASELINE_RIGHT);
		password.getChildren().addAll(lblPassword,pfPassword);
		return password;
	}
	
	private void initGui(Stage s){
		Label lblHeader = new Label("Please sign in:");

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(5,5,5,5));
		grid.add(createUsernameInField(),0, 1);
		grid.add(createPasswordField(), 0, 2);
		grid.add(createSignInButtons(), 0, 3);
		grid.add(lblHeader, 0, 0);
		//grid.setGridLinesVisible(true);
		configStage(s);
		
		s.setScene(new Scene(grid));
		s.centerOnScreen();
		s.show();
	}
	
	private void configStage(Stage s){
		s.setTitle("FirstTrial");
		Image img = new Image("/testing/Javafx_logo_color.png");
		s.getIcons().add(img);
		s.setResizable(true);
	}
	
	@Override
	public void start(Stage mainStage){
		initGui(mainStage);
	}
	
	public static void main(String[] args) {
		launch();
	}
}
