package w04search;

/**
 * 
 * @author bahadr
 *
 */
public class Alg44DepthFirstSearchWoRecursion {

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

	private static void traverseOnTheTree(Alg44Node node) {
		System.out.println(node.getValue());				//	V
		for (Alg44Node childNode: node.getChildren())
			traverseOnTheTree(childNode);						//	E
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
		Alg44Node root = Alg44Node.buildTree(inputs);
		traverseOnTheTree(root);
	}
}
