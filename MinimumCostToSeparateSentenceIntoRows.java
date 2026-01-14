import java.util.Arrays;
import java.util.Scanner;

// F(n) = F(n-1) + 1；



// a bc def ghuj xx ww ee dd ddd,   k = 18

// a
//  minCost1 from bc to end, then answer for this case is F(a, minCost1)
            // bc 
            //      minCostX def to end,   F(bc, minCostX)
            // bc def
            //      minCostX def to end,   F(bc def, minCostX)


// a bc
//  minCost2 from def to end, then answer for this case is F(a bc, minCost2)




// a bc def
//  minCost3 from ghuj to end, then answer for this case is F(a bc def, minCost3)



//  a
//  bc      

// a bc

// answer dp[0]
// dp[0] min costs from a （bc def ghuj）  a dp[1], a bc dp[2], a bc def dp[3]
// dp[1] min costs from bc （def ghuj）:    bc dp[2],   (bc def) dp[3]
// dp[2] min costs from def ghuj                
// dp[3] min costs from ghuj


public class MinimumCostToSeparateSentenceIntoRows {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        int k = sc.nextInt();
        sc.close();
        String[] words = sentence.split(" ");
        int[] dp = new int[words.length];  // dp[i] ??
        //int mincost = Integer.MAX_VALUE;
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[words.length-1] = 0;
        for(int i = words.length-2; i >= 0; i--){
            String count = words[i];
            for(int j = i; j < words.length; j++){
                if (j == i){
                    count = words[j];
                }else{
                    count = count + " " + words[j];
                }
                if(count.length() > k){
                    break;
                }
                if(j+1 < words.length){
                    dp[i] = Math.min((int)Math.pow(k-count.length(),2) + dp[j+1],dp[i]);
                }else{
                    dp[i] = Math.min((int)Math.pow(k-count.length(),2),dp[i]);
                }
            }
        }
        System.out.print(dp[0]);
    }
}
/*
 * static Integer countCost(String now, Integer mincost){
        if(now){
            countCost(words[i],mincost)
        }

        return countCost(now, mincost);
    }
 */