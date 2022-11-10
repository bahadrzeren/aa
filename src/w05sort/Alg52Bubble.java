package w05sort;

/**
 * 
 * @author bahadr
 *
 */
public class Alg52Bubble {

	private static int[] inputs = {78, 35, 10, 81, 88, 14, 1, 7, 43, 28, 67, 55, 92, 36, 24, 49, 51, 62, 99, 71};

	/*
	 * 78 35 10 81 88 14 1 7 43 28 67 55 92 36 24 49 51 62 99 71
	 * 35 10 78 81 14 1 7 43 28 67 55 88 36 24 49 51 62 92 71 99 
	 * 10 35 78 14 1 7 43 28 67 55 81 36 24 49 51 62 88 71 92 99 
	 * 10 35 14 1 7 43 28 67 55 78 36 24 49 51 62 81 71 88 92 99 
	 * 10 14 1 7 35 28 43 55 67 36 24 49 51 62 78 71 81 88 92 99 
	 * 10 1 7 14 28 35 43 55 36 24 49 51 62 67 71 78 81 88 92 99 
	 * ...
	 * 1 7 10 14 24 28 35 36 43 49 51 55 62 67 71 78 81 88 92 99 
	 */
	private static void sort() {
		for (int i = 0; i < inputs.length - 1; i++) {			//	n
			boolean swapped = false;							//	n-1
			for (int j = 0; j < inputs.length - i - 1; j++) {	//	(n-1)*n/2 + n-1
				if (inputs[j] > inputs[j + 1]) {				//	(n-1)*n/2
					int tempValue = inputs[j];
					inputs[j] = inputs[j + 1];
					inputs[j + 1] = tempValue;
					swapped = true;
				}
			}
			if (!swapped)										//	n-1
				break;
		}
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * T(n) ~ n^2+2n-1
	 * 
	 * => O(n^2)
	 * 
	 */

	public static void main(String[] args) {
		sort();
		for (int value : inputs)
			System.out.print(value + " ");
	}
}
