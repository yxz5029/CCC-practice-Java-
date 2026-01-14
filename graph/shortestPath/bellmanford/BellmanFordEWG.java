package graph.shortestPath.bellmanford;

import graph.model.EWDigraph;
import graph.model.EWGraph;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

class BellmanFordEWG {
    public double[] distTo;
    private EWGraph.Edge[] edgeTo;
    private Collection<Integer> cycle; // negative cycle (or null if no such cycle)

    public BellmanFordEWG(EWGraph G, int s) {
        distTo = new double[G.V];
        edgeTo = new EWGraph.Edge[G.V];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        distTo[s] = 0.0;
        for (int i=1; i<G.V; i++) { // V-1 times
            for (EWGraph.Edge e : G.edges) {
                int v = e.v;
                int w = e.w;
                if (distTo[v] == Double.POSITIVE_INFINITY) {
                    //continue
                }
                else if (distTo[w] > distTo[v] + e.weight) { // edge relaxation
                    distTo[w] = distTo[v] + e.weight;
                    edgeTo[w] = e;
                }
                v = e.w;
                w = e.v;
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
    private void findNegativeCycle(EWGraph G) {
        for (EWGraph.Edge e : G.Edges()) {
            int v = e.v;
            int w = e.w;
            if (distTo[w] > distTo[v] + e.weight) {
                cycle = new LinkedList<>();
                edgeTo[w] = e;
                boolean[] marked = new boolean[G.V];
                marked[w] = true;
                while (!marked[v]) {
                    marked[v] = true;
                    v = edgeTo[v].v;
                }
                cycle.add(v);
                w = edgeTo[v].v;
                while (w != v) {
                    cycle.add(w);
                    w = edgeTo[w].v;
                }
            }
        }
    }
    public Double distTo(int v) {
        return cycle == null ? distTo[v] : null;
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
