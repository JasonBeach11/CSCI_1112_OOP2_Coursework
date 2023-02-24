/**
 * Author: Jason Beach
 * Date: 2/21/2023
 * CSCI 1112: Exercise 14 - 15
 * 
 * This program uses JavaFX to display a stop sign.
 * 
 * */
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.layout.StackPane;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.scene.control.*;

public class StopSign extends Application {
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {   
		
		StackPane pane = new StackPane();
		
		//Create Polygon
		pane.getChildren().add(new MyPolygon());
		
		// Create Label and set its properties
		Label label = new Label ("STOP");
		label.setFont(Font.font("Times New Roman", 90));
		label.setStyle("-fx-text-fill: white");
		pane.getChildren().add(label);
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 400, 400);
		primaryStage.setTitle("Stop Sign"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
	}
	
	
	// Main Method
	public static void main(String[] args) {
		launch(args);
	}
}

// MyPolygon class
class MyPolygon extends StackPane {
	
	private void paint() {
		
		// Create a polygon and place polygon to pane
		Polygon sign = new Polygon();
		sign.setFill(Color.RED);
		sign.setStroke(Color.BLACK);
		
		// Rotate Sign
		sign.setRotate(22.5);
		ObservableList<Double> list = sign.getPoints();
		
		double centerX = getWidth() / 2, centerY = getHeight() / 2;
		double radius = Math.min(getWidth(), getHeight()) * 0.4;

		// s is the number of sides the polygon has (a stop sign has 8 sides)
		int s = 8;
		
		// Add points to the polygon list
		for (int i = 0; i < s; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / s)); 
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
		}     
		
		getChildren().clear();
		getChildren().add(sign); 
	}
	
	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		paint();
	}
	
	@Override
	public void setHeight(double height) {
		super.setHeight(height);
		paint();
	}
}
