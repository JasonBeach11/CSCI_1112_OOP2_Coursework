/**
 * Author: Jason Beach
 * Date: 3/7/23
 * CSCI 1112: Exercise 16-1 
 * This program uses buttons to move a message left and right and uses radio buttons to change
 * the color of the text. Text should not move off the pane.
 * */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class RadioButtons extends Application{
	
	Text text = new Text(140, 50, "Programming is fun");
	
	protected BorderPane getPane() {
		
		HBox paneForButtons = new HBox(20);
		Button btRight = new Button("=>");
		Button btLeft = new Button("<=");
		
		paneForButtons.getChildren().addAll(btLeft, btRight);
		paneForButtons.setAlignment(Pos.CENTER);
		paneForButtons.setStyle("-fx-border-color: purple");
		
		BorderPane pane = new BorderPane();
		pane.setBottom(paneForButtons);
		
		Pane paneForText = new Pane();
		paneForText.getChildren().addAll(text);
		pane.setCenter(paneForText);
		
		// Right button movement (Do not allow text to move off pane)
		btRight.setOnAction(e -> {
			if (text.getX() < 280) {
				text.setX(text.getX() + 20);
				}
		});
		
		// Left button movement (Do not allow text to move off pane)
		btLeft.setOnAction(e -> {
			if (text.getX() > 0) {
				text.setX(text.getX() - 20);
				}
		});
		
		// Create radio buttons
		HBox paneForRadioButtons = new HBox(20);
		RadioButton rbRed = new RadioButton("Red");
		RadioButton rbYellow = new RadioButton("Yellow");
		RadioButton rbBlack = new RadioButton("Black");
		RadioButton rbOrange = new RadioButton("Orange");
		RadioButton rbGreen = new RadioButton("Green");
		
		// Create Toggle Group for radio buttons
		ToggleGroup group = new ToggleGroup();
		rbRed.setToggleGroup(group);
		rbYellow.setToggleGroup(group);
		rbBlack.setToggleGroup(group);
		rbOrange.setToggleGroup(group);
		rbGreen.setToggleGroup(group);
		
		// Set action for radio buttons
		rbRed.setOnAction(e -> {
			if (rbRed.isSelected()) {
				text.setFill(Color.RED);
			}
		});
		
		rbYellow.setOnAction(e -> {
			if (rbYellow.isSelected()) {
				text.setFill(Color.YELLOW);
			}
		});
		
		rbBlack.setOnAction(e -> {
			if (rbBlack.isSelected()) {
				text.setFill(Color.BLACK);
			}
		});
		
		rbOrange.setOnAction(e -> {
			if (rbOrange.isSelected()) {
				text.setFill(Color.ORANGE);
			}
		});
		
		rbGreen.setOnAction(e -> {
			if (rbGreen.isSelected()) {
				text.setFill(Color.GREEN);
			}
		});
		
		// Add radio buttons to pane
		paneForRadioButtons.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
		paneForRadioButtons.setAlignment(Pos.CENTER);
		paneForRadioButtons.setStyle("-fx-border-color: purple");
		
		pane.setTop(paneForRadioButtons);
		
		return pane;
	}
	
	@Override
	public void start (Stage primaryStage) {
		
		Scene scene = new Scene(getPane(), 385, 150);
		primaryStage.setTitle("Exercise 16_1");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
