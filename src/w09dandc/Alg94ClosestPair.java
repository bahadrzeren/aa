package w09dandc;

import java.util.Arrays;

/**
 * 
 * @author bahadr
 *
 */
public class Alg94ClosestPair {

	public static double bruteForce(Alg93Point[] p,
									int startIndexIncl,
									int endIndexExc) {
		double min = Double.MAX_VALUE;							//	1
		double currMin = 0;										//	1
		for (int i = startIndexIncl; i < endIndexExc; i++) {	//	3+1
			for (int j = i + 1; j < endIndexExc; j++) {			//	3*4/2+3
				currMin = Alg93Point.distance(p[i], p[j]);		//	3*4/2
				if (currMin < min)								//	3*4/2
					min = currMin;								//	3*4/2
			}
		}
		return min;												//	1
	}

	public static double stripClosest(Alg93Point[] strip, int size, double d) {
		double min = d;

		for (int i = 0; i < size; i++) {															//	n+1
			for (int j = i + 1; j < size && (strip[j].getY() - strip[i].getY()) < min; j++) {		//	n*O(1)+n
				if (Alg93Point.distance(strip[i], strip[j]) < min)									//	n*O(1)
					min = Alg93Point.distance(strip[i], strip[j]);									//	n*O(1)
			}
		}

		return min;
	}

	public static double closest(Alg93Point[] px,
									Alg93Point[] py,
									int startIndexIncl,
									int endIndexExc) {
		if ((endIndexExc - startIndexIncl) <= 3)					//	1
	    	return bruteForce(px, startIndexIncl, endIndexExc);		//	34

		int mid = startIndexIncl + (endIndexExc - startIndexIncl) / 2;		//	1
		Alg93Point midPoint = px[mid];										//	1

	    double dl = closest(px, py, startIndexIncl, mid);				//	n/2
	    double dr = closest(px, py, mid, endIndexExc);					//	n/2

	    double d = Math.min(dl, dr);								//	1

	    Alg93Point[] strip = new Alg93Point[endIndexExc];			//	1
	    int j = 0;													//	1
	    for (int i = 0; i < endIndexExc; i++) {						//	n+1
	    	if (Math.abs(py[i].getX() - midPoint.getX()) < d) {		//	n
	    		strip[j] = py[i];									//	n
	    		j++;												//	n
	    	}
	    }

	    return Math.min(d, stripClosest(strip, j, d));				//	O(n)
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * T(n) ~ 2*T(n/2) + a.n + b
	 * 		~ 4*T(n/4) + 2a.n + 3b
	 * 		~ 8*T(n/8) + 3a.n + 7b
	 * 		...
	 * 		~ 2^k-1 + 2^k*T(n/2^k) + k*a*n + (2^k-1)*b
	 * 
	 * k = log2(n) =>
	 * 
	 * 		~ n-1 + n*T(1) + a*n*log2(n) + (n-1)*b
	 * 
	 * => O(n*log2(n))
	 */

	public static void main(String[] args) {
	    Alg93Point px[] = new Alg93Point[]{new Alg93Point(5, 1),
											new Alg93Point(3, 4),
	    									new Alg93Point(40, 50),
	    									new Alg93Point(12, 10),
	    									new Alg93Point(2, 3),
	    									new Alg93Point(12, 30)};
	    Alg93Point py[] = px.clone();

	    System.out.println("The smallest distance is " + bruteForce(px, 0, px.length));	//	n^2

	    Arrays.sort(px, new Alg93PointXComparator());	//	n.log2(n)
	    Arrays.sort(py, new Alg93PointYComparator());	//	n.log2(n)
	    System.out.println("The smallest distance is " + closest(px, py, 0, px.length));	//	n.log2(n)
	}
}
