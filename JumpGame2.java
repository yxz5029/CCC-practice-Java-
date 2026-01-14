import java.util.Arrays;

public class JumpGame2 {

    // dp: 0,1,1,M,M



    public static void main(String[] args){
        int[] nums = {2,3,1,1,4};
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j <= nums[i] && i+j<nums.length; j++) {
                dp[i+j] = Math.min(dp[i+j],dp[i]+1);
            }
        }
        System.out.println(dp[nums.length-1]);
    }
}
