public class CountNumbersWithUniqueDigits {
    public static void main(String[] agrs){
        n = 2;
        //  8 9 10
        dfs(0);
        System.out.println(result);
    }
    static boolean[] used = new boolean[10];
    static int result = 1;
    static int n;
    public static void dfs(int p){
        if(p >= n){
            return;
        }
        for(int digit = 0; digit <= 9; digit++){
            if(p == 0 && digit == 0){
                continue;
            }
            if(!used[digit]) {
                used[digit] = true;
                result++;
                printNumber();
                dfs(p+1);
                used[digit] = false;
            }
        }
    }

    static void printNumber() {
        for (int i=0; i<used.length; i++) {
            if (used[i]) System.out.print(i);
        }
        System.out.println();
    }
    /*

    n=3

    used: 0:F, 1:T, 2:T, 3:F, 4:F, 5:F

    p=0: 1
            p=1: (except 1)  2
                    p=2: 0
         2
            p=1: exception 2



     */

}
