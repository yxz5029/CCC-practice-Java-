import java.util.LinkedList;
import java.util.List;

public class JumpGame5 {
    public static void main(String[] args){
        int[]nums = {6,4,14,6,8,13,9,7,10,6,12};
        int d = 2;
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, jump(nums, d, i));
        }
        System.out.println(max);
    }
    static int[] dp = new int[1000];
    //6,4,14,6,8,13,9,7,10,6,12
    public static int jump(int[] nums, int d, int currenti) {
        if (dp[currenti] == 0) {
            int max = 0;
            for (int j = 1; j <= d; j++) {
                if (currenti + j < nums.length && nums[currenti + j] < nums[currenti]) {
                    max = Math.max(max,jump(nums, d, currenti + j));
                }
                if (currenti - j >= 0 && nums[currenti - j] < nums[currenti]) {
                    max = Math.max(max,jump(nums, d, currenti - j));
                }
            }
            dp[currenti] = max + 1;
        }
        return dp[currenti];
    }
}
