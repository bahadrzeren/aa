package w13dp;

/**
 * 
 * @author bahadr
 *
 */
public class Alg95BinaryKnapsackDP {

	/*
	 * Greedy problem: Given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
	 * In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively.
	 * Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that the sum of the weights of this subset is smaller than or equal to W.
	 * You cannot break an item, either pick the complete item or don’t pick it (0-1 property)
	 * 
	 */

	private static int knapsack(int capacity, int val[], int wt[]) {

		int[] dp = new int[capacity + 1];	// making and initializing dp array
 
        for (int i = 0; i < wt.length; i++) {
            for (int w = capacity; w >= 0; w--) {
                if (wt[i] <= w)
                	dp[w] = Math.max(dp[w], dp[w - wt[i]] + val[i]);
            }
        }

        return dp[capacity]; // returning the maximum value of knapsack
	}

/*
 * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0]
 * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60,  60]
 * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 160, 160, 160, 160, 160, 160, 160, 160, 160, 160, 160, 160, 160, 160, 160, 160, 160, 160, 160, 160, 160]
 * [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 160, 160, 160, 160, 160, 160, 160, 160, 160, 160, 180, 180, 180, 180, 180, 180, 180, 180, 180, 180, 220]
 * 
 */

	public static void main(String[] args) {
	    int values[] = new int[] {60, 100, 120};
	    int weights[] = new int[] {10, 20, 30};
	    int capacity = 50;

		System.out.println(knapsack(capacity, values, weights));
	}
}
