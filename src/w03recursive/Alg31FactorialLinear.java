package w03recursive;

/**
 * 
 * @author bahadr
 *
 */
public class Alg31FactorialLinear {

	public static int[] inputs = {1, 2, 3, 5, 10};

	public static int getFactorial(int n) {
		int returnValue = 1;			//	1
		for (int i = 2; i <= n; i++)	//	n
			returnValue *= i;			//	n - 1
		return returnValue;				//	1
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * T(n) = 2n+1	=>	O(n)
	 * 
	 */

	public static void main(String[] args) {
		for (int inputValue : inputs)
			System.out.println(inputValue + "! = " + getFactorial(inputValue));
	}
}
