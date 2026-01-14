package graph.bfs;

import graph.data.Graphs;
import graph.model.Digraph;
import graph.model.Graph;

import java.util.Arrays;
import java.util.LinkedList;

class Q1_QustionsA {
    Q1_QustionsA(Graph g){
        cc = 0;
        marked = new boolean[g.V];
        cca = new int[g.V];
        for(int i = 0; i < g.V; i++){
            if(!marked[i]){
                cc++;
                bfs(g,i);
            }
        }
        for(int i = 0; i< g.V; i++){
            System.out.printf("vertex %s is in CC %s%n",i,cca[i]);
        }
    }
    int cc;
    boolean[] marked;  // marked[v] =
    int[] cca;   // cca[v]=1  means vertex v is in CC=1

    int[] parent;   // parent[v]=1  means vertex 1 is v's parent (Or, from 1 to v)
    int[] dist; // dist[v]=d means distance from s to v is d

    void bfs(Graph g, int s){
        LinkedList<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.addLast(s);
        cca[s] = cc;
        while(!queue.isEmpty()){
            int v = queue.removeFirst();
            for(int w : g.adj(v)){
                if(!marked[w]){
                    marked[w] = true;
                    queue.addLast(w);
                    cca[w] = cc;
                }
            }
        }
    }
}
class Q1_QuestionsDE {

    Q1_QuestionsDE(Graph g) {
        marked = new boolean[g.V];
        for (int v = 0; v < g.V; v++) {
            System.out.println("The degree of vertex "+v + " is " + g.adj(v).size());
        }
        boolean b = true;
        for(int v = 0; v < g.V; v++) {
            if (!marked[v]) {
                b = bfsColor(g, v);
                if(!b){
                    break;
                }
            }
        }
        if(!b){
            System.out.println("This graph is not Bipartite.");
        }else{
            System.out.println("This graph is Bipartite.");
        }

    }
    boolean[] marked;
    boolean bfsColor(Graph G, int s) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        marked[s] = true;
        boolean[] color = new boolean[G.V];
        queue.addLast(s);
        while (!queue.isEmpty()) {
            int v = queue.removeFirst();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    color[w] = !color[v];
                    queue.addLast(w);
                }else{
                    if(color[w] == color[v]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    int loops = 0;
    void dfs(Graph G, int v) {
        boolean[] marked = new boolean[G.V];
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }else if(w == v){
                loops += 1;
            }
        }
    }


}

class Q1_questionB {


    //boolean[] marked;
    int[] dist; // dist[v] = d; // from s to v distance is d. dist[s] = 0

    Q1_questionB(Graph g) {
        dist = new int[g.V];
        for (int s=0; s<g.V; s++) {
            // calc path from s to all other vertices
            // ...
            //marked = new boolean[g.V];
            Arrays.fill(dist,-1);
            bfs(g,s);
            for(int i = 0; i < g.V; i++){
                System.out.printf("from %s to %s distance is %s%n", s, i, dist[i]);
            }
        }

    }

    void bfs(Graph G, int s){
        LinkedList<Integer> queue = new LinkedList<Integer>();
        dist[s] = 0;
        queue.addLast(s);
        while(!queue.isEmpty()){
            int v = queue.removeFirst();
            for(int w:G.adj(v)){
                if(dist[w] == -1){
                    dist[w] = dist[v]+1;
                    queue.addLast(w);
                }
            }
        }
    }

}

class Q2_questionA {
    int[][] edgeTo; // edgeTo[w] = v; // edge from v to w
    // s -> m -> n -> u -> t
    // edgeTo[t] = u
    // edgeTo[u] = n
    // edgeTo[n] = m
    // edgeTo[m] = s
    // edgeTo[s] = s

    // int[] distTo;
    // distTo[w] = -1; // -1 means no path from s to w
    // distTo[w] = 10; // has path from s to w, length is 10

    //int[] parent; // parent[w] = v; // v is w's parent. (edge from v to w)

    Q2_questionA(Digraph g) {
        marked = new boolean[g.V][];
        edgeTo = new int[g.V][];
        for(int s = 0; s < g.V; s++){
            edgeTo[s] = new int[g.V];
            bfs(g, s);
        }
    }

    Q2_questionA(Digraph g,int s) {
        marked = new boolean[g.V][];
        edgeTo = new int[g.V][];
        edgeTo[s] = new int[g.V];
        bfs(g, s);
    }

    boolean[][] marked;
    void bfs(Digraph g, int s) {
        LinkedList<Integer> queue = new LinkedList<>();
        marked[s] = new boolean[g.V];
        edgeTo[s][s] = s;
        marked[s][s] = true;
        queue.add(s);
        while(!queue.isEmpty()){
            int v = queue.removeFirst();
            for(int w : g.adj(v)){
                if(!marked[s][w]){
                    edgeTo[s][w] = v;
                    marked[s][w] = true;
                    queue.addLast(w);
                }
            }
        }
    }

    void printPath(int source, int target) {
        int t = target;
        LinkedList<Integer> path = new LinkedList<>();
        if (marked[source][target]) {
            while(target != source){
                path.addFirst(target);
                target = edgeTo[source][target];
            }
        }
        System.out.printf("From %s to %s: %s%n", source, t, path);
    }
    void printDistance(int s, int t){

    }
}

class Q2_questionB {

    Q2_questionB(Digraph g) {
        LinkedList<Integer>[] in = new LinkedList[g.V];
        for(int i = 0; i < g.V; i++){
            in[i] = new LinkedList<>();
        }
        for(int v = 0; v < g.V; v++) {
            for (int w : g.adj(v)) {
                in[w].add(v);
            }
        }
        for(int v = 0; v < g.V; v++){
            System.out.printf("The in degree for vertex %s are: ",v);
            for(int w : in[v]){
                System.out.print(w+", ");
            }
        }
    }
    //LinkedList<Integer>[] in;
}

public class Homework_1 {
    public static void main(String[] args) throws Exception {
        //Graph tinyG = Graphs.tinyG();
        //new Q1_QuestionsDE(tinyG);
        //new Q1_QustionsA(tinyG);
        //new Q1_questionB(tinyG);

        Digraph tinyDG = Graphs.tinyDG();
        Q2_questionA q2a = new Q2_questionA(tinyDG);
        for (int s=0; s<tinyDG.V; s++) {
            System.out.println("===Source is "+s);
            //Q2_questionA q2a = new Q2_questionA(tinyDG, s);
            for (int t=0; t<tinyDG.V; t++) {
                q2a.printPath(s, t);
                //q2a.printDistance(s, t);
            }
        }

        //new Q2_questionB(tinyDG);

    }
}
