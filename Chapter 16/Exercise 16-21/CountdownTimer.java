/*
 * Author: Jason Beach
 * Date: 03/13/2023
 * CSCI 1112: Exercise 16-21
 * Count Down Stopwatch. This program takes a number entered by the user and counts down from that number to 0.
 * When the seconds are expired, the program plays music continuously.
 * **/

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class CountdownTimer extends Application {

    int startTime = 5;
    private Timeline timeline;
    private Label timerLabel = new Label();
    private IntegerProperty timeSeconds = new SimpleIntegerProperty(startTime);

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Count-down Stopwatch");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);
        
        // Create Text Field for timer input
        TextField tf = new TextField();
        tf.setAlignment(Pos.CENTER);
        tf.setPrefWidth(40);
        tf.setMaxWidth(40);
        
        // Create media object (Use provided URL for audio)
        MediaPlayer mediaPlayer = new MediaPlayer(new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3"));
        
        // Set timer to number entered by user
        tf.setOnKeyReleased(event -> {
        	if(event.getCode() == KeyCode.ENTER) {
        		startTime = Integer.parseInt(tf.getText());
        	}
        	
        	if (timeline != null) {
                timeline.stop();
            }
        	
            timeSeconds.set(startTime);
            timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(startTime+1), new KeyValue(timeSeconds, 0)));
            timeline.playFromStart();
            
            // Play media file when timer is finished
            timeline.setOnFinished(event2 -> {
            	System.out.println("ALARM!!");
            	mediaPlayer.play();
            });
        });
        
        // Bind the timerLabel text property to the timeSeconds property
        timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.PURPLE);
        timerLabel.setStyle("-fx-font-size: 4em;");
        
        VBox vb = new VBox(20);
        vb.setAlignment(Pos.CENTER);

        vb.setPrefWidth(scene.getWidth());
        vb.getChildren().addAll(tf, timerLabel);
        vb.setLayoutY(30);

        root.getChildren().add(vb);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
  
    public static void main(String[] args) {
        Application.launch(args);
    }
}
