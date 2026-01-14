import java.util.Arrays;
import java.util.LinkedList;

public class JumpGame6 {
    public static void main(String[] args){
        //int[] nums = {1,-1,-2,4,-7,3};
        int[] nums = {10,-5,-2,4,0,3};
        //int[] nums = {1,-5,-20,4,-1,3,-6,-3};
        int k = 3;
        dp = new int[nums.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[nums.length-1] = nums[nums.length-1];
        System.out.println(solution1(nums,k));
    }
    static int solution1(int[] nums, int k) {
        dp = new int[nums.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[nums.length-1] = nums[nums.length-1];
        return jump(nums,k,0);
    }
    static int[] dp;
    public static int jump(int[] nums, int k, int currenti) {  // performance: too slow. Passed 57 test cases (total 73)
        if (dp[currenti] == Integer.MIN_VALUE) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= k; j++) {
                if (currenti + j < nums.length) {
                    max = Math.max(max,jump(nums, k, currenti + j));
                }
            }
            dp[currenti] = max+nums[currenti];
        }
        return dp[currenti];
    }

    static int solution2(int[] nums, int k) {
        dp = new int[nums.length];
        dp[0] = nums[0];

        LinkedList<Integer> max = new LinkedList<>();
        max.add(0);

        for (int i=1; i<nums.length; i++) {

            while (max.getFirst() + k < i) {
                max.removeFirst();
            }

            dp[i] = dp[max.getFirst()] + nums[i];

            while (!max.isEmpty() && dp[max.getLast()] <= dp[i]) {
                max.removeLast();
            }

            max.addLast(i);
        }
        return dp[nums.length-1];


    }
}