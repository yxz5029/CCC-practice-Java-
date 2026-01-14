public class MaximumSubarray {
    public static void main(String[] args) {
        //int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {5, 4, -1, 7, 8};
        int[][] dp = new int[nums.length][nums.length];
        /*
        -2 -1 -4 0 -1 1 2 -3 1
            1 -2 2  1 3 4 -1 3
              -3 1  0 2 3 -2 2
         */
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        dp[i][j] = dp[i][j] + nums[j];
                    } else {
                        dp[i][j] = dp[i][j - 1] + nums[j];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j] - dp[i - 1][i];
                }
                max = Integer.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }

    public static void main2(String[] args) {
        //int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {5, 4, -1, 7, 8};

        int max = Integer.MIN_VALUE;
        int curr = 0;
        for (int v : nums) {
            curr = Math.max(curr+v, v);
            max = Math.max(max, curr);
        }
        System.out.println(max);
    }
}