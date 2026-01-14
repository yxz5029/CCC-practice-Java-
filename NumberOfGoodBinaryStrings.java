public class NumberOfGoodBinaryStrings {
    public static void main(String[] args){
        int minLength = 4;
        int maxLength = 4; 
        int oneGroup = 4; // 111
        int zeroGroup = 3; // 0000
        int modle = 10^9+7;
        int[] dp = new int[maxLength+1];
        dp[0] = 1;
        int total = 0;
        for(int i = 1; i < dp.length; i++){
            if(i - oneGroup >= 0){
                dp[i] = (dp[i] + dp[i - oneGroup]) % modle;
            }
            if(i - zeroGroup >= 0){
                dp[i] = (dp[i] + dp[i - zeroGroup])%modle;
            }
            if(i >= minLength){
                total = (total+dp[i]) % modle;
            }
        }
        System.out.println();
    /*
        1110000
        0000111
2 3 4 5 6 8
1 0 2 0 3 5
11 0000 1111 110000 000011 111111 11110000 11000011 00001111 11111111 00000000
11 
        1110000111
        0000111111

        、、 11， from 7
        11100000000
        00001110000
        
        // 11 from 8
        00000000111
        00000000111

        // i >= oneGrope,zeroGroup 
        */

    }
}
