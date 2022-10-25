package w04search;

/**
 * 
 * @author bahadr
 *
 */
public class Alg43BinarySearchRecursive {

	private static int[] inputs = {1,3,4,8,10,13,19,20,25,29,30,32,36,37,41,44,49,50,52,53,56,58,59,63,66};

	private static int findItem(int value, int lo, int hi) {
		if (lo < hi) {
			int mid = (lo + hi) / 2;
			if (inputs[mid] == value)
				return mid;
			else
				if (inputs[mid] > value)
					return findItem(value, lo, mid - 1);
				else
					return findItem(value, mid + 1, hi);
		}
		if (inputs[hi] == value)
			return hi;
		return -1;
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * T(n) = T(n/2) + c
	 * 		= T(n/4) + 2 * c
	 * 		= T(n/8) + 3 * c
	 * 		= T(n/16) + 4 * c
	 * 		~ T(0) + log2(n) * c
	 * 
	 *  =>	O(log2(n))
	 * 
	 */

	public static void main(String[] args) {
		int lo = 0;
		int hi = inputs.length - 1;

		for (int searchValue : inputs)
			System.out.println(searchValue + " index = " + findItem(searchValue, lo, hi));
		System.out.println(64 + " index = " + findItem(64, lo, hi));
	}
}
