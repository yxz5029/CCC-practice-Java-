package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CombinationSum {
    public static void main(String[] args) {
        nums = new int[]{1,2,3};
        int target = 4;
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        System.out.println(findsum(4));
    }

    static int[] nums;
    static int[] dp;

    static int findsum(int  target) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        if (dp[target] == -1) {
            dp[target] = 0;
            for (int n : nums) {
                dp[target] += findsum(target - n);
            }
        }
        return dp[target];
    }
}