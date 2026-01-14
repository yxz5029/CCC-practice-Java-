package graph;

import java.util.Scanner;

public class Maze {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        for(int i = 0;i<total;i++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[] graph = new int[(r*c)+1];
            String[][] g = new String[r+1][c+1];
            for(int j = 1; j < r; j++){
                for(int z = 1; z < c;z++) {
                    String road = sc.next();
                    g[j][z] = road;
                    if(j != 1){
                        if(g[j-1][z].equals("+") || g[j-1][z].equals("|")){
                            graph[(j-1)*c+z] = (j-2);
                        }
                    }
                    /*
                    if (road.equals("-")){
                        graph[] =
                    }else if(){

                    }

                     */
                }
            }
        }
    }
}
