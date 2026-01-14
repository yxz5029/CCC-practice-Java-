package graph.shortestPath.bellmanford;

import graph.model.EWDigraph;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import static graph.model.EWDigraph.*;

public class BellmanFord {
    public double[] distTo;
    private DirectedEdge[] edgeTo;
    private Collection<Integer> cycle; // negative cycle (or null if no such cycle)

    public BellmanFord(EWDigraph G, int s) {
        distTo = new double[G.V];
        edgeTo = new DirectedEdge[G.V];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        distTo[s] = 0.0;
        for (int i=1; i<G.V; i++) { // V-1 times
            for (DirectedEdge e : G.edges()) {
                int v = e.src;
                int w = e.dst;
                if (distTo[v] == Double.POSITIVE_INFINITY) {
                    continue;
                }
                if (distTo[w] > distTo[v] + e.weight) { // edge relaxation
                    distTo[w] = distTo[v] + e.weight;
                    edgeTo[w] = e;
                }
            }
        }
        findNegativeCycle(G);
    }
    private void findNegativeCycle(EWDigraph G) {
        for (DirectedEdge e : G.edges()) {
            int v = e.src;
            int w = e.dst;
            if (distTo[w] > distTo[v] + e.weight) {
                cycle = new LinkedList<>();
                edgeTo[w] = e;
                boolean[] marked = new boolean[G.V];
                marked[w] = true;
                while (!marked[v]) {
                    marked[v] = true;
                    v = edgeTo[v].src;
                }
                cycle.add(v);
                w = edgeTo[v].src;
                while (w != v) {
                    cycle.add(w);
                    w = edgeTo[w].src;
                }
            }
        }
    }
    public Double distTo(int v) {
        return cycle == null ? distTo[v] : null;
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
