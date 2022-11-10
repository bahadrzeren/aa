package w06hw;

/**
 * 
 * @author bahadr
 *
 */
public class Alg61SubstringSearch {

	private static boolean search(String mainString, String subString) {
		byte[] mainStringBytes = mainString.getBytes();
		byte[] subStringBytes = subString.getBytes();

		int subStringNdx = 0;											//	1
		for (int i = 0; i < mainStringBytes.length; i++) {				//	n+1
			if (mainStringBytes[i] == subStringBytes[subStringNdx])		//	n
				subStringNdx++;											//	n/2
			else
				subStringNdx = 0;										//	n/2
			if (subStringNdx == subStringBytes.length)					//	n
				return true;
		}
		return false;
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * T(N) = 4n+2
	 * 
	 * => O(n)
	 * 
	 */


	public static void main(String args[]) {
		System.out.println(search("Istanbul Ankara Izmir", "Izm"));
	}
}
