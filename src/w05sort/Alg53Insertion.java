package w05sort;

/**
 * 
 * @author bahadr
 *
 */
public class Alg53Insertion {

	private static int[] inputs = {78, 35, 10, 81, 88, 14, 1, 7, 43, 28, 67, 55, 92, 36, 24, 49, 51, 62, 99, 71};

	/*
	 * 78 35 10 81 88 14 1 7 43 28 67 55 92 36 24 49 51 62 99 71
	 * 35 78 10 81 88 14 1 7 43 28 67 55 92 36 24 49 51 62 99 71 
	 * 10 35 78 81 88 14 1 7 43 28 67 55 92 36 24 49 51 62 99 71 
	 * 10 35 78 81 88 14 1 7 43 28 67 55 92 36 24 49 51 62 99 71 
	 * 10 35 78 81 88 14 1 7 43 28 67 55 92 36 24 49 51 62 99 71 
	 * 10 14 35 78 81 88 1 7 43 28 67 55 92 36 24 49 51 62 99 71 
	 * 1 10 14 35 78 81 88 7 43 28 67 55 92 36 24 49 51 62 99 71 
	 * ...
	 * 1 7 10 14 24 28 35 36 43 49 51 55 62 67 71 78 81 88 92 99 
	 */

	private static void sort() {
		for (int i = 1; i < inputs.length; i++) {
			int elementToSort = inputs[i];
			int j = i - 1;
			while ((j >= 0) && (inputs[j] > elementToSort)) {
				if (inputs[j] > inputs[j + 1]) {
					inputs[j + 1] = inputs[j];
					j--;
				}
				inputs[j + 1] = elementToSort;
			}
		}
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		sort();
		for (int value : inputs)
			System.out.print(value + " ");
	}
}
