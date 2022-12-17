package w11hw;

/**
 * 
 * @author bahadr
 *
 */
public class Alg12LongestCommonPrefix {

	private static String[] inputs = {"flow", "flower", "flowable", "flowery", "flowed", "float", "flour", "flood"};

	/*
	 * Divide and conquer
	 */

	private static String getIntersection(String s1, String s2) {
		String result = "";															//	1
        for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++) {		//	m+1
            if (s1.charAt(i) != s2.charAt(j))										//	m
                break;
            result += s1.charAt(i);													//	m
        }
        return result;																//	1
	}

	private static String getCommonPrefix(int left, int right) {
        if (left == right) {						//	1
            return inputs[left];
        }

		if (left < right) {							//	1
			int mid = left + (right - left) / 2;	//	1
 
			String cs1 = getCommonPrefix(left, mid);						//	n/2
			String cs2 = getCommonPrefix(mid + 1, right);					//	n/2

			return getIntersection(cs1, cs2);				//	a.m + b		//	m is the max length of string items exist in the input array.
		}
		return null;
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * T(n) ~ 3 + 2*T(n/2) + a.m + b
	 * 		~ 9 + 4*T(n/4) + 3*(a.m + b)
	 * 		~ 21 + 8*T(n/8) + 7*(a.m + b)
	 * 		...
	 * 		~ 3*(2^k-1) + 2^k*T(n/2^k) + (2^k-1)*(a*m+b)	//	m is the possible max length of string items exist in the input array.
	 * 
	 * k = log2(n) =>
	 * 
	 * 		~ 3*(n-1) + n*T(1) + (n-1)*(a*m+b)
	 * 
	 * => O(n*m)
	 */

	public static void main(String[] args) {
		System.out.print("Longest common prefix is: " + getCommonPrefix(0, inputs.length - 1));
	}
}
