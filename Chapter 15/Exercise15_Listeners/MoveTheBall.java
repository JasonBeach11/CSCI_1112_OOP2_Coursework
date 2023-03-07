/**
 * Author: Jason Beach
 * Date: March 1st, 2023
 * 
 * CSCI 1112 Exercise 15 - Listeners
 * This program creates a ball in a pane. The ball can be moved left, right, up, and down
 * with the use of 4 buttons clicked by the mouse.
 * 
 * */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MoveTheBall extends Application{
	
	@Override
	public void start (Stage primaryStage) {
		
		Circle circle = new Circle(150,150,30);
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
		
		Pane pane = new Pane();
		pane.getChildren().add(circle);
		
		
		// Create buttons
		HBox buttons = new HBox(10);
		buttons.setSpacing(10);
		buttons.setAlignment(Pos.BOTTOM_CENTER);
		Button btLeft = new Button("Left");
		Button btRight = new Button("Right");
		Button btUp = new Button("Up");
		Button btDown = new Button("Down");
		
		
		// Lambda expressions
		btLeft.setOnAction(e -> {
			if (circle.getCenterX() > 30) {
			circle.setCenterX(circle.getCenterX()-20);
			}
			else {
				System.out.println("Error");
			}
		});
		
		
		btRight.setOnAction(e -> {
			if (circle.getCenterX() < 270) {
				circle.setCenterX(circle.getCenterX()+20);
				}
				else {
					System.out.println("Error");
				}
		});
		
		
		btUp.setOnAction(e -> {
			if (circle.getCenterY() > 30) {
				circle.setCenterY(circle.getCenterY()-20);
				}
				else {
					System.out.println("Error");
				}
		});
		
		
		btDown.setOnAction(e -> {
			if (circle.getCenterY() < 270) {
				circle.setCenterY(circle.getCenterY()+20);
				}
				else {
					System.out.println("Error");
				}
		});
		
		
		// Add buttons to HBox
		buttons.getChildren().addAll(btLeft, btRight, btUp, btDown);
		
		// Create Border Pane and add elements
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(buttons);
		//borderPane.setAlignment(buttons, Pos.CENTER);
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 300, 300);
		primaryStage.setTitle("Move The Ball");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	// Main Method
	public static void main(String[] args) {
		launch(args);
	}
	

}
