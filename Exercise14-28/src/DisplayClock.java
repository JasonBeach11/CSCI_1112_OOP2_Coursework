/**
 * Author: Jason Beach
 * Date: 02/23/2023
 * 
 * CSCI 1112: Exercise 14-28
 * This program creates an analog clock to display the time. 
 * The set methods are used to make only the hour and minute hands visible. The hour and minute values
 * are randomly generated. The hour is between 0 and 11, and the minute is either 0 or 30.
 * 
 * */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class DisplayClock extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		// Create a clock and a label
		ClockPane clock = new ClockPane();
		
		String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
		Label lblCurrentTime = new Label(timeString);
		
		// Make hour and minute hands on clock visible
		clock.setHourVisible(true);
		clock.setMinuteVisible(true);
		
		
		// Place clock and label in border pane
		BorderPane pane = new BorderPane();
		pane.setCenter(clock);
		pane.setBottom(lblCurrentTime);
		BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
		
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 250);
		primaryStage.setTitle("DisplayClock");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main (String[] args) {
		launch(args);
	}
	
}
