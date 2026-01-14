package dynamic.programing;

public class UncrossedLines {
    public static void main(String[] a){
        int[] num1 = {1,4,2};
        int[] num2 = {1,2,4};
        int[][] dp = new int[num1.length+1][num2.length+1];
        for(int i = 1; i <= num1.length; i++) {
            for(int j = 1; j <= num2.length; j++) {
                // i: first sequence's length
                // j: second sequence's length
                // for example:
                //    x1x34x
                //    yy1yy3yyyy4yy
                // dp[i][j] = 3: length of their common sequence
                //
                // when we need to find out dp[i][j]?
                //    x1x34x
                //    yy1yy3yyyy4y
                // dp[i-1[j-1] already known
                if(num1[i-1] == num2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[num1.length][num2.length]);
    }
}
