package homework.graph.dfs;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;



class Digraph_AL {
    int V; // No. of vertices. Default is 0
 
    // Array  of lists for
    // Adjacency List Representation
    LinkedList<Integer>[] adj; // default is NULL

    // Constructor
    @SuppressWarnings("unchecked")
    Digraph_AL(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w); // Add w to v's list.
    }
}

class Graph_AL extends Digraph_AL {
    // Constructor
    @SuppressWarnings("unchecked")
    Graph_AL(int v) {
        super(v);
    }

    @Override
    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        super.addEdge(v, w); // call base class's addEdge method
        adj[w].add(v); // Add v to w's list.
    }
}

class DFS {
    Digraph_AL graph;
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
    //boolean[] visited; // connectivity
    int[] dist;
    int source;

    DFS(Digraph_AL graph, int source) {
        this.graph = graph;
        //visited = new boolean[graph.V];
        dist = new int[graph.V];
        Arrays.fill(dist, -1);
        dist[source] = 0;
        this.source = source;
    }


    void dfs() {
        dfs(source);
    }

    private void dfs(int v)
    {
        //visited[v] = true;
        //System.out.print(v + " ");
 
        // Recur for all the vertices adjacent to this
        // vertex
        for (int w: graph.adj[v]) {
            /*
            if (!visited[w]) {
                distgh8F[w] = dist[v] + 1;
                dfs(w);
            }
             */
            if (dist[w]  == -1) {
                dist[w] = dist[v] + 1;
                dfs(w);
            }
            else {
                dist[w] = Math.min(dist[w], dist[v] + 1);
            }
        }
    }

}

class Main {
    public static void main(String args[])
    {
        Digraph_AL dg = new Digraph_AL(5);
 
        dg.addEdge(1, 3);
        dg.addEdge(0, 1);
        dg.addEdge(0, 2);
        dg.addEdge(2, 3);
        dg.addEdge(3, 4);
 
        int source = 1;

        System.out.printf(
            "Following is Depth First Traversal (starting from vertex %d)%n", source);


        DFS dfs = new DFS(dg, source);
        dfs.dfs();
        /* dfs.visited for connectivity
        for (int i=0; i<dfs.visited.length; i++) {
            System.out.println("Vertex 1 can reach vertex " + i + ": " + dfs.visited[i]);
        }
        */
        for (int i=0; i<dfs.dist.length; i++) {
            System.out.printf("Vertex %s can reach vertex  %s : %s%n", source, i, dfs.dist[i]);
        }

        Graph_AL g = new Graph_AL(5);
 
        g.addEdge(1, 3);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
 
        System.out.printf(
            "[Undirected] Following is Depth First Traversal (starting from vertex %s)%n", source);

        
        dfs = new DFS(g, source);
        dfs.dfs();

        /* dfs.visited for connectivity
        for (int i=0; i<dfs.visited.length; i++) {
            System.out.println("Vertex 1 can reach vertex " + i + ": " + dfs.visited[i]);
        }
        */
        for (int i=0; i<dfs.dist.length; i++) {
            System.out.printf("Vertex %d can reach vertex  %d : %d%n", source, i, dfs.dist[i]);
        }

    }
}