package w06hw;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author bahadr
 *
 */
public class Alg64NodeWParent {
	private int value = -1;
	private Alg64NodeWParent parent = null;
	private List<Alg64NodeWParent> children = null;

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Alg64NodeWParent getParent() {
		return parent;
	}
	public void setParent(Alg64NodeWParent parent) {
		this.parent = parent;
	}
	public List<Alg64NodeWParent> getChildren() {
		if (children == null)
			children = new ArrayList<Alg64NodeWParent>();
		return children;
	}

	private static Alg64NodeWParent findTheNode(Alg64NodeWParent activeNode, int nodeValue) {
		if (activeNode.getValue() == nodeValue)
			return activeNode;
		for (int i = 0; i < activeNode.getChildren().size(); i++) {
			Alg64NodeWParent node = activeNode.getChildren().get(i);
			if (node.getValue() == nodeValue)
				return node;
			else
				if (node.getChildren().size() > 0) {
					Alg64NodeWParent nodeFound = findTheNode(node, nodeValue);
					if (nodeFound != null)
						return nodeFound;
				}
		}
		return null;
	}

	public static Alg64NodeWParent buildTree(int[][] inputs) {
		Alg64NodeWParent root = new Alg64NodeWParent();
		root.setValue(0);
		for (int i = 0; i < inputs.length; i++) {
			Alg64NodeWParent parentNode = findTheNode(root, inputs[i][0]);
			for (int j = 1; j < inputs[i].length; j++) {
				Alg64NodeWParent node = new Alg64NodeWParent();
				node.setValue(inputs[i][j]);
				node.setParent(parentNode);
				parentNode.getChildren().add(node);
			}
		}
		return root;
	}
}
