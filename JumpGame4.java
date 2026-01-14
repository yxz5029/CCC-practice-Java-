import java.util.*;

public class JumpGame4 {
    public static void main(String[] args) {
        //int[] nums = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        //int[] nums = {7,6,9,6,9,6,9,7};
        int[] nums = {7};
        // junpfrom: 0          (step=0)
        //      next: 1, 4
        // jumpfrom: 1, 4       (step = 1)
        //      next:       2, (0 visited)   [from 11
        //        //              3, 5        [from 4]
        // jumnpfrom 2, 3, 5    (step=2)
        //      next:   (1 visited), 3  [from 2]
        //              (2 visited), (4 visited), 9    [from 3]
        //              (4 visited), 6, 7           [from 5]
        // junmpfrom  3, 9, 6, 7    (step=3)

        //            100, -23 -23 -23 100 23 23 3 -23
        Map<Integer, List<Integer>> valueToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!valueToIndex.containsKey(nums[i])) {
                valueToIndex.put(nums[i], new LinkedList<>());
            }
            valueToIndex.get(nums[i]).add(i);
            /*
            if(i+1<nums.length && nums[i+1] != nums[i]){
                valueToIndex.get(nums[i]).add(i+1);
            }
            if(i-1>=0 && nums[i-1] != nums[i]){
                valueToIndex.get(nums[i]).add(i-1);
            }
             */
        }
        List<Integer> jumpfrom = new LinkedList<>();
        jumpfrom.add(0);
        int step = 0;
        boolean[] visited = new boolean[nums.length];
        visited[0] = true;
        main:
        while (!jumpfrom.isEmpty()) {
            List<Integer> jumpto = new LinkedList<>();
            while (!jumpfrom.isEmpty()) {
                int i = jumpfrom.remove(0);
                visited[i] = true;
                if (i == nums.length - 1) {
                    break main;
                }
                while (!valueToIndex.get(nums[i]).isEmpty()) {
                    int j = valueToIndex.get(nums[i]).remove(0);
                    if (!visited[j]) {
                        jumpto.add(j);

                    }
                }
                if(!jumpto.contains(i+1) && i+1 < nums.length && !visited[i+1]){
                    jumpto.add(i+1);
                }
                if(!jumpto.contains(i-1) && i-1 >= 0 && !visited[i-1]){
                    jumpto.add(i-1);
                }
            }
            jumpfrom = jumpto;
            step++;
        }
        System.out.println(step);
        }
    }
    /*
        dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        repeat = new ArrayList[nums.length];
        for(int i = 0; i < nums.length; i++){
            repeat[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < nums.length; i++){
            dp[i] = i;
            for(int j = 1; i+j < nums.length; j++) {
                if (nums[i] == nums[i+j]){
                    repeat[i+j].add(i);
                    repeat[i].add(i+j);
                }
            }
        }
        find(nums,0);
        System.out.println(dp[nums.length-1]);
    }
    static int[] dp;
    static ArrayList<Integer>[] repeat;
    public static void find(int[] nums, int i){
        if(i < 0 || i >= nums.length){
            return;
        }
        while(!repeat[i].isEmpty()){
            int j = repeat[i].get(0);
            repeat[i].remove(0);
            if(j >= 0 && j > i) {
                dp[j] = Math.min(dp[i] + 1, dp[j]);
                if(j+1 < nums.length) {
                    dp[j+1] = Math.min(dp[j]+1,dp[j+1]);
                }
                if(j-1 >= 0) {
                    dp[j-1] = Math.min(dp[j]+1,dp[j-1]);
                }
            }
        }
        find(nums,i+1);

        System.out.println(i+" "+dp[i]);
    }

     */
