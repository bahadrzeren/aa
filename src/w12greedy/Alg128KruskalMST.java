package w12greedy;

import java.util.Arrays;

/**
 * 
 * @author bahadr
 *
 */
public class Alg128KruskalMST {

    private static int V = 0;
    private static int E = 0;
    private static Alg128KruskalEdge[] edges;

    private static int find(Alg128KruskalSubset[] subsets, int i) {
        if (subsets[i].getParent() != i)
            return find(subsets, subsets[i].getParent());
        return subsets[i].getParent();
    }

    private static void union(Alg128KruskalSubset[] subsets, int x, int y) {
        if (subsets[x].getRank() < subsets[y].getRank())
            subsets[x].setParent(y);
        else
        	if (subsets[x].getRank() > subsets[y].getRank())
        		subsets[y].setParent(x);
	        else {
	            subsets[y].setParent(x);
	            subsets[x].setRank(subsets[x].getRank() + 1);
	        }
    }

    private static void KruskalMST() {
    	Alg128KruskalEdge result[] = new Alg128KruskalEdge[V];		// This will store the resultant MST

        int rNdx = 0;	// An index variable, used for result[]
 
        Arrays.sort(edges);			// Sort all graph edges by the ascending order of their weight values.
 
        Alg128KruskalSubset[] subsets = new Alg128KruskalSubset[V];		//	For cycle check
        for (int i = 0; i < subsets.length; i++) {
            subsets[i] = new Alg128KruskalSubset();
            subsets[i].setParent(i);
            subsets[i].setRank(0);
        }
 
        int nNdx = 0; // Index used to pick next edge
 
        while (rNdx < V - 1) {	//	Number of edges to be taken is equal to V-1
        	Alg128KruskalEdge nextEdge = edges[nNdx++];
 
            int x = find(subsets, nextEdge.getSrc());
            int y = find(subsets, nextEdge.getDest());
 
            if (x != y) {	// Include if this edge doesn't cause cycle
                result[rNdx++] = nextEdge;
                union(subsets, x, y);
            }
        }
 
        // print the contents
        System.out.println("Following are the edges in the constructed MST");
        int minimumCost = 0;
        for (int i = 0; i < rNdx; ++i) {
            System.out.println(result[i].getSrc() + " -- " + result[i].getDest() + " == " + result[i].getWeight());
            minimumCost += result[i].getWeight();
        }
        System.out.println("Minimum Cost Spanning Tree " + minimumCost);
    }

    public static void main(String[] args) {
        /* Let us create following weighted graph
		       10
		   0--------1
		   |  \     |
		  6|   5\   |15
		   |      \ |
		   2--------3
		        4       */

		V = 4; // Number of vertices in graph
		E = 5; // Number of edges in graph
		edges = new Alg128KruskalEdge[E];

		// add edge 0-1
		edges[0] = new Alg128KruskalEdge(0, 1, 10);
		// add edge 0-2
		edges[1] = new Alg128KruskalEdge(0, 2, 6);
		// add edge 0-3
		edges[2] = new Alg128KruskalEdge(0, 3, 5);
		// add edge 1-3
		edges[3] = new Alg128KruskalEdge(1, 3, 15);
		// add edge 2-3
		edges[4] = new Alg128KruskalEdge(2, 3, 4);

		KruskalMST();
	}
}
