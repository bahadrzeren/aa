package w12greedy;

/**
 * 
 * @author bahadr
 *
 */
public class Alg127DijkstraSP {

    private static int minDistance(int dist[], boolean sptSet[]) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
 
        for (int i = 0; i < dist.length; i++)
            if ((sptSet[i] == false) && (dist[i] <= min)) {
                min = dist[i];
                min_index = i;
            }
 
        return min_index;
    }
 

    public static void dijkstra(int graph[][], int src) {
        int dist[] = new int[graph.length];	//	holds the shortest distance from src to i

        boolean sptSet[] = new boolean[graph.length];	//	true if the calculations are completed for a particular node/vertex.

        for (int i = 0; i < dist.length; i++) {
        	dist[i] = Integer.MAX_VALUE;
        	sptSet[i] = false;
        }

		dist[src] = 0;	//	Distance of source vertex from itself is always 0

		for (int i = 0; i < dist.length - 1; i++) {	//	Find shortest path for all vertices
			int u = minDistance(dist, sptSet);		//	src is processed first!

			sptSet[u] = true;

			for (int j = 0; j < dist.length; j++)	//	Update dist value of the adjacent vertices of the picked vertex.
				if ((!sptSet[j]) && (graph[u][j] != 0)
					&& (dist[u] != Integer.MAX_VALUE)
					&& (dist[u] + graph[u][j] < dist[j]))
				dist[j] = dist[u] + graph[u][j];
		}

        for (int i = 0; i < dist.length; i++)
            System.out.println(i + " \t\t " + dist[i]);

    }

	public static void main(String[] args) {
        int[][] graph = new int[][] {{0, 4, 0, 0, 0, 0, 0, 8, 0},
									 {4, 0, 8, 0, 0, 0, 0, 11, 0},
									 {0, 8, 0, 7, 0, 4, 0, 0, 2},
									 {0, 0, 7, 0, 9, 14, 0, 0, 0},
									 {0, 0, 0, 9, 0, 10, 0, 0, 0},
									 {0, 0, 4, 14, 10, 0, 2, 0, 0},
									 {0, 0, 0, 0, 0, 2, 0, 1, 6},
									 {8, 11, 0, 0, 0, 0, 1, 0, 7},
									 {0, 0, 2, 0, 0, 0, 6, 7, 0}};
		dijkstra(graph, 0);		
	}
}
