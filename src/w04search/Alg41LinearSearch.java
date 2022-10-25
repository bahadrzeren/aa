package w04search;

/**
 * 
 * @author bahadr
 *
 */
public class Alg41LinearSearch {

	private static int[] inputs = {1, 7, 9, 2, 8, 3, 5, 4, 10};

	private static int findItem(int value) {
		for (int i = 0; i < inputs.length; i++)	//	n + 1
			if (inputs[i] == value)				//	n
				return i;
		return -1;
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * T(n) = 2n+1	=>	O(n)
	 * 
	 */

	public static void main(String[] args) {
		for (int searchValue : inputs)
			System.out.println(searchValue + " index = " + findItem(searchValue));
	}
}
