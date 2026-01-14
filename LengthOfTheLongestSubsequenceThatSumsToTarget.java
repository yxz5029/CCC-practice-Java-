import java.util.Arrays;

public class LengthOfTheLongestSubsequenceThatSumsToTarget {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        int target = 9;
        int[][] dp = new int[nums.length+1][target+1];
        for(int i = 0; i < nums.length; i++){
            Arrays.fill(dp[i],-1);
            dp[i][0] = 0;
        }
        for(int i = 1; i <= nums.length; i++){
            for(int j = 1; j <= target; j++){
                if(nums[i-1] > j || dp[i-1][j-nums[i-1]] == -1){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j-nums[i-1]]+1,dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[nums.length][target]);
    }
}
