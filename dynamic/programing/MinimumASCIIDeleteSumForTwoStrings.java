package dynamic.programing;

public class MinimumASCIIDeleteSumForTwoStrings {
    public static void main(String[] a){
        String s1 = "sea";
        String s2 = "eat";
        int l1 = s1.length();
        int l2 = s2.length();
        // dp[i][j]: answer for s1 and s2 where s1's length is i and s2.length is j
        // so our answer is dp[l1][l2]
        int[][] dp = new int[l1+1][l2+1];

        // when s2 is empty, calcu dp[i][0];
        for (int i=1; i<=l1; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }
        for (int i=1; i<=l2; i++) {
            dp[0][i] = dp[0][i-1] + s2.charAt(i-1);
        }

        for(int i = 1; i < l1; i++){
            for(int j = 1; j <l2; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i][j-1] + s2.charAt(j-1), dp[i-1][j] + s1.charAt(i-1));
                }
            }
        }
        System.out.println(dp[l1][l2]);
    }
}
