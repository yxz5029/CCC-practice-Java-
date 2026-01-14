package graph.shortestPath.floyed_Warshall;

import graph.model.EWGraph;
import graph.model.EWGraph.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static graph.model.EWGraph.*;

public class FloydWarshallEWG {
    double[][] dist;
    Edge[][] edge; // for path reconstruction
    public FloydWarshallEWG(EWGraph g) {
        dist = new double[g.V][g.V];
        for (double[] d : dist) {
            Arrays.fill(d, Double.POSITIVE_INFINITY);
        }
        edge = new Edge[g.V][g.V];
        for (int v=0; v<g.V; v++) {
            dist[v][v] = 0;
            for (Edge e : g.adj(v)) {
                dist[v][e.other(v)] = e.weight;
                edge[v][e.other(v)] = e; // added for path reconstruction
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
    public List<Edge> path(int v, int w) {
        List<Edge> path = new ArrayList<>();
        if (dist(v, w) != null) {
            for (Edge e = edge[v][w]; e != null; e = edge[v][w])
            {
                v = e.other(v);
                path.add(e);
            }
        }
        return path;
    }
}
