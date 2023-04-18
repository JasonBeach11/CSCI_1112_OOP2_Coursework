
import javafx.application.Application;
import javafx.collections.FXCollections;
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
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class InventoryManager extends Application{

	// Create inventory of kitchen items (in the future, this will be organized in a database)
	double tortillaChipsInventory = 5;  // number of bags
	double shreddedBeefInventory = 5;  // number of lbs
	double cheeseSauceInventory = 5;  // number of lbs
	double shreddedCheeseInventory = 5;  // number of lbs
	double picoInventory = 8;  // number of ounces
	double sourCreamInventory = 8;  // number of ounces
	double guacamoleInventory = 8;  // number of ounces
	double pretzelInventory = 5;  // number of units
	double pigWingsInventory = 20; // number of units
	double bunsInventory = 24;  // number of units
	double coleslawInventory = 8;  // number of ounces
	double waffleInventory = 5;  // number of units
	double iceCreamInventory = 32; // number of ounces
	
	ListView<String> listView;
	// Define start method for the Login Page
	@Override
	public void start(Stage secondaryStage) {
		
		// Title for the secondary stage
				secondaryStage.setTitle("Iron Grill Inventory Manager");
		
		// Create Observable List to hold Inventory Items
		ObservableList<String> items = FXCollections.observableArrayList(
				"Tortilla Chips....." + tortillaChipsInventory,
				"Shredded Beef....." + shreddedBeefInventory,
				"Cheese Sauce....." + cheeseSauceInventory,
				"Shredded Cheese....." + shreddedCheeseInventory,
				"Pico....." + picoInventory,
				"Sour Cream....." + sourCreamInventory,
				"Guacamole....." + guacamoleInventory,
				"Pretzel....." + pretzelInventory,
				"Pig Wings....." + pigWingsInventory,
				"Buns....." + bunsInventory,
				"Coleslaw....." + coleslawInventory,
				"Waffle....." + waffleInventory,
				"Ice Cream....." + iceCreamInventory);
		
		listView = new ListView<>(items);
		Label inventoryLabel = new Label("CURRENT INVENTORY");
		inventoryLabel.setFont(Font.font("Veranda", FontWeight.NORMAL, 14));
		inventoryLabel.setTextFill(Color.rgb(102, 102, 102));
		VBox listBox = new VBox();
		listBox.getChildren().addAll(inventoryLabel, listView);
		
		
		
		// Create a grid pane to hold elements
		GridPane gridPane = new GridPane();
		gridPane.setHgap(2);
		gridPane.setVgap(10);
		
		// VBox to hold Menu item buttons
		VBox buttonBox = new VBox(10);
		Label menuItems = new Label("MENU ITEMS");
		menuItems.setFont(Font.font("Veranda", FontWeight.NORMAL, 14));
		menuItems.setTextFill(Color.rgb(102, 102, 102));
		
		// Create buttons for Menu Item Sales
		Button nachosBtn = new Button("Nachos");
		nachosBtn.setFont(Font.font("Veranda", FontWeight.NORMAL, 14));
		nachosBtn.setTextFill(Color.WHITE);
		nachosBtn.setStyle("-fx-background-color: #4CAF50; -fx-border-radius: 5px; -fx-background-radius: 5px;");
		
		Button pretzelBtn = new Button("Pretzel");
		pretzelBtn.setFont(Font.font("Veranda", FontWeight.NORMAL, 14));
		pretzelBtn.setTextFill(Color.WHITE);
		pretzelBtn.setStyle("-fx-background-color: #4CAF50; -fx-border-radius: 5px; -fx-background-radius: 5px;");
		
		Button pigWingsBtn = new Button("Pig Wings");
		pigWingsBtn.setFont(Font.font("Veranda", FontWeight.NORMAL, 14));
		pigWingsBtn.setTextFill(Color.WHITE);
		pigWingsBtn.setStyle("-fx-background-color: #4CAF50; -fx-border-radius: 5px; -fx-background-radius: 5px;");
		
		Button slidersBtn = new Button("Sliders");
		slidersBtn.setFont(Font.font("Veranda", FontWeight.NORMAL, 14));
		slidersBtn.setTextFill(Color.WHITE);
		slidersBtn.setStyle("-fx-background-color: #4CAF50; -fx-border-radius: 5px; -fx-background-radius: 5px;");
		
		Button waffleBtn = new Button("Waffle Desert");
		waffleBtn.setFont(Font.font("Veranda", FontWeight.NORMAL, 14));
		waffleBtn.setTextFill(Color.WHITE);
		waffleBtn.setStyle("-fx-background-color: #4CAF50; -fx-border-radius: 5px; -fx-background-radius: 5px;");
		
		buttonBox.getChildren().addAll(menuItems, nachosBtn, pretzelBtn, pigWingsBtn, slidersBtn, waffleBtn);
		gridPane.add(buttonBox, 5, 5);
		gridPane.add(listBox, 50, 5);
		gridPane.setPadding(new Insets(30,30,30,30));
		
		
		// ACTION HANDLERS FOR BUTTON PRESSES
		// Set action for Nachos
		nachosBtn.setOnAction(e -> {
			tortillaChipsInventory -= .5;
			shreddedBeefInventory -= .25;
			cheeseSauceInventory -=.25;
			shreddedCheeseInventory -=.25;
			picoInventory -= .2;
			sourCreamInventory -= .2;
			guacamoleInventory -=.2;
			updateList(listBox);
		}
		);
		// Set action for Pretzel
		pretzelBtn.setOnAction(e ->{
			pretzelInventory -= 1;
			updateList(listBox);
		});
		// Set action for Pig Wings
		pigWingsBtn.setOnAction(e ->{
			pigWingsInventory -= 4;
			updateList(listBox);
		});
		// Set action for Sliders
		slidersBtn.setOnAction(e ->{
			bunsInventory -= 3;
			shreddedBeefInventory -= .25;
			coleslawInventory -= .2;
			updateList(listBox);
		});
		// Set action for Waffle
		waffleBtn.setOnAction(e ->{
			waffleInventory -= 1;
			iceCreamInventory -= .4;
			updateList(listBox);
		});
		
		// Create the scene and add it to the stage
		Scene scene = new Scene(gridPane, 500, 500);
		secondaryStage.setScene(scene);
		secondaryStage.show();
	}
	
	/** Update list of Inventory Items */
	private void updateList(VBox listBox) {
		listBox.getChildren().remove(listView);
		ObservableList<String> items = FXCollections.observableArrayList(
				"Tortilla Chips....." + tortillaChipsInventory,
				"Shredded Beef....." + shreddedBeefInventory,
				"Cheese Sauce....." + cheeseSauceInventory,
				"Shredded Cheese....." + shreddedCheeseInventory,
				"Pico....." + picoInventory,
				"Sour Cream....." + sourCreamInventory,
				"Guacamole....." + guacamoleInventory,
				"Pretzel....." + pretzelInventory,
				"Pig Wings....." + pigWingsInventory,
				"Buns....." + bunsInventory,
				"Coleslaw....." + coleslawInventory,
				"Waffle....." + waffleInventory,
				"Ice Cream....." + iceCreamInventory);
		
		listView = new ListView<>(items);
		listBox.getChildren().addAll(listView);
	}
	
}
