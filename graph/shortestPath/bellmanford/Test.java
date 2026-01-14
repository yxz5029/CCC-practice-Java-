package graph.shortestPath.bellmanford;

import graph.data.Graphs;
import graph.model.EWDigraph;
import graph.model.EWGraph;

public class Test {
    public static void main(String[] a) throws Exception {
        EWDigraph g = Graphs.tinyEWD();
        for (int i=0; i<g.V; i++) {
            BellmanFord bf = new BellmanFord(g, i);
            for(int j = 0; j < g.V; j++){
                if (bf.distTo[j] != 0) {
                    System.out.printf("Shortest path from vertex %s to vertex %s is %.2f %s%n", i, j, bf.distTo[j], bf.pathTo(j));
                }else{
                    System.out.printf("Shortest path from vertex %s to vertex %s is %.2f %s%n", i, j, bf.distTo[j], "none");
                }
            }
        }
        System.out.println("\n\n-----EWG:");
        EWGraph ewg = Graphs.eWG();
        for(int i = 0; i < ewg.V; i++){
            BellmanFordEWG bf = new BellmanFordEWG(ewg, i);
            for(int j = 0; j < ewg.V; j++){
                if (bf.distTo[j] != 0) {
                    System.out.printf("Shortest path from vertex %s to vertex %s is %.2f %s%n", i, j, bf.distTo[j], bf.pathTo(j));
                }else{
                    System.out.printf("Shortest path from vertex %s to vertex %s is %.2f %s%n", i, j, bf.distTo[j], "none");
                }
            }
        }

    }
}
