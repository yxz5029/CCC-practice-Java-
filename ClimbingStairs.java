import java.util.Scanner;

public class ClimbingStairs {
    public static void main0(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++){
            /*
            dp[i] = (dp[i] + dp[i - 1]);
            if(i - 2 >= 0){
                dp[i] = (dp[i] + dp[i - 2]);
            }
            */
            dp[i] = dp[i - 1];
            if(i - 2 >= 0){
                dp[i] = (dp[i] + dp[i - 2]);
            }
        }
        System.out.println(dp[n]);
    }




    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        dp = new int[n+1];
        dp[0] = dp[1] = 1;
         System.out.println(countWays(n));

    }
    // too slow. Why?
    static int countWaysTooSlow(int n){
        if(n <= 1){
            return 1;
        }
        return countWays(n-1) + countWays(n-2);
    }

    static int[] dp;
    static int countWays(int n){
        /*
        if(n <= 1){
            return 1;
        }
         */
        if(dp[n] == 0){
            dp[n] = countWays(n-1) + countWays(n-2);
        }
        return dp[n];
    }

}




//IntelliJ (Pro)