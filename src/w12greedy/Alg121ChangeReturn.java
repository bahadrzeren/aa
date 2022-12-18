package w12greedy;

/**
 * 
 * @author bahadr
 *
 */
public class Alg121ChangeReturn {

	/*
	 * Greedy problem: You have to make a change of an amount using the smallest possible number of coins.
	 * 
	 * Note: There is no limit to the number of each coin you can use.
	 */

	private static int[] coinsAvailable = {5, 2, 1};

	private static int[] coinsToBeReturned(int totalReturnValue) {
		int[] result = new int[coinsAvailable.length];
	
		int sum = 0;

		while (sum != totalReturnValue) {
			for (int i = 0; i < coinsAvailable.length; i++) {								//	Greedy choice property.
				double numsNeeded = (1.0 * (totalReturnValue - sum)) / coinsAvailable[i];
				if (numsNeeded >= 1.0) {
					result[i] = (int) Math.floor(numsNeeded);
					sum += result[i] * coinsAvailable[i];
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] coinsToReturn = coinsToBeReturned(13);
		for (int i = 0; i < coinsToReturn.length; i++) {
			if (coinsToReturn[i] > 0)
				System.out.println(coinsToReturn[i] + " number of " + coinsAvailable[i] + "$ coins");
		}
	}
}
