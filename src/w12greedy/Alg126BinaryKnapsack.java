package w12greedy;

/**
 * 
 * @author bahadr
 *
 */
public class Alg126BinaryKnapsack {

	/*
	 * Greedy problem: Given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
	 * In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively.
	 * Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that the sum of the weights of this subset is smaller than or equal to W.
	 * You cannot break an item, either pick the complete item or don’t pick it (0-1 property)
	 * 
	 */

	private static int knapsack(int capacityLeft, int v[], int w[], int size) {

		if ((capacityLeft == 0)
				|| (size == 0))
			return 0;

		if (w[size - 1] > capacityLeft)
			return knapsack(capacityLeft, v, w, size - 1);
		else
			return Math.max(v[size-1] + knapsack(capacityLeft - w[size-1], v, w, size-1),
										knapsack(capacityLeft, v, w, size-1));
	}

    private static int values[] = new int[] {60, 100, 120};
    private static int weights[] = new int[] {10, 20, 30};
    private static int capacity = 50;

	public static void main(String[] args) {
		System.out.println(knapsack(capacity, values, weights, values.length));
	}
}
