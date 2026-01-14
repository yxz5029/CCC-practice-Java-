package graph.dag;

import graph.model.Digraph;

import java.util.LinkedList;

public class TopologicalOrder {
    LinkedList<Integer> ordered = new LinkedList<>();
    boolean[] marked;
    boolean isCyclic = false;
    boolean[] onStack; // for cycle detection
    public TopologicalOrder(Digraph G) {
        marked = new boolean[G.V];
        onStack = new boolean[G.V];
        for (int v = 0; v < G.V; v++) {
            if (!marked[v] && !isCyclic) {
                dfs(G, v);
            }
        }
        if (isCyclic) {
            ordered.clear();
        }
    }
    void dfs(Digraph G, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
            else if (onStack[w]) isCyclic=true;
        }
        ordered.addFirst(v);
        onStack[v] = false;
    }
}
