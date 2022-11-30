package w09dandc;

import java.util.Comparator;

/**
 * 
 * @author bahadr
 *
 */
public class Alg93PointXComparator implements Comparator<Alg93Point> {

	@Override
	public int compare(Alg93Point o1, Alg93Point o2) {
		return Integer.compare(o1.getX(), o2.getX());
	}

}
