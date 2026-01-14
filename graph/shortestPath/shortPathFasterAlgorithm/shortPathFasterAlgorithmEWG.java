package graph.shortestPath.shortPathFasterAlgorithm;

import graph.model.EWDigraph;
import graph.model.EWGraph;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class shortPathFasterAlgorithmEWG {
    public double[] distTo;
    private EWGraph.Edge[] edgeTo;
    private boolean[] onQueue;
    private LinkedList<Integer> queue = new LinkedList<>();
    /*
    edge: 1 2 4  (v=1, w=2, wt=4)
        adj(1)
        adj(2)

     */
    public shortPathFasterAlgorithmEWG(EWGraph G, int s) {
        distTo = new double[G.V];
        edgeTo = new EWGraph.Edge[G.V];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        onQueue = new boolean[G.V];
        distTo[s] = 0.0;
        queue.addLast(s);
        onQueue[s] = true;
        while (!queue.isEmpty() ) {
            int v = queue.removeFirst();
            onQueue[v] = false;
            for (EWGraph.Edge e : G.adj(v)) {
                int w = e.other(v);
                if (distTo[w] > distTo[v] + e.weight) {
                    distTo[w] = distTo[v] + e.weight;
                    edgeTo[w] = e;
                    if (!onQueue[w]) {
                        queue.addLast(w);
                        onQueue[w] = true;
                    }
                }
            }
        }
    }
    public Double distTo(int v) {
        return distTo[v] == Double.POSITIVE_INFINITY ? null : distTo[v];
    }
    public Collection<EWGraph.Edge> pathTo(int v) {
        LinkedList<EWGraph.Edge> path = new LinkedList<>();
        if (distTo(v) != null) {
            for (EWGraph.Edge e = edgeTo[v]; e != null; e = edgeTo[v]) {
                path.addFirst(e);
                v = e.other(v);
            }
        }
        return path;
    }
}
