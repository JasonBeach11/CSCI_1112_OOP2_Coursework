/**
 * Author: Jason Beach
 * Date: March 6, 2023
 * 
 * CSCI 1112: Exercise 15 - Animation
 * This program animates a rectangle moving along the outline of a pentagon. The user is able to resume/pause the animation with
 * a click on the left/right mouse buttons. The recatangle's opacity changes as it moves around the pentagon.
 * 
 * */

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.FadeTransition;

public class Animation extends Application{

	@Override
	public void start(Stage primaryStage) {
		
		
		// Create a pane
		Pane pane = new Pane();
		
		// Create a rectangle object
		Rectangle rectangle = new Rectangle(0,0,25,50);
		rectangle.setFill(Color.BLUE);
		
		// Apply fade transition to rectangle
		FadeTransition ft = new FadeTransition (Duration.millis(3000), rectangle);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play();
		
		// Create pentagon
		Polygon pentagon = new Polygon();
		
		ObservableList<Double> list = pentagon.getPoints();
		
		final double width = 200;
		final double height = 200;
		double centerX = width/2;
		double centerY = height/2;
		double radius = Math.min(width,  height)*0.4;
		
		for (int i = 0; i < 5; i++) {
			list.add(centerX+radius*Math.cos((2*i*Math.PI/5)-(Math.PI/5)));
			list.add(centerY+radius*Math.sin(2*i*Math.PI/5-Math.PI/5));
		}
		
		pentagon.setFill(Color.WHITE);
		pentagon.setStroke(Color.BLACK);
		pentagon.setRotate(18);
		
		
		// Add pentagon and rectangle to the pane
		pane.getChildren().addAll(pentagon,rectangle);
		
		// Create a path transition
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(pentagon);
		pt.setNode(rectangle);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		pt.play();   // Start animation
		
		
		// Play and Pause on Left and Right mouse click
		pentagon.setOnMouseClicked(e -> {
			if(e.getButton() == MouseButton.PRIMARY) {
				pt.play();
			}
			else if (e.getButton() == MouseButton.SECONDARY) {
				pt.pause();
			}
		});
		
		
		// create scene and place it in the pane
		Scene scene = new Scene(pane,200,200);
		primaryStage.setTitle("PathTransitionDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
