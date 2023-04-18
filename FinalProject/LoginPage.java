/**
 * @author Jason Beach
 * Date: 04/17/2023
 * CSCI 1112 Object Oriented Programming 2
 * FINAL PROJECT
 * Inventory Management Program - Default login info for this program is "admin" and "password". This program is an
 * inventory manager for a local axe-throwing business to help them manage their kitchen inventory. Each time one of the
 * Menu Item buttons is pressed, the appropriate number of ingredients is removed from the ingredient inventory list.
 * */

// Import required libraries
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPage extends Application{

	// Define "correct" username and password
	private static final String ADMINUSERNAME = "admin";
	private static final String ADMINPASSWORD = "password";
	
	// Define start method for the Login Page
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Iron Grill Login");
		
		// Create grid pane layout
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(25,25,25,25));
		gridPane.setBackground(new Background(new BackgroundFill(Color.rgb(245, 245, 245), CornerRadii.EMPTY, Insets.EMPTY)));
		
		Text sceneTitle = new Text("Iron Grill Inventory Management");
		sceneTitle.setFont(Font.font("Veranda", FontWeight.BOLD, 24));
		sceneTitle.setFill(Color.rgb(102, 102,102));
		gridPane.add(sceneTitle, 0, 0,2,1);
		
		//  Add Username label and text field
		TextField userTextField = new TextField();
		Label userName = new Label("Username:");
		userName.setFont(Font.font("Veranda", FontWeight.NORMAL, 14));
		userName.setTextFill(Color.rgb(102, 102, 102));
		gridPane.add(userName, 0, 1);
		gridPane.add(userTextField, 1, 1);
		
		// Add Password label and text field
		PasswordField pwBox = new PasswordField();
		Label userPassword = new Label("Password:");
		userPassword.setFont(Font.font("Veranda", FontWeight.NORMAL, 14));
		userPassword.setTextFill(Color.rgb(102, 102, 102));
		gridPane.add(userPassword, 0, 2);
		gridPane.add(pwBox, 1, 2);
		
		// Add Login button
		Button loginBtn = new Button("Login");
		loginBtn.setFont(Font.font("Veranda", FontWeight.NORMAL, 14));
		loginBtn.setTextFill(Color.WHITE);
		loginBtn.setStyle("-fx-background-color: #4CAF50; -fx-border-radius: 5px; -fx-background-radius: 5px;");
		gridPane.add(loginBtn, 1, 4);
		
		// Add "Incorrect username or password" text
		final Text incorrectLogin = new Text();
		incorrectLogin.setFill(Color.rgb(190, 10, 10));
		gridPane.add(incorrectLogin, 1, 6);
		
		// Add "Successful Login" text
		final Text loginSuccess = new Text();
		loginSuccess.setFill(Color.rgb(102, 102, 102));
		gridPane.add(loginSuccess, 1, 6);
		
		// Add Iron Axe logo to Login page
		Image logo = new Image("https://static.wixstatic.com/media/616172_d518f0c53597411c9579b4cfad99f812~mv2.png"
        		+ "/v1/fill/w_221,h_222,al_c,q_85,usm_0.66_1.00_0.01,enc_auto/Iron%252520Axe_edited_edited.png");
		ImageView imageView = new ImageView(logo);
		HBox hBox = new HBox(imageView);
		imageView.setFitHeight(90);
		imageView.setPreserveRatio(true);
		hBox.setAlignment(Pos.BOTTOM_RIGHT);
		hBox.setPadding(new Insets(0,0,10,0));
		gridPane.add(hBox, 1, 7);
		
		
		// Set action for the Login button
		loginBtn.setOnAction(e ->{
			// Retrieve user-entered username and password from text fields
			String enteredUserName = userTextField.getText();
			String enteredPassword = pwBox.getText();
			
			// Check if username and password are correct
			if(validate(enteredUserName, enteredPassword)) {
				// Login Success - Redirect user to main page
				incorrectLogin.setText("");
				loginSuccess.setText("Login Success");
				
				//Open Inventory Manager and close Login window
				InventoryManager inventoryManager = new InventoryManager();
				inventoryManager.start(primaryStage);
			}
			else {
				// Display login error
				incorrectLogin.setText("Incorrect username or password");
			}
		});
		
		// Set action when user presses ENTER button
		gridPane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				String enteredUserName = userTextField.getText();
				String enteredPassword = pwBox.getText();
			
				if(validate(enteredUserName, enteredPassword)) {
					// Login Success - Redirect user to main page
					incorrectLogin.setText("");
					loginSuccess.setText("Login Success");
					
					//Open Inventory Manager and close Login window
					InventoryManager inventoryManager = new InventoryManager();
					inventoryManager.start(primaryStage);
				}
				else {
					// Display login error
					incorrectLogin.setText("Incorrect username or password");
				}
			}
		});
		
		// Set the scene and set it in the stage
		Scene scene = new Scene(gridPane, 400, 325);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	} // End Start
	
	
	/** Validate correct username and password combination */
	public boolean validate(String username, String password) {
		
		if(username.equals(ADMINUSERNAME) && password.equals(ADMINPASSWORD)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Define the main method to launch the application
    public static void main(String[] args) {
        launch(args);
   
    }
	
} // End LoginPage Class
