package w12greedy;

/**
 * 
 * @author bahadr
 *
 */
public class Alg126KnapsackItem {
	private int value = 0;
	private int weight = 0;

	public Alg126KnapsackItem(int val, int wt) {
		this.weight = wt;
		this.value = val;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
