public class HouseRobber {
    public static void main(String[] agrs){
        int[] nums = {7,1,7,1,1,17};
        int[] dp = new int[nums.length];
        if(nums.length == 1){
            System.out.println(nums[0]);
        }else if(nums.length == 2){
            System.out.println(Math.max(nums[0],nums[1]));
        }
        else if(nums.length == 3){
            System.out.println(Math.max(Math.max(nums[0],nums[1]),nums[2]));
        }else{
        dp[nums.length-1] = nums[nums.length-1];
        dp[nums.length-2] = nums[nums.length-2];
        dp[nums.length-3] = nums[nums.length-1] + nums[nums.length-3];
        int maxnum = Math.max(dp[nums.length-1],dp[nums.length-2]);
        for(int i = nums.length-4; i >= 0; i--){
            dp[i] = nums[i] + maxnum;
            maxnum = Math.max(maxnum,dp[i+1]);
        }
        maxnum = Math.max(maxnum,dp[0]);
        System.out.println(maxnum);
    }
    }
}
