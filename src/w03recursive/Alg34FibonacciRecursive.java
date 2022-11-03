package w03recursive;

/**
 * 
 * @author bahadr
 *
 */
public class Alg34FibonacciRecursive {

	private static int[] inputs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

	private static int getFibonacci(int n) {
		if (n == 0)											//	1
			return 0;
		if (n == 1)											//	1
			return 1;
		return getFibonacci(n - 1) + getFibonacci(n - 2);	//	T(n - 1) + T(n - 2)
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * T(n) = T(n - 1) + T(n - 2) + c
	 * 		~ 2 * T(n - 1) + c
	 * 		~ 2 * [2 * T(n - 2) + c] + c
	 * 		~ 2^2 * T(n - 2) + 3 * c
	 * 		~ 2^2 * [2 * T(n - 3) + c] + 3 * c
	 * 		~ 2^3 * T(n - 3) + 7 * c
	 * 		...
	 * 		~ 2^k * T(n - k) + (2^k - 1) * 2
	 * 
	 * 	if k=n		=>		T(n) = 2^n * T(0) + (2^n - 1) * c
	 * 
	 *  =>	O(2^n)
	 * 
	 * where c = constant.
	 */

	public static void main(String[] args) {
		for (int inputValue : inputs)
			System.out.println(inputValue + "th fibonacci = " + getFibonacci(inputValue));
	}
}
