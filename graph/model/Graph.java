package graph.model;

import java.util.Collection;
import java.util.TreeSet;

public class Graph extends Digraph {
    public Graph(int V) {
        super(V);
    }

    @Override
    public void addEdge(int v, int w) { // undirected
        super.addEdge(v, w);
        adj[w].add(v);
    }
}
