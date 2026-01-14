package graph.shortestPath.djikstra;
import graph.model.EWGraph;
import graph.model.EWGraph.Edge;

import java.util.*;

public class DijkstraEWG {
    private Edge[] edgeTo;
    public double[] distTo;
    public DijkstraEWG(EWGraph G, int s) {
        edgeTo = new Edge[G.V];
        distTo = new double[G.V];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        distTo[s] = 0;
// Need to update PriorityQueue for it to recognize changes
        /*
        PriorityQueue<Integer> queue = new PriorityQueue<>(new
                                                                   Comparator<Integer>() {
                                                                       @Override
                                                                       public int compare(Integer v1, Integer v2) {
                                                                           return Double.compare(distTo[v1], distTo[v2]);
                                                                       }
                                                                   });
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>((v1, v2) -> Double.compare(distTo[v1], distTo[v2]));
        for (int i = 0; i < G.V; i++) { // put all vertex in the queue
            queue.add(i);
        }
        boolean[] outOfQueue = new boolean[G.V];
        while (!queue.isEmpty()) {
            //System.out.println(queue);
            int u = queue.poll();
            outOfQueue[u] = true;
            for (Edge e : G.adj(u)) {
                int w = e.other(u);
                //System.out.println(distTo[e.w]+" "+distTo[u]);
                if (!outOfQueue[w]) {
                    double d = distTo[u] + e.weight;
                    if (d < distTo[w]) {
                        distTo[w] = d;
                        edgeTo[w] = e;
                        queue.remove(w); // make queue to rearrange
                        queue.add(w);
                   }
                }
            }
        }
    }

    public Double distTo(int v) {
        return distTo[v] == Double.POSITIVE_INFINITY ? null : distTo[v];
    }
    public Collection<Edge> pathTo(int v) {
        LinkedList<Edge> path = new LinkedList<>();
        if (distTo(v) != null) {
            for (Edge e = edgeTo[v]; e != null; e = edgeTo[v]) {
                path.push(e);
                v = e.other(v);
            }
        }
        return path;
    }

}
