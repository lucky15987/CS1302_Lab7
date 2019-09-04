/* Class: CS1302-03
 * Name: Ethan Nguyen , Michael Noels
 * Lab: Lab7
 * Instructor: Monisha Verma
 */
package Lab7;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TestRaceCar extends Application
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		// TODO Auto-generated method stub
		try
		{
			//pane for image
			Pane pane1 = new Pane();
			
			
			
			//create oval
			Ellipse ellipse = new Ellipse(240, 140, 200, 95);
			ellipse.setStroke(Color.TRANSPARENT);
			ellipse.setFill(Color.TRANSPARENT);
					
			//Images
			ImageView mustang = new ImageView("Mustang.jpg");
			mustang.setFitWidth(50);
		    mustang.setFitHeight(50);
		    
		    ImageView car = new ImageView("Car.jpg");
		    
		    //add images to pane
		    pane1.getChildren().addAll(car, mustang);
			
			
		    
			//create a path transition
			PathTransition pt = new PathTransition();
			pt.setDuration(Duration.millis(2000));
			pt.setPath(ellipse);
			pt.setNode(mustang);
			pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt.setCycleCount(Timeline.INDEFINITE);
			pt.setAutoReverse(false);
			pt.play();
			
			
			//create HBox
			HBox hBox = new HBox(5);
			hBox.setAlignment(Pos.CENTER);			
			Button btStop = new Button("Stop");
			Button btResume = new Button("Resume");
			hBox.getChildren().addAll(btStop, btResume);			
			btStop.setOnAction(e -> pt.stop());
			btResume.setOnAction(e -> pt.play());
			
			
			//create a border pane 
			BorderPane pane = new BorderPane();
			pane.setCenter(pane1);
			pane.setBottom(hBox);
			
			
			
			
			
			//create the scene
			Scene scene = new Scene(pane, 500, 300);
			primaryStage.setTitle("RaceCar");
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch (Exception ex)
		{
			System.out.println("Image not Found bro");
		}
	}	

}
