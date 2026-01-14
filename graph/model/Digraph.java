package graph.model;

import java.util.Collection;
import java.util.TreeSet;

public class Digraph {
    public final int V;
    private int e;
    protected TreeSet<Integer>[] adj; // can use ArrayList<Integer>[]
    public Digraph(int V) {
        this.V = V;
        adj = new TreeSet[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new TreeSet<>();
        }
    }
    public int E() { return e; }
    public void addEdge(int v, int w) { // directed
        e++;
        adj[v].add(w);
    }
    public Collection<Integer> adj(int v) {
        return adj[v];
    }
}
