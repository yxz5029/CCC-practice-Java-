public class MaxTotalTastinessOfPurchase {
    public static void main(String[] args){
        int[] price = {10,20,20};;
        int[] tastiness = {5,8,8};
        int maxAmount = 20;
        int maxCoupons = 1;
        int[][][] dp = new int[price.length+1][maxAmount+1][maxCoupons+1];
        int maxT = 0;
        for(int i = 1; i <= price.length; i++){
            for(int j = 0; j <= maxAmount; j++){
                for (int k=0; k<=maxCoupons; k++) {
                    int val1 = 0;
                    if (k > 0) {
                        val1 = dp[i-1][j][k]; // do not inlude item i
                        if(j >= price[i-1]/2){ // can include item i
                            val1 = Math.max(dp[i-1][j][k], tastiness[i-1]+dp[i-1][j-price[i-1]/2][k-1]);
                        }
                    }
                    int val2 = dp[i-1][j][k]; // do not inlude item i
                    if(j >= price[i-1]){ // can include item i
                        val2 = Math.max(dp[i-1][j][k], tastiness[i-1]+dp[i-1][j-price[i-1]][k]);
                    }
    

                    // max
                    dp[i][j][k] = Math.max(val1, val2);


                    if (dp[i][j][k] > maxT) {
                        maxT = dp[i][j][k];
                    }

                }
            }
        }
    }
}

class MaxTotalTastinessOfPurchase_Simplified {
    public static void main(String[] args){
        int[] price = {10,20,20};;
        int[] tastiness = {5,8,8};
        int maxAmount = 20;
        int maxCoupons = 1;
        int[][][] dp = new int[price.length+1][maxAmount+1][maxCoupons+1];
        for(int i = 1; i <= price.length; i++){
            for(int j = 0; j <= maxAmount; j++){
                for (int k=0; k<=maxCoupons; k++) {
                    dp[i][j][k] = dp[i-1][j][k]; // do not inlude item i
                    if (k > 0 && j >= price[i-1]/2){ // can include item i
                        dp[i][j][k] = Math.max(dp[i][j][k], tastiness[i-1]+dp[i-1][j-price[i-1]/2][k-1]);
                    }
                    if(j >= price[i-1]){ // can include item i
                        dp[i][j][k] = Math.max(dp[i][j][k], tastiness[i-1]+dp[i-1][j-price[i-1]][k]);
                    }
                }
            }
        }
        System.out.println(dp[price.length][maxAmount][maxCoupons]);
    }
}
