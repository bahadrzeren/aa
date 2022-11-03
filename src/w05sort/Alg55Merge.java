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
		int lenLeft = mid - left + 1;
		int lenRight = right - mid;

		int arrLeft[] = new int[lenLeft];
		int arrRight[] = new int[lenRight];

		for (int i = 0; i < lenLeft; i++)
			arrLeft[i] = inputs[left + i];
		for (int j = 0; j < lenRight; j++)
			arrRight[j] = inputs[mid + 1 + j];

		int i = 0;
		int j = 0;
 
		int k = left;
		while ((i < lenLeft) && (j < lenRight)) {
			if (arrLeft[i] <= arrRight[j]) {
				inputs[k] = arrLeft[i];
				i++;
			} else {
				inputs[k] = arrRight[j];
				j++;
			}
			k++;
		}
 
		// Copy remaining elements
		while (i < lenLeft) {
			inputs[k] = arrLeft[i];
			i++;
			k++;
		}

		// Copy remaining elements
		while (j < lenRight) {
			inputs[k] = arrRight[j];
			j++;
			k++;
		}
	}

	private static void sort(int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
 
			sort(left, mid);
			sort(mid + 1, right);

			merge(left, mid, right);
		}
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		sort(0, inputs.length - 1);
		for (int value : inputs)
			System.out.print(value + " ");
	}
}
