package w12greedy;

import java.util.Arrays;

/**
 * 
 * @author bahadr
 *
 */
public class Alg123MaxProdSubset {

	/*
	 * Greedy problem: Given an array a, we have to find the maximum product possible with the subset of elements present in the array.
	 * 
	 * Note: The minimum product can be a single element also.
	 */

	private static int minProductSubset(int[] a) {
		if (a.length == 1)
			return a[0];

		int maxNegative = Integer.MIN_VALUE;

		int countNegatives = 0;
		int countPositives = 0;
		int countZeros = 0;

		int product = 1;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				countZeros++;
			} else {
				if (a[i] < 0) {
					countNegatives++;
					if (maxNegative < a[i])
						maxNegative = a[i];
				} else
					if (a[i] > 0)
						countPositives++;
				product *= a[i];
			}
		}

		if ((countZeros == a.length)
				|| ((countPositives == 0)
						&& (countZeros > 0)))
			return 0;

		if (countPositives == 0)
			return maxNegative;

		if ((countNegatives % 2 == 1)
				&& (countNegatives != 0))
			product /= maxNegative;

		return product;
	}

	public static void main(String[] args) {
		int[] a = {-1, -1, -2, 4, 3};
		System.out.println(Arrays.toString(a) + " = " + minProductSubset(a));

		int[] b = {-1, -1, -2, 0};
		System.out.println(Arrays.toString(b) + " = " + minProductSubset(b));

		int[] c = {-1, -2, 0, 2};
		System.out.println(Arrays.toString(c) + " = " + minProductSubset(c));

		int[] d = {1, 2, 0};
		System.out.println(Arrays.toString(d) + " = " + minProductSubset(d));
	}
}
