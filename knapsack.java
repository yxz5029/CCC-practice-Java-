import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;

public class knapsack {
    static int[][] graph;
    static int weight[];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num_of_items = sc.nextInt();
        weight = new int[num_of_items];
        int value[] = new int[num_of_items];
        Character[] letter = new Character[num_of_items]; 
        for(int i = 0; i < num_of_items; i++){
            letter[i] = sc.next().charAt(0);
            //sc.nextLine();
            value[i] = sc.nextInt();
            weight[i] = sc.nextInt();
            //value[i] = v;
        }
        int capacity = sc.nextInt();
        sc.close();
        graph = new int[num_of_items+1][capacity+1];
        int maxV = 0;
        int maxI = 0;
        int maxJ = 0;
        //Arrays.fill(graph,0);
        for(int i = 1; i <graph.length; i++){
            for(int j = 1; j < graph[i].length; j++){
                //System.out.print(map_n.get(j-weight[i-1]) + map_n.get(weight[i-1]));
                if(j >= weight[i-1]){
                    graph[i][j] = Math.max(graph[i-1][j], value[i-1] + graph[i-1][j-weight[i-1]]);
                }else{
                    graph[i][j] = graph[i-1][j];
                }
                if (graph[i][j] > maxV) {
                    maxV = graph[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        ArrayList<Integer> selectedItems = new ArrayList<>();
        collectItems(selectedItems, maxI, maxJ);
    }
    static void collectItems(ArrayList<Integer> collected, int i, int j) {
        if (i == 0) {
            return;
        }

        if (graph[i][j] == graph[i-1][j]) {
            // item  was not added
            collectItems(collected, i-1, j);
        }
        else {
            collected.add(i-1);
            collectItems(collected, i-1, j-weight[i-1]);
        }
    }
}