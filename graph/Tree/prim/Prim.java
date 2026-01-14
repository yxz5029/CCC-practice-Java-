package graph.Tree.prim;

import graph.model.EWGraph;
import java.util.*;
import static graph.model.EWGraph.Edge;
public class Prim {
    public final LinkedList<Edge> mst = new LinkedList<>();
    public double weight;
    private final boolean[] inMST;
    private final PriorityQueue<Edge> queue =
            new PriorityQueue<>(Comparator.comparingDouble(e -> e.weight));
    public Prim(EWGraph G) {
        inMST = new boolean[G.V];
        addToMST(0, G);
        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            if (inMST[e.v] && inMST[e.w]) {
                continue;
            }
            mst.add(e);
            weight += e.weight;
            addToMST(inMST[e.v] ? e.w : e.v, G);
        }
    }
    private void addToMST(int v, EWGraph G) {
        inMST[v] = true;
        for (Edge e : G.adj(v)) {
            if (!inMST[e.other(v)]) {
                queue.add(e);
            }
        }
    }
}
