package w03recursive;

/**
 * 
 * @author bahadr
 *
 */
public class Alg32FactorialRecursive {

	private static int[] inputs = {1, 2, 3, 5, 10, 11};

	private static int getFactorial(int n) {
		if (n == 1)							//	1
			return 1;
		return n * getFactorial(n - 1);		//	T(n - 1)
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * T(n) = 1 + T(n - 1)
	 * 		= 2 + T(n - 2)
	 * 		= 3 + T(n - 3)
	 * 		...
	 * 		= n + T(0)
	 * 		= n + c		=>	O(n)
	 * 
	 * where c = constant.
	 */

	public static void main(String[] args) {
		for (int inputValue : inputs)
			System.out.println(inputValue + "! = " + getFactorial(inputValue));
	}
}
