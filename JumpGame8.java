import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class JumpGame8 {
    public static void main(String[] args){
        int[] nums = {3,2,4,4,1};
        int[] cost = {3,7,6,4,2};
        //int[] nums = {0,1,2};
        //int[] cost = {1,1,1};
        dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[nums.length-1] = cost[nums.length-1];
        double z = 5/2;
        System.out.println(z);
        //System.out.println(jump(nums,cost,0)-cost[0]);
    }
    static int[] dp;
    static int jump(int[] nums, int[] cost, int currenti){
        if(currenti != nums.length-1 && dp[currenti] == Integer.MAX_VALUE) {
            boolean larger = nums[currenti] <= nums[currenti + 1];
            int mincost = jump(nums, cost, currenti + 1) + cost[currenti];
            for (int i = currenti + 2; i < nums.length; i++) {
                if (nums[currenti] > nums[i] && larger) {
                    if (dp[i] != Integer.MAX_VALUE) {
                        mincost = Math.min(dp[i] + cost[currenti], mincost);
                    } else {
                        mincost = Math.min(mincost, jump(nums, cost, i) + cost[currenti]);
                    }
                    break;
                } else if (nums[currenti] <= nums[i] && !larger) {
                    if (dp[i] != Integer.MAX_VALUE) {
                        mincost = Math.min(dp[i] + cost[currenti], mincost);
                    } else {
                        mincost = Math.min(mincost, jump(nums, cost, i) + cost[currenti]);
                    }
                    break;
                }
            }
            dp[currenti] = mincost;
        }
        return dp[currenti];
    }
    /*
    public static void main2(String[] args){
        int[] nums = {3,2,4,4,1};
        int[] costs = {3,7,6,4,2};
        //int[] nums = {0,1,2};
        //int[] cost = {1,1,1};
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        LinkedList<Integer> case1 = new LinkedList<>();
        LinkedList<Integer> case2 = new LinkedList<>();
        case1.add(0);
        case2.add(0);
        for (int j = 1; j < nums.length; j++) {
            // case1: nums[i] <= nums[j]
            while(!case1.isEmpty() && nums[case1.getFirst()] <= nums[j]) {
                dp[j] = Math.min(dp[j], dp[case1.removeFirst()] + costs[j]);
            }

            // case2: nums[i] > nums[j]
            while (!case2.isEmpty() && nums[case2.getFirst()] > nums[j]) {
                dp[j] = Math.min(dp[j], dp[case2.removeFirst()] + costs[j]);
            }

            case1.addFirst(j);
            case2.addFirst(j);
        }
    }


     */
}
