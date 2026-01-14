package graph;
import graph.model.EWGraph;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

class ShipGraph{
    public static class Edge {
        public final int v;
        public final int w;
        public final int weight;

        public final int h;

        public Edge(int v, int w, int weight, int h) {
            this.v = v;
            this.w = w;
            this.weight = weight;
            this.h = h;
        }
        public String toString() {
            return String.format("%s - %s %5.2f", v, w, weight);
        }
        public int other(int v) {
            return v == this.v ? this.w : this.v;
        }
    }
    public final int V;
    public final LinkedList<ShipGraph.Edge> edges = new LinkedList<>();
    private final LinkedList<ShipGraph.Edge>[] adj;
    public ShipGraph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new LinkedList<>();
    }
    public void addEdge(ShipGraph.Edge e) {
        adj[e.v].add(e);
        adj[e.w].add(e);
        edges.add(e);
    }
    public Collection<ShipGraph.Edge> adj(int v) {
        return adj[v];
    }
}

class V {
    int v;
    int h;
    V(int v, int h) {
        this.v = v;
        this.h = h;
    }
}
class shortPathFasterAlgorithmEWG {
    public int[][] distTo;
    private boolean[][] onQueue;
    private LinkedList<V> queue = new LinkedList<>();

    int K;

    public shortPathFasterAlgorithmEWG(ShipGraph G, int s,int K) {
        this.K = K;
        distTo = new int[G.V][K];
        for (int[] ds : distTo) {
            Arrays.fill(ds, Integer.MAX_VALUE);
        }
        onQueue = new boolean[G.V][K];
        distTo[s][0] = 0;
        queue.addLast(new V(s, 0));
        onQueue[s][0] = true;
        while (!queue.isEmpty()) {
            V v = queue.removeFirst();
            onQueue[v.v][v.h] = false;
            for (ShipGraph.Edge e : G.adj(v.v)) {
                int nextH = v.h + e.h;
                if (nextH < K) {
                    int w = e.other(v.v);
                    if (distTo[w][nextH] > distTo[v.v][v.h] + e.weight) {
                        distTo[w][nextH] = distTo[v.v][v.h] + e.weight;
                        if (!onQueue[w][nextH]) {
                            queue.addLast(new V(w, nextH));
                            onQueue[w][nextH] = true;
                        }
                    }

                }
            }
        }
    }

    int dist(int t) {
        int d = Integer.MAX_VALUE;
        for (int h=0; h<K; h++) {
            d = Math.min(d, distTo[t][h]);
        }
        return d == Integer.MAX_VALUE ? -1 : d;
    }
}
public class ConvexHull {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] thick = new int[N+1][N+1];
        ShipGraph g = new ShipGraph(N+1);
        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int weight = sc.nextInt();
            int h = sc.nextInt();
            thick[a][b] = thick[b][a] = h;
            ShipGraph.Edge e = new ShipGraph.Edge(a, b,weight,h);
            g.addEdge(e);
        }
        int A = sc.nextInt();
        int B = sc.nextInt();
        shortPathFasterAlgorithmEWG spfa = new shortPathFasterAlgorithmEWG(g,A,K);
        System.out.print(spfa.distTo[B]);
    }
}
