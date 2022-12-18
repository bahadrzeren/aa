package w12greedy;

/**
 * 
 * @author bahadr
 *
 */
public class Alg125Job {
	private char id = 0;
	private int deadline = 0;
	private int profit = 0;

	public Alg125Job(char id, int deadline, int profit) {
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}

	public char getId() {
		return id;
	}

	public int getDeadline() {
		return deadline;
	}

	public int getProfit() {
		return profit;
	}
}
