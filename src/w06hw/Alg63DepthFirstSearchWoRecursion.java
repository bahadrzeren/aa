package w06hw;

import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author bahadr
 *
 */
public class Alg63DepthFirstSearchWoRecursion {

	private static int[][] inputs = {{0, 1, 2, 3},
										{1, 11, 12},
											{11, 111, 112},
												{111, 1111, 1112, 1113, 1114},
												{112, 1121},
											{12, 121, 122, 123},
												{121, 1211, 1212, 1213},
												{122, 1221, 1222},
	
										{2, 21},
											{21, 211, 212, 213},
												{211, 2111},
												{212, 2121, 2122, 2123},
												{213, 2131, 2132},
													{2132, 21321},
	
										{3, 31, 32, 33},
											{31, 311},
												{311, 3111, 3112},
													{3111, 31111, 31112},
											{32, 321, 322},
												{321, 3211},
												{322, 3221, 3222, 3223},
													{3222, 32221},
											{33, 331, 332, 333},
												{331, 3311, 3312},
												{332, 3321},
												{333, 3331, 3332, 3333},
													{3333, 33331, 33332}
									};

	/******************************************************
	 **** THIS CLASS WILL NOT BE NEITHER STUDIED NOR ASKED.
	 **** YOU CAN STUDY JUST IF YOU WOULD LIKE TO DO.
	 ******************************************************/
	private static void traverseOnTheTree(Alg64NodeWParent root) {
		int level = 0;
		int direction = 1;

		Map<Integer, Alg64NodeWParent> lastItem = new TreeMap<Integer, Alg64NodeWParent>();
		Map<Integer, Integer> lastItemNdx = new TreeMap<Integer, Integer>();
		lastItem.put(0, root);
		lastItemNdx.put(0, 0);

		while (true) {

			Alg64NodeWParent node = lastItem.get(level);
			int nodeNdx = lastItemNdx.get(level);
			if (direction >= 0)
				System.out.println(node.getValue());

			if ((direction >= 0) && (node.getChildren().size() > 0)) {
				level++;
				lastItem.put(level, node.getChildren().get(0));
				lastItemNdx.put(level, 0);
				direction = 1;
			} else
				if (nodeNdx + 1 < node.getParent().getChildren().size()) {
					lastItem.put(level, node.getParent().getChildren().get(nodeNdx + 1));
					lastItemNdx.put(level, nodeNdx + 1);
					direction = 0;
				} else {
					level--;
					direction = -1;
				}
			if (level == 0)
				break;
		}
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * T(N) = V + E
	 * 
	 * O(V + E)
	 * 
	 */

	public static void main(String[] args) {
		Alg64NodeWParent root = Alg64NodeWParent.buildTree(inputs);
		traverseOnTheTree(root);
	}
}
