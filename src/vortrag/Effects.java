package vortrag;

import com.sun.javafx.geom.Rectangle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Effects extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		Image image = new Image(this.getClass().getResource("BA_logo.png").toExternalForm());
		final ImageView iv = new ImageView(image);
		Button setEffect = new Button("set effect");
		setEffect.setOnAction((e) -> {
			if(iv.getEffect() == null){
				DropShadow shadow = new DropShadow();
				shadow.setBlurType(BlurType.GAUSSIAN);
				shadow.setOffsetX(3);
				shadow.setOffsetY(3);
				
				Reflection reflection = new Reflection();
				reflection.setFraction(0.6);
				reflection.setInput(shadow);
				
				 PerspectiveTransform pt = new PerspectiveTransform();
			        pt.setUlx(0.0f);
			        pt.setUly(0.0f);
			        pt.setUrx(80.0f);
			        pt.setUry(10.0f);
			        pt.setLrx(80.0f);
			        pt.setLry(140.0f);
			        pt.setLlx(0.0f);
			        pt.setLly(150.0f);
			        
			    pt.setInput(reflection);
			    
			    iv.setEffect(pt);
			}else{
				iv.setEffect(null);
			}
		});
			
		
		BorderPane bp = new BorderPane();
		bp.setCenter(iv);
		bp.setBottom(setEffect);
		BorderPane.setMargin(iv, new Insets(50));
		BorderPane.setAlignment(setEffect, Pos.CENTER);
		
		stage.setScene(new Scene(bp, 500,500));
		stage.centerOnScreen();
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch();
	}
}
