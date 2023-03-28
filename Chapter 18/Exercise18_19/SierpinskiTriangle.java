/**
 * @author Jason Beach
 * Date: 3/27/2023
 * CSCI 1112: Exercise 18-19
 * This program creates a Sierpinski triangle and allows the user to increase/decrease the order of the triangle with the use
 * of "+" and "-" buttons.
 * */
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class SierpinskiTriangle extends Application{
	
	@Override	// Override the start method in the Application Class
	public void start(Stage primaryStage) {
		SierpinskiTrianglePane trianglePane = new SierpinskiTrianglePane();
		
		// Create buttons increase/decrease order
		HBox paneForButtons = new HBox(10);
		Button btMinus = new Button("-");
		Button btPlus = new Button("+");
		paneForButtons.getChildren().addAll(btMinus, btPlus);
		paneForButtons.setAlignment(Pos.CENTER);
		
		btMinus.setOnAction(e -> trianglePane.decreaseOrder());
		btPlus.setOnAction(e -> trianglePane.increaseOrder());
		
		// Pane to hold triangle and buttons
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(trianglePane);
		borderPane.setBottom(paneForButtons);
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 400, 400);
		primaryStage.setTitle("SierpinskiTriangle");	// Set the stage title
		primaryStage.setScene(scene);					// Place the scene in the stage
		primaryStage.show();							// Display the stage
		
		trianglePane.paint();
		scene.widthProperty().addListener(ov -> trianglePane.paint());
		scene.heightProperty().addListener(ov -> trianglePane.paint());
		
	} 
	
	
	/** Sierpinski Triangle Pane Object*/
	static class SierpinskiTrianglePane extends Pane{
		
		private int order = 0;
		
		/** Increases order when '+' button is clicked */
		public void increaseOrder() {
			this.order = order + 1;
			paint();
		}
		
		
		/** Decreases order when "-" button is clicked */
		public void decreaseOrder() {
			if (this.order == 0) {
			paint();
			}
			else {
				this.order = order -1;
				paint();
			}
		}
		
		
		/** No-arg constructor for SierpinskiTrianglePane object*/
		SierpinskiTrianglePane(){
		}
		
		
		/** Paint the Sierpinski Triangle */
		protected void paint() {
			// Select three points in proportion to the pane size
			Point2D p1 = new Point2D(getWidth() / 2, 10);
			Point2D p2 = new Point2D(10, getHeight() - 10);
			Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);
			
			this.getChildren().clear();		// Clear the pane before re-displaying
			
			displayTriangles(order, p1, p2, p3);
		}
		
		
		/** Display Triangles*/
		private void displayTriangles(int order, Point2D p1, Point2D p2, Point2D p3) {
			if (order == 0) {
				// Draw a triangle to connect three points
				Polygon triangle = new Polygon();
				triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
				triangle.setStroke(Color.BLACK);
				triangle.setFill(Color.WHITE);
				
				this.getChildren().add(triangle);
			}
			else {
				// Get the midpoint on each edge in the triangle
				Point2D p12 = p1.midpoint(p2);
				Point2D p23 = p2.midpoint(p3);
				Point2D p31 = p3.midpoint(p1);
				
				// Recursively display three triangles
				displayTriangles(order - 1, p1, p12, p31);
				displayTriangles(order - 1, p12, p2, p23);
				displayTriangles(order - 1, p31, p23, p3);
			}
		}
	} // End SierpinskiTranglePane Class
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
