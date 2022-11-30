package w05sort;

/**
 * 
 * @author bahadr
 *
 */
public class Alg56Quick {

	private static int[] inputs = {78, 35, 10, 81, 88, 14, 1, 7, 43, 28, 67, 55, 92, 36, 24, 49, 51, 62, 99, 71};

	/*
	 * Divide and conquer
	 * 
	 * 78 35 10 81 88 14 1 7 43 28 67 55 92 36 24 49 51 62 99 71
	 * 
	 * 35 10 14 1 7 43 28 67 55 36 24 49 51 62 71 78 92 81 99 88 
	 * 
	 * ...
	 * 
	 * 1 7 10 14 24 28 35 36 43 49 51 55 62 67 71 78 81 88 92 99 
	 */

	private static void swap(int i, int j) {
		int temp = inputs[i];					//	1
		inputs[i] = inputs[j];					//	1
		inputs[j] = temp;						//	1
	}

	private static int partition(int left, int right) {
		/*
		 * 4n + 7
		 */
		int pivot = inputs[right];				//	1

		int i = left;							//	1
  
		for (int j = left; j < right; j++) {	//	n+1
			if (inputs[j] < pivot) {			//	n
				swap(i, j);						//	n
				i++;							//	n
			}
		}
		swap(i, right);							//	3
		return i;								//	1
	}

	private static void sort(int left, int right) {
		if (left < right) {
			int partitionNdx = partition(left, right);	//	a.n + b
			sort(left, partitionNdx - 1);				//	n/2
			sort(partitionNdx + 1, right);				//	n/2
		}
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * T(n) ~ 2*T(n/2) + a.n + b
	 * 		~ 4*T(n/4) + 2a.n + 3b
	 * 		~ 8*T(n/8) + 3a.n + 7b
	 * 		...
	 * 		~ 2^k*T(n/2^k) + k*a*n + (2^k-1)*b
	 * 
	 * k = log2(n) =>
	 * 
	 * 		~ n*T(1) + a*n*log2(n) + (n-1)*b
	 * 
	 * => O(n*log2(n))
	 */

	public static void main(String[] args) {
		sort(0, inputs.length - 1);
		for (int value : inputs)
			System.out.print(value + " ");
	}
}
