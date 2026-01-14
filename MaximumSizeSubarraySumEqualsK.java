import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {

    static int solution(int[] nums, int k) {
        // prefixSum: from first to current one

        // idea:  prefixSum:  sum[j] - sum[i] is sum of substring from i+1 to j
        //      if (sum[j] - sum[i] == k) we find a substring who's sum is k, it length = j-i
        //      So we need to record the max(j-i);
        // len = j-i:   length is the difference of two indices. We want to get index of sum[i] from map

        // we want to find sum[i]. From sum[j]-sum[i]=k => sum[i] = sum[j]-k
        Map<Integer, Integer> sumToIndex = new HashMap<>(); // sum map to index
        sumToIndex.put(0, -1);
        int prefixSum = 0;
        int result = 0;

        for (int j=0; j<nums.length; j++) {
            prefixSum += nums[j];   // this is sum[j] in above thinking
            int sumI = prefixSum - k;
            if (sumToIndex.containsKey(sumI)) {
                int len = j - sumToIndex.get(sumI);
                result = Math.max(result, len);
            }
            else {
                sumToIndex.put(prefixSum, j);
            }
        }
        return result;
    }





    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};

        int k = 3;
        int[][] dp = new int[nums.length][nums.length];
        Map<Integer,Integer> map = new HashMap<>(); // map(sum,length)
        int sum = 0;
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            dp[0][i] = sum;
            int check = sum-k;
            if(map.containsKey(sum)){
                map.put(sum,Math.max(map.get(sum),i+1));
            }else {
                map.put(sum, i + 1);
            }
        }
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j <nums.length; j++){
                dp[i+1][j] = dp[i][j-1]-dp[i][i];
                sum = dp[i+1][j];
                if(map.containsKey(sum)){
                    map.put(sum,Math.max(map.get(sum),i+1-j));
                }else{
                       map.put(sum,i+1-j);
                }
            }
        }

    }




}
