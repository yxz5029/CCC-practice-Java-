package graph.dfs;

import graph.data.Graphs;
import graph.model.Digraph;
import graph.model.Graph;

import java.util.LinkedList;

class Q1_QustionsA {
    Q1_QustionsA(Graph g){
        cc = 0;
        marked = new boolean[g.V];
        cca = new int[g.V];
        for(int i = 0; i < g.V; i++){
            if(!marked[i]){
                cc += 1;
                dfs(g,i);
            }
        }
        for(int i = 0; i< g.V; i++){
            System.out.printf("vertex %s is in CC %s%n",i,cca[i]);
        }
    }
    int cc;
    boolean[] marked;  // marked[v] =
    int[] cca;   // cca[v]=1  means vertex v is in CC=1
    void dfs(Graph G, int v) {
        marked[v] = true;
        cca[v] = cc;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }
    int[] parent;   // parent[v]=1  means vertex 1 is v's parent (Or, from 1 to v)
    int[] dist; // dist[v]=d means distance from s to v is d

}
class Q1_QuestionsDE {

    Q1_QuestionsDE(Graph g) {
        marked = new boolean[g.V];
        for (int v = 0; v < g.V; v++) {
            System.out.println("The degree of vertex "+v + " is " + g.adj(v).size());
        }
        color = new boolean[g.V];
        //boolean b = true;
        for(int v = 0; v < g.V; v++) {
            b = true;
            if (!marked[v]) {
                dfs(g, v);
                if(!b){
                    System.out.println("This CC is not Bipartite.");
                }else{
                    System.out.println("This CC is Bipartite.");
                }
            }
        }

    }

    boolean[] color;
    boolean[] marked;
    boolean b;
    void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(G, w);
            }else if(color[w] == color[v]){
                b = false;
            }
        }
    }


}

class Q1_questionB {


    //boolean[] marked;
    int[] dist; // dist[v] = d; // from s to v distance is d. dist[s] = 0

    Q1_questionB(Graph g) {
        for (int s=0; s<g.V; s++) {
            // calc path from s to all other vertices
            // ...
            marked = new boolean[g.V];
            dist = new int[g.V];

            dist[s] = 0;
            dfs(g,s);
            for(int i = 0; i < g.V; i++){
                System.out.printf("from %s to %s distance is %s%n", s, i, marked[i]?dist[i]:"null");
            }
        }

    }
    boolean[] marked;
    void dfs(Graph g, int v){
        marked[v] = true;
        for(int w: g.adj(v)){
            if(!marked[w]){
                dist[w] = dist[v]+1;
                dfs(g,w);
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
        marked = new boolean[g.V][g.V];
        edgeTo = new int[g.V][];
        for(int s = 0; s < g.V; s++){
            edgeTo[s] = new int[g.V];
            dfs(g, s, s);
        }
        for(int s = 0; s < g.V; s++) {
            for(int i = 0; i < g.V; i++) {
                System.out.printf("The distance between %s and %s is %s%n",s,i,edgeTo[s][i]);
            }
        }
    }

    Q2_questionA(Digraph g,int s) {
        //marked = new boolean[g.V][];
        //edgeTo = new int[g.V][];
        //edgeTo[s] = new int[g.V];
        //dfs(g, s, s);
    }
    boolean[][] marked;
void dfs(Digraph g, int s, int v){
    marked[s][v] = true;
    for(int w : g.adj(v)){
        if(!marked[s][w]){
            edgeTo[s][w] = edgeTo[s][v]+1;
            dfs(g,s, w);
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
class Q1_questionC{
    Q1_questionC(Graph g){
        loops = false;
        marked = new boolean[g.V];
        onStack = new boolean[g.V];
        edgeTo = new int[g.V];
        for(int s = 0; s < g.V; s++){
            edgeTo[s] = s;
            dfs(g,s);
        }
    }
    boolean loops;
    boolean[] marked;
    boolean[] onStack;
    int[] edgeTo;
    void dfs(Graph g,int v){
        marked[v] = true;
        onStack[v] = true;
        for(int w : g.adj(v)){
            if(!marked[v]){
                edgeTo[w] = v;
                dfs(g,w);
            }else if (onStack[w] && edgeTo[v] != w){
                loops = true;

            }
        }
        onStack[v] = false;
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
        Graph tinyG = Graphs.tinyG();
        Digraph tinyDG = Graphs.tinyDG();
        //new Q1_QuestionsDE(tinyG);
        //new Q1_QustionsA(tinyG);
        new Q1_questionB(tinyG);
        new Q2_questionA(tinyDG);
        new Q1_QustionsA(tinyG);
        new Q1_QuestionsDE(tinyG);
        /* pass
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
         */

        //new Q2_questionB(tinyDG);

    }
}
