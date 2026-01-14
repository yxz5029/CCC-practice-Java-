package dynamic.programing;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public static void main0(String[] args){
        int[][] envelopes = {
                {5,4},
                {6,4},
                {6,7},
                {2,3}
        };
        /*
        2 3
        5 4
        6 7
        6 5
        7 6
        7 5
         */

        // sorting:
        Arrays.sort(envelopes, (a, b)->{ // lambda  a,b: int[2]
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int n = envelopes.length;
        int[] dp = new int[n];  // dp[i] for ith number, how long the sequence is
        Arrays.fill(dp,1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }

            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    public static void main(String[] args){
        int[][] envelopes = {
                {5,4},
                {6,4},
                {6,7},
                {2,3}
        };
        /*
        2 3
        5 4
        6 7
        6 5
        7 6
        7 5
         */

        // sorting:
        Arrays.sort(envelopes, (a, b)->{ // lambda  a,b: int[2]
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int n = envelopes.length;
        int[] dp = new int[n];  // real sequence
        int end = 0;
        for (int i = 0; i < n; i++) {
            int h = envelopes[i][1];
            int p = Arrays.binarySearch(dp, 0, end, h);
            if (p < 0) {
                p = -p - 1;
                if (p == end) {
                    end++;
                }
            }
            dp[p] = h;  // replace
        }
        System.out.println(end);
    }
}
