package org.rb.pianotiles;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.rb.pianotiles.ds.PointPosition;

/**
 * Perform all the required mouse actions like clicking and checking for color over here.
 * @author RB
 *
 */
public class MouseActions {

	/**
	 * Simple function. Moves to a point and clicks it.
	 * @param point
	 */
	public static void clickPosition(PointPosition point){
		try{
			Robot robot = new Robot();
			robot.mouseMove(point.getX(), point.getY());
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Color getPointColor(PointPosition point){
		Color color = null;
		try{
			Robot robot = new Robot();
			color = robot.getPixelColor(point.getX(), point.getY());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return color;
	}
	
}
