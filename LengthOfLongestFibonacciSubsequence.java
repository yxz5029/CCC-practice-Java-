import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestFibonacciSubsequence {
    public static void main(String[] agrs){
        // a[i]+a[j] = a[k]  ==> a[i] = a[k] - a[j]
        int[] arr = {1,2,3,4,5,6,7,8};
        dp = new int[arr.length][arr.length];  // dp[i][j] = the longest length of the fibonacci sequence that is ended by arr[i] and arr[j]
        for(int i = 0; i < arr.length;i++) {
            Arrays.fill(dp[i], 2);
        }
        int longest = 0;
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j < arr.length; j++){
                for(int k = j+1; k < arr.length;k++) {
                    if (arr[i] == arr[k] - arr[j]) {
                        dp[j][k] = dp[i][j]+1;
                        longest = Math.max(dp[j][k], longest);
                    }
                }
            }
        }
        System.out.println(longest);
    }
    static int[][] dp;
    public static void main2(String[] agrs){
        // a[i]+a[j] = a[k]  ==> a[i] = a[k] - a[j]
        int[] arr = {1,2,3,4,5,6,7,8};
        dp = new int[arr.length][arr.length];  // dp[i][j] = the longest length of the fibonacci sequence that is ended by arr[i] and arr[j]
        for(int i = 0; i < arr.length;i++) {
            Arrays.fill(dp[i], 2);
        }
        int longest = 0;
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        //for(int i = 0; i < arr.length-1; i++){
            for(int j = 1; j < arr.length; j++){
                for(int k = j+1; k < arr.length;k++) {
                    int vi = arr[k] - arr[j];
                    if (vi < arr[j] && map.containsKey(vi)) {
                        dp[j][k] = dp[map.get(vi)][j]+1;
                        longest = Math.max(dp[j][k], longest);
                    }
                }
            }
        //}
        System.out.println(longest);
    }
}
