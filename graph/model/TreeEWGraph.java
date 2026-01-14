package graph.model;

import java.util.Collection;
import java.util.LinkedList;

public class TreeEWGraph {
    public static class Edge {
        public final int v;
        public final int w;
        public final double weight;
        public Edge(int v, int w, double weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }
        public String toString() {
            return String.format("%s - %s %5.2f", v, w, weight);
        }
        public int other(int v) {
            return v == this.v ? this.w : this.v;
        }
    }
    public final int V;
    public final LinkedList<Edge> edges = new LinkedList<>();
    private final LinkedList<Edge>[] adj;
    public TreeEWGraph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new LinkedList<>();
    }
    public int E() {
        return edges.size();
    }
    public void addEdge(Edge e) {
        adj[e.v].add(e);
        adj[e.w].add(e);
        edges.add(e);
    }
    public Collection<Edge> adj(int v) {
        return adj[v];
    } // adj(u) and u could be either v or w
}
