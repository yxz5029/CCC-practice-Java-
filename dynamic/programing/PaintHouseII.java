package dynamic.programing;

import java.util.Arrays;

public class PaintHouseII {
    public static void main(String[] args) {
        int[][] costs = {
                {1, 5, 3, 3, 1},
                {2, 9, 4, 5, 2},
                {2, 4, 1, 7, 3},
                {9, 3, 1, 5, 6}
        };
        int n = 4;
        int k = 5;
        int[][] dp = new int[n][k];
        System.arraycopy(costs[n - 1], 0, dp[n - 1], 0, k);
        w:for (int i = n - 2; i >= 0; i--) {
            /*
            int min; //min[0][0]
            int minColor; //min{1][0]
            int secondMin; // min[0][1]
             */
            int[][] min = new int[2][2];
            Arrays.fill(min[0], Integer.MAX_VALUE);
            Arrays.fill(min[1], Integer.MAX_VALUE);
            for (int z = 0; z < k; z++) {
                if (dp[i + 1][z] < min[0][0]) {
                    min[0][1] = min[0][0];
                    min[1][1] = min[1][0];
                    min[1][0] = z;
                    min[0][0] = dp[i + 1][z];
                } else if (dp[i + 1][z] < min[0][1]) {
                    min[1][1] = z;
                    min[0][1] = dp[i + 1][z];
                }
            }
            for (int j = 0; j < k; j++) {
                if (min[1][0] != j)
                    dp[i][j] = costs[i][j] + min[0][0];
                else
                    dp[i][j] = costs[i][j] + min[0][1];
            }
        }
        int m = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            if(dp[0][i] < m){
                m = dp[0][i];
            }
        }
        System.out.println(m);
    }
}
