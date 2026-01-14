package homework;

public class WildcardMatching {
    public static void main(String[] args){
        String s = "aa";
        String p = "a";  // "*"
        System.out.println(match(s,p));
    }
    static boolean match(String s, String p){
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int j = 1; j <= p.length(); j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }
        }
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1] || dp[i-1][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
        // spspsp  sps
        // dp[i][j] means given s of length i and pattern of length j, result is match or not.
        // dp[i][j] depends on dp[i-1][j], dp[i][j-1], dp[i-1][j-1]

    }



}
