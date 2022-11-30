package w09dandc;

/**
 * 
 * @author bahadr
 *
 */
public class Alg93Point {
	private int x = 0;
	private int y = 0;
	public Alg93Point(int x, int y) {
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

	public static double distance(Alg93Point p1, Alg93Point p2) {
	    return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) +
                			(p1.y - p2.y) * (p1.y - p2.y));
	}
}
