package w12greedy;

import java.util.Arrays;

/**
 * 
 * @author bahadr
 *
 */
public class Alg124ActivitySelection {

	/*
	 * Greedy problem: You are given n activities with their start and finish times. Select the maximum number of activities 
	 * that can be performed by a single person, assuming that a person can only work on a single activity at a time.
	 * 
	 */

//	private static int[] start = {10, 12, 20};
//	private static int[] finish = {20, 25, 30};			//	Sorted according to finish times.

	private static int[] start = {1, 3, 0, 5, 8, 5};
	private static int[] finish = {2, 4, 6, 7, 9, 9};			//	Sorted according to finish times.

	private static String printSelectedActivities(int[] s, int[] f) {
		String result = "0";	//	The first activity always gets selected!

		int ndx = 0;
		for (int i = 1; i < s.length; i++)
			if (s[i] >= f[ndx]) {
				result += " " + i;
				ndx = i;
			}

		return result;
	}

	public static void main(String[] args) {

		System.out.println(Arrays.toString(start) + " -> " + Arrays.toString(finish) + " = " + printSelectedActivities(start, finish));
	}
}
