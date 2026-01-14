package graph.shortestPath.floyed_Warshall;

import graph.model.EWDigraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static graph.model.EWDigraph.*;

public class FloydWarshall {
    double[][] dist;
    DirectedEdge[][] edge; // for path reconstruction
    public FloydWarshall(EWDigraph g) {
        dist = new double[g.V][g.V];
        for (double[] d : dist) {
            Arrays.fill(d, Double.POSITIVE_INFINITY);
        }
        edge = new DirectedEdge[g.V][g.V];
        for (int v=0; v<g.V; v++) {
            dist[v][v] = 0;
            for (DirectedEdge e : g.adj(v)) {
                dist[v][e.dst] = e.weight;
                edge[v][e.dst] = e; // added for path reconstruction
            }
        }
        for (int k=0; k<g.V; k++) {
            for (int i=0; i<g.V; i++) {
                for (int j=0; j<g.V; j++) {
                    if (dist[i][k] == Double.POSITIVE_INFINITY || dist[k][j]
                            == Double.POSITIVE_INFINITY) {
                        continue;
                    }

                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        edge[i][j] = edge[i][k]; // for path reconstruction
                    }
//-- negative cycle detection
                    if (i == j && dist[i][j] < 0) {
                        throw new RuntimeException("negative cycle detected: "+i+", "+j);
                    }
                }
            }
        }
    }
    public Double dist(int v, int w) {
        return dist[v][w] == Double.POSITIVE_INFINITY ? null : dist[v][w];
    }
    public List<DirectedEdge> path(int v, int w) {
        List<DirectedEdge> path = new ArrayList<>();
        if (dist(v, w) != null) {
            for (DirectedEdge e = edge[v][w]; e != null; e = edge[e.dst][w])
            {
                path.add(e);
            }
        }
        return path;
    }
}
