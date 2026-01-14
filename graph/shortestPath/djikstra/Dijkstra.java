package graph.shortestPath.djikstra;

import graph.model.EWDigraph;
import graph.model.EWDigraph.DirectedEdge;

import java.util.*;

public class Dijkstra {
    private DirectedEdge[] edgeTo;
    public double[] distTo;
    public Dijkstra(EWDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V];
        distTo = new double[G.V];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        distTo[s] = 0;
// Need to update PriorityQueue for it to recognize changes
        PriorityQueue<Integer> queue = new PriorityQueue<>((v1, v2) -> Double.compare(distTo[v1], distTo[v2]));
        for (int i = 0; i < G.V; i++) { // put all vertex in the queue
            queue.add(i);
        }
        boolean[] outOfQueue = new boolean[G.V];
        while (!queue.isEmpty()) {
            int u = queue.poll();
            outOfQueue[u] = true;
            for (DirectedEdge e : G.adj(u)) {
                if (!outOfQueue[e.dst]) {
                    double d = distTo[u] + e.weight;
                    if (d < distTo[e.dst]) {
                        distTo[e.dst] = d;
                        edgeTo[e.dst] = e;
                        queue.remove(e.dst); // make queue to rearrange
                        queue.add(e.dst);
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
                path.push(e);
            }
        }
        return path;
    }
}
