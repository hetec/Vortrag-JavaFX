package vortrag.animation;


import com.sun.javafx.geom.Shape;
import com.sun.webkit.network.about.Handler;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Animation extends Application{
	
	@Override
	public void start(Stage m) throws Exception {
		
		Control ctr = new Control();
		
		BorderPane bp = new BorderPane();
		bp.setCenter(ctr.r);
		bp.setBottom(ctr);
				
		m.setScene(new Scene(bp, 300, 300));
		m.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
