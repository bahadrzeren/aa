package w12greedy;

public class Alg128KruskalEdge implements Comparable<Alg128KruskalEdge> {
    private int src = 0;
    private int dest = 0;
    private int weight = 0;

    public Alg128KruskalEdge(int src, int dest, int weight) {
    	this.src = src;
    	this.dest = dest;
    	this.weight = weight;
    }

    public int compareTo(Alg128KruskalEdge compareEdge) {
        return this.weight - compareEdge.weight;
    }

	public int getSrc() {
		return src;
	}

	public void setSrc(int src) {
		this.src = src;
	}

	public int getDest() {
		return dest;
	}

	public void setDest(int dest) {
		this.dest = dest;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
