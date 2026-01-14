package graph;

import graph.model.Digraph;
import graph.model.EWDigraph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Waterpark {
    static boolean[] marked;
    static int V;
    static boolean isCyclic = false;
    static boolean[] onStack;
    static LinkedList<Integer>[] adj;
    static int[] num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        num = new int[V + 1];
        adj = new LinkedList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            adj[i] = new LinkedList<>();
        }
        while (true) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            if (v == 0 && w == 0) {
                break;
            }
            adj[w].add(v);
        }
        count(V);
    System.out.println(num[1]);

    //num[1] = 1;
    //System.out.println(recursive(V));
    }
    static void count(int v){
        for(int i : adj[v]){
            if(i != V) {
                num[i] += 1;
                count(i);
            }
        }
    }

    static int recursive(int v) {
        if (num[v] == 0) {
            int total = 0;
            for (int i : adj[v]) {
                total += recursive(i);
            }
            num[v] = total;
        }
        return num[v];
    }
}
