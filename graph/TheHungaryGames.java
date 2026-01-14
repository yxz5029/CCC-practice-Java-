package graph;

import graph.model.EWDigraph;
import graph.model.EWGraph;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;
public class TheHungaryGames {
    public static class Edge {
        public final int v;
        public final int w;
        public final int weight;
        public Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }
        public int other(int v) {
            return v == this.v ? this.w : this.v;
        }
    }
    public static LinkedList<Edge> edges = new LinkedList<>();
    static LinkedList<Edge>[] adj;
    static LinkedList<Edge>[] adj2;
    public void addEdge(Edge e) {
        adj[e.v].add(e);
        adj[e.w].add(e);
        edges.add(e);
    }

    public static int[] spfa(LinkedList<Edge>[] adj,int s) {
        int[] distTo = new int[adj.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] onQueue = new boolean[adj.length];
        distTo[s] = 0;
        queue.addLast(s);
        onQueue[s] = true;
        while (!queue.isEmpty() ) {
            int v = queue.removeFirst();
            onQueue[v] = false;
            for (Edge e : adj[v]) {
                int w = e.w;
                if (distTo[w] > distTo[v] + e.weight) {
                    distTo[w] = distTo[v] + e.weight;
                    if (!onQueue[w]) {
                        queue.addLast(w);
                        onQueue[w] = true;
                    }
                }
            }
        }
        return distTo;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        adj = new LinkedList[N+1];
        adj2 = new LinkedList[N+1];
        for (int v = 0; v < adj.length; v++){
            adj[v] = new LinkedList<>();
            adj2[v] = new LinkedList<>();
        }
        for(int i = 0;i<M;i++){
            int v = sc.nextInt();
            int w = sc.nextInt();
            int weight = sc.nextInt();
            Edge e = new Edge(v,w,weight);
            adj[e.v].add(e);
            Edge e1 = new Edge(w,v,weight);
            adj2[e1.v].add(e1);
            edges.add(e);
        }
        sc.close();
        int[] dt1 = spfa(adj,1);
        int[] dt2 = spfa(adj2,N);
        int result = Integer.MAX_VALUE;
        for(Edge e : edges){
            if(dt1[e.v] != Integer.MAX_VALUE && dt2[e.w] != Integer.MAX_VALUE) {
                int de = dt1[e.v] + dt2[e.w] + e.weight;
                if (de > dt1[N]) {
                    result = Math.min(de, result);
                }
            }
        }
        System.out.println(result == Integer.MAX_VALUE ? -1:result);
    }
}


/*
    12 33 55 555
    99 33

    sc.nextInt() can read all

    hello world abc
    sc.next() can read all string
    sc.nextLine() read whole line in one string

    sc.next() or sc.nextInt(), last CR/LF in buffer. When you read sc.next() it will return CR/LF (an empty string)

    2 2 2 2
    read this line

    sc.nextInt(), ... sc.nextInt(); add sc.nextLine() (discard empty)
    sc.nextLine() can read next line
*/