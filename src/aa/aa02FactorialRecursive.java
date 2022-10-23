package aa;

/**
 * 
 * @author bahadr
 *
 */
public class aa02FactorialRecursive {

	public static int[] inputs = {1, 2, 3, 5, 10};

	public static int getFactorial(int n) {
		if (n == 1)							//	1
			return 1;
		return n * getFactorial(n - 1);		//	T(n - 1)
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * T(n) = 1 + T(n - 1)
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
