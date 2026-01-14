package graph.shortestPath.shortPathFasterAlgorithm;

import graph.model.EWDigraph;
import graph.model.EWDigraph.DirectedEdge;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class shortPathFasterAlgorithm {
    public double[] distTo;
    private DirectedEdge[] edgeTo;
    private boolean[] onQueue;
    private LinkedList<Integer> queue = new LinkedList<>();

    public shortPathFasterAlgorithm(EWDigraph G, int s) {
        distTo = new double[G.V];
        edgeTo = new DirectedEdge[G.V];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        onQueue = new boolean[G.V];
        distTo[s] = 0.0;
        queue.addLast(s);
        onQueue[s] = true;
        while (!queue.isEmpty() ) {
            int v = queue.removeFirst();
            onQueue[v] = false;
            for (DirectedEdge e : G.adj(v)) {
                int w = e.dst;
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
    public Collection<DirectedEdge> pathTo(int v) {
        LinkedList<DirectedEdge> path = new LinkedList<>();
        if (distTo(v) != null) {
            for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.src]) {
                path.addFirst(e);
            }
        }
        return path;
    }
}
