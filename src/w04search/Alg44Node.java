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
}
