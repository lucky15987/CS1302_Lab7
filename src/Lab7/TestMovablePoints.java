/* Class: CS1302-03
 * Name: Ethan Nguyen
 * Lab: Lab7
 * Instructor: Monisha Verma
 */
package Lab7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TestMovablePoints extends Application
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception 
	{
		// TODO Auto-generated method stub
		//create a pane
		Pane pane = new Pane();
		
		
		//create two circles
		Circle circle1 = new Circle(40, 40, 10); //circle1
		setProperties(circle1);
		
		Circle circle2 = new Circle(120, 150, 10); //circle2
		setProperties(circle2);
		
		//place nodes in pane
		pane.getChildren().addAll(getLine(circle1, circle2), circle1, circle2, getText(circle1, circle2));
		
		//Create and register the handle. if one circle moves the other reacts
		pane.setOnMouseDragged(e -> 
		{
			if (circle1.contains(e.getX(), e.getY()))
					{
						pane.getChildren().clear();
						circle1.setCenterX(e.getX());
						circle1.setCenterY(e.getY());
						pane.getChildren().addAll(getLine(circle1, circle2), circle1, circle2, getText(circle1, circle2));
					}
			else if (circle2.contains(e.getX(), e.getY()))
			{
				pane.getChildren().clear();
				circle2.setCenterX(e.getX());
				circle2.setCenterY(e.getY());
				pane.getChildren().addAll(getLine(circle1, circle2), circle1, circle2, getText(circle1, circle2));
			}
		});
		
		//create a scene
		Scene scene = new Scene(pane, 200, 200);
		arg0.setTitle("15.16: Two Movable Vertices and thier distances");
		arg0.setScene(scene);
		arg0.show();
	}

	//other methods for the text and circles
	private Text getText(Circle circle1, Circle circle2) 
	{
		// TODO Auto-generated method stub
		return new Text((circle1.getCenterX() + circle2.getCenterX()) / 2, 
				(circle1.getCenterY() + circle2.getCenterY()) / 2,
						distance(circle1, circle2));
	}

	//calculates the distance between the two points
	private String distance(Circle circle1, Circle circle2) 
	{
		// TODO Auto-generated method stub
		double distance = Math.sqrt(Math.pow(circle2.getCenterX() - circle1.getCenterX(), 2) +
				Math.pow(circle2.getCenterY() - circle1.getCenterY(), 2)) - 20;
		return String.format("%.0f", distance);
	}

	private Line getLine(Circle circle1, Circle circle2) 
	{
		// TODO Auto-generated method stub
		return new Line(circle1.getCenterX(), circle1.getCenterY(), circle2.getCenterX(), circle2.getCenterY());
	}

	private void setProperties(Circle circle) 
	{
		// TODO Auto-generated method stub
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		
	}

}
