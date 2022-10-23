package aa;

/**
 * 
 * @author bahadr
 *
 */
public class aa03FibonacciLinear {

	public static int[] inputs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

	public static int getFibonacci(int n) {
		if (n == 0)											//	1
			return 0;
		int previousValue = 0;								//	1
		int activeValue = 1;								// 	1
		for (int i = 2; i <= n; i++) {						//	n
			int tempValue = previousValue + activeValue;	//	n - 1
			previousValue = activeValue;					//	n - 1
			activeValue = tempValue;						//	n - 1
		}
		return activeValue;									//	1
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * T(n) = 4n+1	=>	O(n)
	 * 
	 */

	public static void main(String[] args) {
		for (int inputValue : inputs)
			System.out.println(inputValue + "th fibonacci = " + getFibonacci(inputValue));
	}
}
