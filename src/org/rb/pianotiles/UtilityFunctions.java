package org.rb.pianotiles;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.rb.pianotiles.ds.PointPosition;

/**
 * Just putting in functions that will be used often.
 * @author RB
 *
 */
public class UtilityFunctions {

	/**
	 * Reads the config file and extracts the coordinates of the rectangle.
	 * @return
	 */
	public static int[] loadConfiguration(){
		int[] values = new int[4];
		int cnt = 0;
		try{
			FileReader fileReader = new FileReader("positions.conf");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			while((line = bufferedReader.readLine())!=null){
				if(line.contains("#") || line.trim().equals("")){
					continue;
				}
				else{
					values[cnt] = Integer.parseInt(line.trim());
					cnt++;
				}
			}
			bufferedReader.close();
			fileReader.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		return values;
	}
	
	/**
	 * Given the values of x1,x2,y1,y2, this function gives the four points of the rectangle.
	 * @param values
	 * @return
	 */
	public static ArrayList<PointPosition> getRectangleCoordinates(int[] values){
		ArrayList<PointPosition> corners = new ArrayList<PointPosition>();
		int x1,x2,y1,y2;
		x1 = values[0];
		x2 = values[1];
		y1 = values[2];
		y2 = values[3];
		corners.add(new PointPosition(x1, y1));
		corners.add(new PointPosition(x1, y2));
		corners.add(new PointPosition(x2, y2));
		corners.add(new PointPosition(x2, y1));
		return corners;
	}
	
	/**
	 * This gives the coordinates of the points that have to be clicked and examined. 
	 * The second row in the piano tiles app.
	 * @param values
	 * @param numberOfTiles
	 * @return
	 */
	public static ArrayList<PointPosition> getActiveSetPoints(int[] values, int numberOfTiles){
		ArrayList<PointPosition> activeSet = new ArrayList<PointPosition>();
		int x1,x2,y1,y2;
		x1 = values[0];
		x2 = values[1];
		y1 = values[2];
		y2 = values[3];
		int delta1 = (x2-x1)/numberOfTiles;
		int delta2 = (y1-y2)/numberOfTiles;
		
		int x = x1 + delta1/2;
		int y = y1 - (3*delta2)/2;
		
		for(int i=0;i<numberOfTiles;i++){
			activeSet.add(new PointPosition(x, y));
			x += delta1;
		}
		
		return activeSet;
	}
	
	/**
	 * Get the black tile. Just check for something with colors with low values.
	 * @param points
	 * @return
	 */
	public static int getActiveTile(ArrayList<PointPosition> points){
		int blackTile = 0;
		int threshold = 100;
		while(blackTile<points.size()){
			Color color = MouseActions.getPointColor(points.get(blackTile));
			if((color.getRed()<threshold)&&(color.getBlue()<threshold)&&(color.getGreen()<threshold)){
				break;
			}
			blackTile++;
		}
		return blackTile;
	}
}
