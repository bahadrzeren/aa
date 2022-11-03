package w05sort;

/**
 * 
 * @author bahadr
 *
 */
public class Alg51Selection {

	private static int[] inputs = {78, 35, 10, 81, 88, 14, 1, 7, 43, 28, 67, 55, 92, 36, 24, 49, 51, 62, 99, 71};

	/*
	 * 78 35 10 81 88 14 1 7 43 28 67 55 92 36 24 49 51 62 99 71
	 * 1 35 10 81 88 14 78 7 43 28 67 55 92 36 24 49 51 62 99 71 
	 * 1 7 10 81 88 14 78 35 43 28 67 55 92 36 24 49 51 62 99 71 
	 * 1 7 10 81 88 14 78 35 43 28 67 55 92 36 24 49 51 62 99 71 
	 * 1 7 10 14 88 81 78 35 43 28 67 55 92 36 24 49 51 62 99 71 
	 * 1 7 10 14 24 81 78 35 43 28 67 55 92 36 88 49 51 62 99 71 
	 * ...
	 * 1 7 10 14 24 28 35 36 43 49 51 55 62 67 71 78 81 88 92 99 
	 */
	private static void sort() {
		for (int i = 0; i < inputs.length - 1; i++) {
			int minValueNdx = i;
			for (int j = i + 1; j < inputs.length; j++)
				if (inputs[j] < inputs[minValueNdx])
					minValueNdx = j;
			int tempValue = inputs[i];
			inputs[i] = inputs[minValueNdx];
			inputs[minValueNdx] = tempValue;
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
