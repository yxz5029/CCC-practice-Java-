package graph.shortestPath.floyed_Warshall;

import graph.data.Graphs;
import graph.model.EWDigraph;
import graph.shortestPath.djikstra.Dijkstra;

public class Test {
    public static void main(String[] a) throws Exception {
        EWDigraph g = Graphs.tinyEWD();
        FloydWarshall dj = new FloydWarshall(g);
        for (int i = 0; i < g.V; i++) {
            for (int j = 0; j < g.V; j++) {
                if (dj.dist[i][j] != 0) {
                    System.out.printf("Shortest path from vertex %s to vertex %s is %.2f %s%n", i, j, dj.dist[i][j], dj.path(i,j));
                } else {
                    System.out.printf("Shortest path from vertex %s to vertex %s is %.2f %s%n", i, j, dj.dist[i][j], "none");
                }
            }
        }
    }
}
