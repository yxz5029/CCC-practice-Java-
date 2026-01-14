import java.util.Stack;

public class PaintHouse {
    static int[][] costs;
    static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args) {
        int n = 3;
        int[][] costs = {
                { 17, 2, 17 },  //{17, 2, 17}
                { 16, 16, 5 },  //{18, 33, 7}
                { 14, 3, 19 }   //{21，10，26}
        };
        // int[] notsamecolor = int[];
        int[] min = new int[3];
        for (int i = 0; i < n; i++) {
            int cost0 = Math.min(min[1] + costs[i][0], min[2] + costs[i][0]);
            int cost1 = Math.min(min[0] + costs[i][1], min[2] + costs[i][1]);
            int cost2 = Math.min(min[0] + costs[i][2], min[1] + costs[i][2]);
            min[0] = cost0; 
            min[1] = cost1; 
            min[2] = cost2; 
        }
        System.out.println(Math.min(Math.min(min[0],min[1]),min[2]));
    }
}