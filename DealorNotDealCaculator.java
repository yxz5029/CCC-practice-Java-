import java.util.Scanner;

public class DealorNotDealCaculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] ds = { 100, 500, 1000, 5000, 10000, 25000, 50000, 100000, 500000, 1000000 };
        // int[] outputi = new int[10];
        int tmoney = 0;
        for (int i = 0; i < num; i++) {
            int el = sc.nextInt();
            ds[el - 1] = 0;
        }
        for (int i : ds) {
            tmoney += i;
        }
        System.out.println(tmoney / (ds.length - num) < sc.nextInt() ? "deal" : "no deal");
        sc.close();
    }
}
