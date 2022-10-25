package w04search;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author bahadr
 *
 */
public class Alg44Node {
	private int value = -1;
	private List<Alg44Node> children = null;

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public List<Alg44Node> getChildren() {
		if (children == null)
			children = new ArrayList<Alg44Node>();
		return children;
	}

	private static Alg44Node findTheNode(Alg44Node activeNode, int nodeValue) {
		if (activeNode.getValue() == nodeValue)
			return activeNode;
		for (int i = 0; i < activeNode.getChildren().size(); i++) {
			Alg44Node node = activeNode.getChildren().get(i);
			if (node.getValue() == nodeValue)
				return node;
			else
				if (node.getChildren().size() > 0) {
					Alg44Node nodeFound = findTheNode(node, nodeValue);
					if (nodeFound != null)
						return nodeFound;
				}
		}
		return null;
	}

	public static Alg44Node buildTree(int[][] inputs) {
		Alg44Node root = new Alg44Node();
		root.setValue(0);
		for (int i = 0; i < inputs.length; i++) {
			Alg44Node parentNode = findTheNode(root, inputs[i][0]);
			for (int j = 1; j < inputs[i].length; j++) {
				Alg44Node node = new Alg44Node();
				node.setValue(inputs[i][j]);
				parentNode.getChildren().add(node);
			}
		}
		return root;
	}
}
