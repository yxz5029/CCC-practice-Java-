import java.util.Arrays;

public class JumpGame7 {
    public static void main(String[] args){
        String s = "01101110";
        int minJump = 2;
        int maxJump = 3;
        System.out.println(jump(s,minJump, maxJump,0));
        //Arrays.fill(dp,-1);
        Arrays.fill(dp,true);
    }
    static boolean[] dp = new boolean[100001];
    static boolean jump(String s, int minj, int maxj, int currenti){
        if(currenti == s.length()-1){
            return true;
        }
        for(int i = minj; i <= maxj; i++){
            if(!dp[currenti]){
                return false;
            }
            if(currenti+i < s.length() && s.charAt(currenti+i) == '0') {
                if (jump(s, minj, maxj, currenti + i)){
                    return true;
                }
                dp[currenti + i] = false;
            }
        }
        dp[currenti] = false;
        return dp[currenti];
    }
    static void main2(String[] args){
        String s = "000000000000000000000000000";
        int minJump = 1;
        int maxJump = 20;
        boolean[] dp = new boolean[100001];
        dp[0] = true;
        int start = 0; // j's start
        int end = 0; // j's end
        for(int i = 0; i < s.length(); i++){
            if(!dp[i]){
                continue;
            }
            start = Math.max(end+1, minJump+i);
            end = Math.min(maxJump+i, s.length()-1);
            for(int j = start; j <= end; j++){
                if(s.charAt(j) == '0'){
                    dp[j] = true;
                }
            }
        }
        System.out.println(dp[s.length()-1]);
    }
}
