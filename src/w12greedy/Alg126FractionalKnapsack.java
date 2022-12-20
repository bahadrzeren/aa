package w12greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author bahadr
 *
 */
public class Alg126FractionalKnapsack {

	/*
	 * Greedy problem: Given the weights and values of N items, in the form of {value, weight} put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
	 * In Fractional Knapsack, we can break items for maximizing the total value of the knapsack.
	 * 
	 */

	private static double knapsack(int capacity, Alg126KnapsackItem[] items) {
		Arrays.sort(items, new Comparator<Alg126KnapsackItem>() {
            @Override
            public int compare(Alg126KnapsackItem item1, Alg126KnapsackItem item2) {
                double cpr1 = ((1.0) * item1.getValue()) / item1.getValue();
                double cpr2 = ((1.0) * item2.getValue()) / item2.getValue();
                 if (cpr1 < cpr2)
                    return 1;
                else
                    return -1;
            }
        });

		double totalValue = 0.0;

        for (Alg126KnapsackItem item : items) {
            if (capacity - item.getWeight() >= 0) {
                capacity = capacity - item.getWeight();
                totalValue += item.getValue();
            } else {
                double fraction = (1.0 * capacity) / item.getWeight();
                totalValue += (item.getValue() * fraction);
                capacity = (int)(capacity - (item.getWeight() * fraction));
                break;
            }
        }
 
        return totalValue;
	}

	public static void main(String[] args) {
		Alg126KnapsackItem[] items = {new Alg126KnapsackItem(60, 10),
										new Alg126KnapsackItem(100, 20),
										new Alg126KnapsackItem(120, 30)};

		int capacity = 50;

		System.out.println(knapsack(capacity, items));
	}
}
