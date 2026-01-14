package homework.graph.bfs;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Digraph_M {
     int V;
    Integer[][] matrix;

    Digraph_M(int v) {
        V = v;
        matrix = new Integer[v][v];    
    }

    void addEdge(int v, int w) {
        matrix[v][w] = 1;
    }

}
class Graph extends Digraph_M {  // undirected

    Graph(int v) {
        super(v);
    }
    @Override
    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        super.addEdge(v, w); // call base class's addEdge method
        matrix[w][v] = 1; // Add v to w's list.
    }
}

class BFS {
    Digraph_M graph;
    int[] dist;
    List<Integer> queue = new LinkedList<>();
    int source = 0;

    BFS(Digraph_M graph, int src) {
        this.graph = graph;
        dist = new int[graph.V];
        Arrays.fill(dist, -1);
        source = src;
    }

    void bfs() {
        dist[source] = 0;
        queue.add(source);
        while (!queue.isEmpty()) {
            int v = queue.remove(0);
            for(int i = 0; i < graph.V; i++){
                if(graph.matrix[v][i] != null && dist[i] == -1){
                    dist[i] = dist[v] + 1;
                    queue.add(i);
                }
            }
        }
    }

}

class Main1 {
    public static void main(String args[]) {
        Digraph_M g = new Digraph_M(5);
        g.addEdge(1, 3);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        int source = 1;

        System.out.println(
                "Following is Breadth First Traversal "
                        + "(starting from vertex 1)");

        BFS bfs = new BFS(g, source);
        bfs.bfs();
        for (int i = 0; i < bfs.dist.length; i++) {
            System.out.println("Vertex " + source + " can reach vertex " + i + ": " + bfs.dist[i]);
        }

        Graph g1 = new Graph(5);
        g1.addEdge(1, 3);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);

        System.out.println(
                "Following is Breadth First Traversal "
                        + "(starting from vertex 1)");

        bfs = new BFS(g1, source);
        bfs.bfs();
        for (int i = 0; i < bfs.dist.length; i++) {
            System.out.println("Vertex " + source + " can reach vertex " + i + ": " + bfs.dist[i]);
        }

    }
}