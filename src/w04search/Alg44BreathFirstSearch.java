package w04search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author bahadr
 *
 */
public class Alg44BreathFirstSearch {

	public static int[][] inputs = {{1, 11, 12},
										{11, 111, 112},
											{111, 1111, 1112, 1113, 1114},
											{112, 1121},
										{13, 131, 132, 133},
											{131, 1311, 1312, 131},
											{132, 1321, 1322},

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
												{3333, 33331, 33332},
									};

	private static Alg44Node root = null;

	private static Alg44Node findTheNode(Alg44Node activeNode, int nodeValue) {
		for (int i = 0; i < activeNode.getChildren().size(); i++) {
			Alg44Node node = activeNode.getChildren().get(i);
			if (node.getValue() == nodeValue)
				return node;
			else
				if (node.getChildren().size() > 0)
					return findTheNode(node, nodeValue);
		}
		return null;
	}

	public static void buildTree() {
		root = new Alg44Node();
		root.setValue(0);
		for (int i = 0; i < inputs.length; i++) {
			for (int j = 0; j < inputs[i].length; j++) {
				Alg44Node parentNode = null;
				if (j == 0) {
					parentNode = root;
				} else {
					parentNode = findTheNode(root, inputs[i][j]);
				}
				Alg44Node node = new Alg44Node();
				node.setValue(inputs[i][j]);
				parentNode.getChildren().add(node);
			}
		}
	}

	/*
	 * TIME COMPLEXITY
	 * 
	 * T(n) ~ 3log2(n) + 4	=>	O(log2(n))
	 * 
	 */

	public static void main(String[] args) {
		for (int searchValue : inputs)
			System.out.println(searchValue + " index = " + findItem(searchValue));
		System.out.println(64 + " index = " + findItem(64));
	}
}
