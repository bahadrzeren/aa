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
		int temp = inputs[i];
		inputs[i] = inputs[j];
		inputs[j] = temp;
	}

	static int partition(int left, int right) {
		int pivot = inputs[right];

		int i = left;
  
		for (int j = left; j < right; j++) {
			if (inputs[j] < pivot) {
				swap(i, j);
				i++;
			}
		}
		swap(i, right);
		return i;
	}

	private static void sort(int left, int right) {
		if (left < right) {
			int partitionNdx = partition(left, right);
			sort(left, partitionNdx - 1);
			sort(partitionNdx + 1, right);
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
