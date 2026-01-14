public class CountGoodNumbers {
    public static void main(String[] args){
        long n = 50;
        int even = 5;
        int prime = 4;
        long total = 1;

        if(n % 2 == 0){
            total = power(even*prime, n/2);
        }else{
            total = power(even*prime, n/2)*5;
        }
        System.out.println(total%m);
    }
    static final int m = 1_000_000_007;
    static long power(long base, long exp){
        if(exp == 0){
            return 1;
        }
        if(exp % 2 == 0){
            long total = power(base, exp/2);
            return total*total%m;
        }
        else{
            long total = power(base, exp/2);
            return total*total*base%m;
        }
    }

    static long power2(long base, long exp) {
        if (exp == 0) return 1;
        if (exp % 2 == 0) return power(base * base % m, exp / 2);
        else return base * power(base, exp - 1) % m;
    }

}
