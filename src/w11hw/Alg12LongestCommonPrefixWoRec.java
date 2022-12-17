package w11hw;

/**
 * 
 * @author bahadr
 *
 */
public class Alg12LongestCommonPrefixWoRec {

	private static String[] inputs = {"flow", "flower", "flowable", "flowery", "flowed", "float", "flour", "flood"};

	private static String getCommonPrefix(String s1, String s2) {
		String result = "";															//	1
        for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++) {		//	m+1
            if (s1.charAt(i) != s2.charAt(j))										//	m
                break;
            result += s1.charAt(i);													//	m
        }
        return result;																//	1
	}

	public static void main(String[] args) {
		String longestCommonPrefix = inputs[0];									//	1
		for (int i = 1; i < inputs.length; i++) {								//	n+1
			String s = inputs[i];												//	n
			longestCommonPrefix = getCommonPrefix(longestCommonPrefix, s);		//	n*(a.m+b)
		}
		System.out.print("Longest common prefix is: " + longestCommonPrefix);	//	1
	}
}
