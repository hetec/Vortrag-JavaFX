package vortrag.animation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Control extends HBox{
	final CheckBox fade;
	CheckBox scale;
	CheckBox rotation;
	CheckBox fill;
	VBox vb1;
	VBox vb2;
	Button ani;
	Button stop;
	Button reset;
	final Rectangle r;
	public Ani a;
	
	public Control(){
		r = new Rectangle(50, 50);
		r.setFill(Color.RED);
		
		a = new Ani();
		a.init(r);
		
		fade = new CheckBox("FADE");
		scale = new CheckBox("SCALE");
		rotation = new CheckBox("ROTATION");
		fill = new CheckBox("COLOR");
		
		ani = new Button("START");
		stop = new Button("STOP");
		reset = new Button("RESET");
		
		vb1 = new VBox();
		vb2 = new VBox();
		
		vb1.getChildren().addAll(fade,scale,rotation,fill);
		vb2.getChildren().addAll(ani,stop,reset);
		this.getChildren().addAll(vb1,vb2);
		this.setAlignment(Pos.BASELINE_CENTER);
		this.setPadding(new Insets(20,20,20,20));
		reset.setDisable(true);
		stop.setDisable(true);
		
		ani.setOnAction((e) -> {
			if(this.fade.selectedProperty().get() == true){
				a.addFade();
			}
			if(this.scale.selectedProperty().get() == true){
				a.addScale();
			}
			if(this.rotation.selectedProperty().get() == true){
				a.addRot();
			}
			if(this.fill.selectedProperty().get() == true){
				a.addFill();
			}
			vb1.setDisable(true);
			ani.setDisable(true);
			stop.setDisable(false);
			a.pt.play();
		});
		
		stop.setOnAction((e) -> {
			reset.setDisable(false);
			stop.setDisable(true);
			a.pt.stop();
		});
		
		reset.setOnAction((e) -> {
			ani.setDisable(false);
			reset.setDisable(true);
			vb1.setDisable(false);
			a.pt.getChildren().removeAll(a.st, a.ft, a.fit, a.rt);
			r.setScaleX(1);
			r.setScaleY(1);
			r.setFill(Color.RED);
			r.setRotate(0);
		});
		
	}
	
	
}
