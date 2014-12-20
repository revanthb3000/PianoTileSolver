package org.rb.pianotiles;

import java.util.ArrayList;

import org.rb.pianotiles.ds.PointPosition;

public class MainClass {
	
	public static void main(String[] args) throws InterruptedException{
		int[] values = UtilityFunctions.loadConfiguration();
		ArrayList<PointPosition> activeSetPoints = UtilityFunctions.getActiveSetPoints(values, 4);
		int numberOfIterations = 100;
		System.out.println("Make the Blustacks window active !");
		Thread.sleep(5000);
		for(int i=0;i<numberOfIterations;i++){
			int activeTile = UtilityFunctions.getActiveTile(activeSetPoints);
			while(activeTile==4){
				activeTile = UtilityFunctions.getActiveTile(activeSetPoints);
			}
			//System.out.println(activeTile);
			MouseActions.clickPosition(activeSetPoints.get(activeTile));
			Thread.sleep(200);
		}
	}

}
