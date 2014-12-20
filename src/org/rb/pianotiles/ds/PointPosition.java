package org.rb.pianotiles.ds;

/**
 * Just a simple datastructure for points.
 * @author RB
 *
 */
public class PointPosition {
	
	/**
	 * The X-Coordinate of the point.
	 */
	private int x;
	
	/**
	 * The Y-Coordinate of the point.
	 */
	private int y;

	public PointPosition(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "PointPosition [x=" + x + ", y=" + y + "]";
	}
	
	public void translatePoint(int xTrans, int yTrans){
		x += xTrans;
		y += yTrans;
	}

}
