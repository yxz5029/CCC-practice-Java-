package graph.data;

import graph.model.*;

import java.io.File;
import java.util.Scanner;

public class Graphs {
    public static Graph tinyG() throws Exception {
        Scanner sc = new Scanner(Data.tinyG());
        Graph g = new Graph(sc.nextInt());
        int E = sc.nextInt();
        for (int i=0; i<E; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            g.addEdge(v, w);
        }
        sc.close();
        return g;
    }

    public static Digraph tinyDG() throws Exception {
        //throw new RuntimeException("Please implement");
        Scanner sc = new Scanner(Data.tinyDG());
        Digraph g = new Digraph(sc.nextInt());
        int E = sc.nextInt();
        for (int i=0; i<E; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            g.addEdge(v, w);
        }
        sc.close();
        return g;
    }
    public static EWGraph eWG() throws Exception {
        //throw new RuntimeException("Please implement");
        Scanner sc = new Scanner(Data.eWG());
        EWGraph g = new EWGraph(sc.nextInt());
        int E = sc.nextInt();
        for (int i=0; i<E; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            double weight = sc.nextDouble();
            EWGraph.Edge e = new EWGraph.Edge(v,w,weight);
            g.addEdge(e);
        }
        sc.close();
        return g;
    }
    public static TreeEWGraph EWG() throws Exception {
        //throw new RuntimeException("Please implement");
        Scanner sc = new Scanner(Data.EWG());
        TreeEWGraph g = new TreeEWGraph(sc.nextInt());
        int E = sc.nextInt();
        for (int i=0; i<E; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            double weight = sc.nextDouble();
            TreeEWGraph.Edge e = new TreeEWGraph.Edge(v,w,weight);
            g.addEdge(e);
        }
        sc.close();
        return g;
    }
    public static EWDigraph tinyEWD() throws Exception {
        //throw new RuntimeException("Please implement");
        Scanner sc = new Scanner(Data.tinyEWD());
        EWDigraph g = new EWDigraph(sc.nextInt());
        int E = sc.nextInt();
        for (int i=0; i<E; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            double weight = sc.nextDouble();
            EWDigraph.DirectedEdge e = new EWDigraph.DirectedEdge(v,w,weight);
            g.addEdge(e);
        }
        sc.close();
        return g;
    }

}
