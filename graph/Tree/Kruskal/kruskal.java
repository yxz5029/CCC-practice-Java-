package graph.Tree.Kruskal;
import graph.model.TreeEWGraph;

import java.util.*;
import static graph.model.TreeEWGraph.*;
public class kruskal {
    //--- Quick Union Find
    int[] parents;
    public int root(int i) {
        while (parents[i] != i) {
            i = parents[i];
        }
        return i;
    }
    public boolean isConnected(int i, int j) {
        return root(i) == root(j);
    }
    public void unite(int i, int j) {
        int ri = root(i);
        int rj = root(j);
        parents[ri] = rj;
    }
    //-------------------------
    public final LinkedList<Edge> mst = new LinkedList<>();
    public double weight;
    public kruskal(TreeEWGraph G) {
        parents = new int[G.V];
        for (int i=0; i<G.V; i++) {
            parents[i] = i; // every vertex's parent is itself
        }
        ArrayList<Edge> edges = new ArrayList<>(G.edges);
// sorted into decreasing order, so we remove from last for performance reason
        edges.sort((e1, e2) -> Double.compare(e2.weight, e1.weight));
        while (!edges.isEmpty() && mst.size() < G.V-1) {
            Edge e = edges.remove(edges.size()-1);
            if (!isConnected(e.v, e.w)) {
                mst.add(e);
                weight += e.weight;
                unite(e.v, e.w);
            }
        }
    }
}