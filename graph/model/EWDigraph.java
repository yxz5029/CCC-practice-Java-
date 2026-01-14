package graph.model;

import java.util.Collection;
import java.util.LinkedList;
public class EWDigraph { // EdgeWeightedDigraph
    public static class DirectedEdge {
        public final int src;
        public final int dst;
        public final double weight;
        public DirectedEdge(int from, int to, double weight) {
            this.src = from;
            this.dst = to;
            this.weight = weight;
        }
        public String toString() {
            return String.format("%s -> %s %5.2f", src, dst, weight);
        }
    }
    public final int V;
    private int e;
    private final LinkedList<DirectedEdge>[] adj;
    private final int[] indegree;
    public EWDigraph(int V) {
        this.V = V;
        this.e = 0;
        this.indegree = new int[V];
        adj = new LinkedList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new LinkedList<>();
    }
    public int E() {
        return e;
    }
    public void addEdge(DirectedEdge de) {
        adj[de.src].add(de);
        indegree[de.dst]++;
        this.e++;
    }
    public Collection<DirectedEdge> adj(int v) {
        return adj[v];
    }
    public int outdegree(int v) {
        return adj[v].size();
    }
    public int indegree(int v) {
        return indegree[v];
    }

    // all edges
    public Collection<DirectedEdge> edges() {
        LinkedList<DirectedEdge> list = new LinkedList<>();
        for (int v = 0; v < V; v++) {
            list.addAll(adj[v]);
        }
        return list;
    }
}
