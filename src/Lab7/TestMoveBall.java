/* Class: CS1302-03
 * Name: Ethan Nguyen
 * Lab: Lab7
 * Instructor: Monisha Verma
 */
package Lab7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TestMoveBall extends Application 
{

	//create ballPane object
	private BallPane ballPane = new BallPane();
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception 
	{
		// TODO Auto-generated method stub
		//create the window with buttons
		HBox hBox = new HBox(5); 
		hBox.setAlignment(Pos.CENTER);
		Button btLeft = new Button("Left");
		Button btRight = new Button("Right");
		Button btUp = new Button("Up");
		Button btDown = new Button("Down");
		hBox.getChildren().addAll(btLeft, btRight, btUp, btDown);
		
		//Create and register the handler
		btLeft.setOnAction(e -> ballPane.left());
		btRight.setOnAction(e -> ballPane.right());
		btUp.setOnAction(e -> ballPane.up());
		btDown.setOnAction(e -> ballPane.down());
		
		//create a border pane 
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(0, 10, 5, 10));
		pane.setCenter(ballPane);
		pane.setBottom(hBox);
		
		//create a scene and place it in stage
		Scene scene = new Scene(pane, 250, 250);
		arg0.setTitle("15.3 - Move the Ball");
		arg0.setScene(scene);
		arg0.show();
	}

}
