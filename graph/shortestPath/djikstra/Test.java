package graph.shortestPath.djikstra;

import graph.data.Graphs;
import graph.model.EWDigraph;
import graph.model.EWGraph;
import graph.shortestPath.bellmanford.BellmanFord;
//import graph.shortestPath.shortPathFasterAlgorithm.shortPathFasterAlgorithmEWG;

public class Test {
    public static void main(String[] a) throws Exception {
        EWDigraph g = Graphs.tinyEWD();
        for (int i=0; i<g.V; i++) {
            Dijkstra dj = new Dijkstra(g, i);
            for(int j = 0; j < g.V; j++){
                if (dj.distTo[j] != 0) {
                    System.out.printf("Shortest path from vertex %s to vertex %s is %.2f %s%n", i, j, dj.distTo[j], dj.pathTo(j));
                }else{
                    System.out.printf("Shortest path from vertex %s to vertex %s is %.2f %s%n", i, j, dj.distTo[j], "none");
                }
            }
        }
        System.out.println("\n\n-----EWG:");
        EWGraph ewg = Graphs.eWG();
        for(int i = 0; i < ewg.V; i++){
            DijkstraEWG bf = new DijkstraEWG(ewg, i);
            for(int j = 0; j < ewg.V; j++){
                //System.out.println(bf.queue);
                if (bf.distTo[j] != 0) {
                    System.out.printf("Shortest path from vertex %s to vertex %s is %.2f %s%n", i, j, bf.distTo[j], bf.pathTo(j));
                }else{
                    System.out.printf("Shortest path from vertex %s to vertex %s is %.2f %s%n", i, j, bf.distTo[j], "none");
                }
            }
        }
    }
}
