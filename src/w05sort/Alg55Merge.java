package w05sort;

/**
 * 
 * @author bahadr
 *
 */
public class Alg55Merge {

	private static int[] inputs = {78, 35, 10, 81, 88, 14, 1, 7, 43, 28, 67, 55, 92, 36, 24, 49, 51, 62, 99, 71};

	/*
	 * Divide and conquer
	 * 
	 * 78 35 10 81 88 14 1 7 43 28 67 55 92 36 24 49 51 62 99 71
	 * 
	 * ...
	 * 
	 * 1 7 10 14 24 28 35 36 43 49 51 55 62 67 71 78 81 88 92 99 
	 */

	private static void merge(int left, int mid, int right) {
		/*
		 * 7n + 14
		 */
		int lenLeft = mid - left + 1;					//	1
		int lenRight = right - mid;						//	1

		int arrLeft[] = new int[lenLeft];				//	1
		int arrRight[] = new int[lenRight];				//	1

		for (int i = 0; i < lenLeft; i++)				//	n/2 + 1
			arrLeft[i] = inputs[left + i];				//	n/2
		for (int j = 0; j < lenRight; j++)				//	n/2 + 1
			arrRight[j] = inputs[mid + 1 + j];			//	n/2

		int i = 0;										//	1
		int j = 0;										//	1

		int k = left;									//	1
		while ((i < lenLeft) && (j < lenRight)) {		//	n
			if (arrLeft[i] <= arrRight[j]) {			//	n - 1
				inputs[k] = arrLeft[i];					//	n/2 - 1/2
				i++;									//	n/2 - 1/2
			} else {
				inputs[k] = arrRight[j];				//	n/2 - 1/2
				j++;									//	n/2 - 1/2
			}
			k++;										//	n - 1
		}
 
		// Copy remaining elements
		while (i < lenLeft) {							//	1/2 + 1
			inputs[k] = arrLeft[i];						//	1/2
			i++;										//	1/2
			k++;										//	1/2
		}

		// Copy remaining elements
		while (j < lenRight) {							//	1/2 + 1
			inputs[k] = arrRight[j];					//	1/2
			j++;										//	1/2
			k++;										//	1/2
		}
	}

	private static void sort(int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;	//	1
 
			sort(left, mid);						//	n/2
			sort(mid + 1, right);					//	n/2

			merge(left, mid, right);				//	a.n + b
		}
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * T(n) ~ 1 + 2*T(n/2) + a.n + b
	 * 		~ 3 + 4*T(n/4) + 2a.n + 3b
	 * 		~ 7 + 8*T(n/8) + 3a.n + 7b
	 * 		...
	 * 		~ 2^k-1 + 2^k*T(n/2^k) + k*a*n + (2^k-1)*b
	 * 
	 * k = log2(n) =>
	 * 
	 * 		~ n-1 + n*T(1) + a*n*log2(n) + (n-1)*b
	 * 
	 * => O(n*log2(n))
	 */

	public static void main(String[] args) {
		sort(0, inputs.length - 1);
		for (int value : inputs)
			System.out.print(value + " ");
	}
}
