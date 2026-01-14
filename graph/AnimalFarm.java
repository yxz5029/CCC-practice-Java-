package graph;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;
class kruskal {
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
    public final LinkedList<Graph.Edge> mst = new LinkedList<>();
    public int weight;
    public kruskal(Graph G) {
        parents = new int[G.V];
        for (int i=0; i<G.V; i++) {
            parents[i] = i; // every vertex's parent is itself
        }
        ArrayList<Graph.Edge> edges = new ArrayList<>(G.edges);
// sorted into decreasing order, so we remove from last for performance reason
        edges.sort((e1, e2) -> Integer.compare(e2.weight, e1.weight));
        while (!edges.isEmpty() && mst.size() < G.V-1) {
            Graph.Edge e = edges.remove(edges.size()-1);
            if (!isConnected(e.v, e.w)) {
                mst.add(e);
                weight += e.weight;
                unite(e.v, e.w);
            }
        }
    }
}
class Graph {

    public static class Edge {
        public final int v;
        public final int w;
        public final int weight;

        public Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }
    }

    public final int V;
    public final LinkedList<Graph.Edge> edges = new LinkedList<>();

    public Graph(int V) {
        this.V = V;
    }

    public void addEdge(Graph.Edge e) {
        edges.add(e);
    }
}
public class AnimalFarm{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        if (M == 1) {
            System.out.println(0);
            return;
        }
        Graph a = new Graph(M+1);
        int[][] pens = new int[a.V*8][a.V*8];
        int[][] weight = new int[a.V*8][a.V*8];
        for (int p = 1; p <= M; p++) {
            int c = sc.nextInt();
            int[] corner = new int[c];
            for (int i = 0; i < c; i++) {
                corner[i] = sc.nextInt();
            }
            for (int i = 0; i < c; i++) {
                int w = sc.nextInt();
                int c1 = corner[i];
                int c2 = corner[(i+1)%c];
                if(pens[c1][c2] != 0){
                    Graph.Edge e = new Graph.Edge(p, pens[c1][c2], weight[c1][c2]);
                    a.addEdge(e);
                    pens[c1][c2] = pens[c2][c1] = 0;
                    weight[c1][c2] = weight[c2][c1] = 0;
                }else{
                    pens[c1][c2] = pens[c2][c1] = p;
                    weight[c1][c2] = weight[c2][c1] = w;
                }
            }
        }
        sc.close();
        kruskal k = new kruskal(a);
        for(int i = 0; i < weight.length; i++){
            for(int j = 0; j < weight.length; j++){
                if(weight[i][j] != 0){
                    Graph.Edge e = new Graph.Edge(0, pens[i][j], weight[i][j]);
                    a.addEdge(e);
                    weight[i][j] = weight[j][i] = 0;
                }
            }
        }
        kruskal k1 = new kruskal(a);
        if(k.mst.size() < a.V-1){
            System.out.println(k1.weight);
        }else {
            System.out.println(Math.min(k.weight, k1.weight));
        }
    }
}







