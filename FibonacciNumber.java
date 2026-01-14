import java.util.Scanner;
public class FibonacciNumber{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.print(fibonacci(n));
    }
    static int[] dp = new int [31];
    // Given j, this method will return Fibonacci(j)
    static Integer fibonacci(int j){
        if(j <= 1){
            return j;
        }
        if(dp[j] == 0){
            dp[j] = fibonacci(j-1) + fibonacci(j-2);
        }
        return dp[j];
    }
}

/*
 * 
 *  F(5):
 *      F(4),               F(3)
 *          F(3), F(2)          F(2),F(1)
 * 
 * 
 * 
 * 
 */
