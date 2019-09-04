/* Class: CS1302-03
 * Name: Ethan Nguyen
 * Lab: Lab7
 * Instructor: Monisha Verma
 */
package Lab7;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BallPane extends Pane
{
	//Create Circle 
	private Circle circle = new Circle(20, 20, 20);
	
	//construct a pane for the circle
	public BallPane()
	{
		//color settings
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		getChildren().add(circle);   //add circle into pane
	}
	
	//move ball left
	public void left()
	{
		//conditional statement where if the xPos is > current radius to move xPos -20 units else just get the xPos
		circle.setCenterX(circle.getCenterX() > circle.getRadius() ? 
				circle.getCenterX() - 20 : circle.getCenterX());
		
		circle.setCenterY(circle.getCenterY());  //keep yPos same
	}
	
	//move ball right
	public void right()
	{
		//same as left but in the case of if the xPos is less than the current width minus radius
		circle.setCenterX(circle.getCenterX() < getWidth() - circle.getRadius() ?
				circle.getCenterX() + 20 : circle.getCenterX());
		
		circle.setCenterY(circle.getCenterY());  //keep yPos same
	}
	
	//move ball up
	public void up()
	{
		//conditional statement where if yPos is > radius move yPos up -20 units else keep yPos
		circle.setCenterY(circle.getCenterY() > circle.getRadius() ? 
				circle.getCenterY() - 20 : circle.getCenterY());
		
		circle.setCenterX(circle.getCenterX());
		
	}
	
	//move ball down
	public void down()
	{
		circle.setCenterY(circle.getCenterY() < getHeight() - circle.getRadius() ?
				circle.getCenterY() + 20 : circle.getCenterY());
	}
}
