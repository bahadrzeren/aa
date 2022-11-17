package w07hw;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author bahadr
 *
 */
public class Alg73Node {
	private int value = -1;
	private List<Alg73Node> children = null;

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public List<Alg73Node> getChildren() {
		if (children == null)
			children = new ArrayList<Alg73Node>();
		return children;
	}

	private static Alg73Node findTheNode(Alg73Node activeNode, int nodeValue) {
		if (activeNode.getValue() == nodeValue)
			return activeNode;
		for (int i = 0; i < activeNode.getChildren().size(); i++) {
			Alg73Node node = activeNode.getChildren().get(i);
			if (node.getValue() == nodeValue)
				return node;
			else
				if (node.getChildren().size() > 0) {
					Alg73Node nodeFound = findTheNode(node, nodeValue);
					if (nodeFound != null)
						return nodeFound;
				}
		}
		return null;
	}

	public static Alg73Node buildTree(int[][] inputs) {
		Alg73Node root = new Alg73Node();
		root.setValue(0);
		for (int i = 0; i < inputs.length; i++) {
			Alg73Node parentNode = findTheNode(root, inputs[i][0]);
			for (int j = 1; j < inputs[i].length; j++) {
				Alg73Node node = new Alg73Node();
				node.setValue(inputs[i][j]);
				parentNode.getChildren().add(node);
			}
		}
		return root;
	}
}
