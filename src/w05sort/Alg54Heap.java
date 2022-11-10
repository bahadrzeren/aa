package w05sort;

/**
 * 
 * @author bahadr
 *
 */
public class Alg54Heap {

	private static int[] inputs = {78, 35, 10, 81, 88, 14, 1, 7, 43, 28, 67, 55, 92, 36, 24, 49, 51, 62, 99, 71};

	/*
	 * 78 35 10 81 88 14 1 7 43 28 67 55 92 36 24 49 51 62 99 71
	 * 78 35 10 81 88 14 1 7 43 71 67 55 92 36 24 49 51 62 99 28
	 * 78 35 10 81 88 14 1 7 99 71 67 55 92 36 24 49 51 62 43 28
	 * 78 35 10 81 88 14 1 51 99 71 67 55 92 36 24 49 7 62 43 28
	 * 78 35 10 81 88 14 36 51 99 71 67 55 92 1 24 49 7 62 43 28
	 * 78 35 10 81 88 92 36 51 99 71 67 55 14 1 24 49 7 62 43 28
	 * 78 35 10 99 88 92 36 51 81 71 67 55 14 1 24 49 7 62 43 28
	 * 78 35 92 99 88 10 36 51 81 71 67 55 14 1 24 49 7 62 43 28
	 * 78 35 92 99 88 55 36 51 81 71 67 10 14 1 24 49 7 62 43 28
	 * 78 99 92 35 88 55 36 51 81 71 67 10 14 1 24 49 7 62 43 28
	 * 78 99 92 81 88 55 36 51 35 71 67 10 14 1 24 49 7 62 43 28
	 * 78 99 92 81 88 55 36 51 62 71 67 10 14 1 24 49 7 35 43 28
	 * 99 78 92 81 88 55 36 51 62 71 67 10 14 1 24 49 7 35 43 28
	 * 99 88 92 81 78 55 36 51 62 71 67 10 14 1 24 49 7 35 43 28
	 * Built
	 * 99|88 92|81 78 55 36|51 62 71 67 10 14 1 24|49 7 35 43 28 
	 * Sort
	 * 88 92|81 78 55 36|51 62 71 67 10 14 1 24|49 7 35 43 28 99
	 * ...
	 * 1 7 10 14 24 28 35 36 43 49 51 55 62 67 71 78 81 88 92 99 
	 */

	private static void heapify(int len, int parentPosition) {
		while (true) {
			int leftChildPosition = 2 * parentPosition + 1;
			int rightChildPosition = 2 * parentPosition + 2; 
			int largestPosition = parentPosition;

			// If left child is larger than root
			if ((leftChildPosition < len) && (inputs[leftChildPosition] > inputs[largestPosition]))
				largestPosition = leftChildPosition;
 
			// If right child is larger than largest so far
			if ((rightChildPosition < len) && (inputs[rightChildPosition] > inputs[largestPosition]))
				largestPosition = rightChildPosition;
 
			// If largest is not root
			if (largestPosition == parentPosition) {
				break;
			} else {
				int swap = inputs[parentPosition];
				inputs[parentPosition] = inputs[largestPosition];
				inputs[largestPosition] = swap;
				parentPosition = largestPosition;
			}
		}
	}

	private static void sort() {
		//	Build
		for (int i = inputs.length / 2 - 1; i >= 0; i--)	//	~ n/2
			heapify(inputs.length, i);						//	~ n/2*log2(n)

		//	Sort
		for (int i = inputs.length - 1; i > 0; i--) {		//	n
			int temp = inputs[0];							//	n-1
			inputs[0] = inputs[i];							//	n-1
			inputs[i] = temp;								//	n-1
 
			heapify(i, 0);									//	~ n*log2(n)
		}
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * T(n) ~ 3/2n*log2(n)+9/2n-3
	 * 
	 * => O(n*log2(n))
	 * 
	 */

	public static void main(String[] args) {
		sort();
		for (int value : inputs)
			System.out.print(value + " ");
	}
}
