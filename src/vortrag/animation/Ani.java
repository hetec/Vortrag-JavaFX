package vortrag.animation;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Ani {
	ScaleTransition st;
	FadeTransition ft;
	RotateTransition rt;
	FillTransition fit;
	ParallelTransition pt;
	
	public void init(Shape r){
		st = new ScaleTransition(Duration.millis(2000), r);
		st.setByX(4);
		st.setByY(6);
		st.setCycleCount(Timeline.INDEFINITE);
		st.setInterpolator(Interpolator.LINEAR);
		st.setAutoReverse(true);
		
		ft = new FadeTransition(Duration.millis(2000), r);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setAutoReverse(true);
		ft.setCycleCount(Timeline.INDEFINITE);
		
		rt = new RotateTransition(Duration.millis(2000), r);
		rt.setFromAngle(0);
		rt.setToAngle(360);
		rt.setCycleCount(Timeline.INDEFINITE);
		
		fit = new FillTransition(Duration.millis(2000), r);
		fit.setFromValue(Color.GREEN);
		fit.setToValue(Color.BLUE);
		fit.setAutoReverse(true);
		fit.setCycleCount(Timeline.INDEFINITE);
		
		pt = new ParallelTransition();
	}
	
	public void addScale(){
		pt.getChildren().add(st);
	}
	public void addFade(){
		pt.getChildren().add(ft);
	}
	public void addRot(){
		pt.getChildren().add(rt);
	}
	public void addFill(){
		pt.getChildren().add(fit);
	}
}
