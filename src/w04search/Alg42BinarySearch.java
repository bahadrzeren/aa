package w04search;

/**
 * 
 * @author bahadr
 *
 */
public class Alg42BinarySearch {

	public static int[] inputs = {1,3,4,8,10,13,19,20,25,29,30,32,36,37,41,44,49,50,52,53,56,58,59,63,66};

	public static int findItem(int value) {
		int lo = 0;							//	1
		int hi = inputs.length - 1;			//	1

		while (lo < hi) {					//	log2(n) + 1
			int mid = (lo + hi) / 2;		//	log2(n)
			if (inputs[mid] == value)		//	log2(n)
				return mid;
			else
				if (inputs[mid] > value)
					hi = mid - 1;
				else
					lo = mid + 1;
		}
		if (inputs[hi] == value)			//	1
			return hi;
		return -1;
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * T(n) ~ 3log2(n) + 4	=>	O(log2(n))
	 * 
	 */

	public static void main(String[] args) {
		for (int searchValue : inputs)
			System.out.println(searchValue + " index = " + findItem(searchValue));
		System.out.println(64 + " index = " + findItem(64));
	}
}
