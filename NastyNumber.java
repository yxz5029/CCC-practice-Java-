import java.util.Scanner;

public class NastyNumber {
    public static void main0(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int oddnum = 1;
        int o = 0;
        String[] print = new String[num];
        for (int i = 0; i < num; i++) {
            int testnum = sc.nextInt();
            for (int j = 1; j * 2 * 3 <= testnum; j += oddnum) {
                if (j * 2 * 3 == testnum) {
                    print[o] = testnum + " is nasty";
                    o += 1;
                    break;
                }
                oddnum += 2;
                if ((j + oddnum) * 2 * 3 > testnum) {
                    print[o] = testnum + " is not nasty";
                    o += 1;
                }
            }
        }
        for (int i = 0; i < o; i++) {
            System.out.println(print[i]);
        }
    }


    // 24: 1-24, 2-12, 3-8, 4-6, 6-4, 8-3, 12-2

    static boolean isNasty(int v) {
        boolean[] check = new boolean[32002];        
        for (int f=1; f < v/2; f++) {
            if (v%f == 0) {
                int q = v / f;
                if (f > q) {
                    break;
                }
                int diff = Math.abs(q-f);
                if (check[diff]) {
                    return true;                    
                }
                else {
                    check[diff] = true;
                }

                int plus = q+f;
                if (check[plus]) {
                    return true;                    
                }
                else {
                    check[plus] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<num; i++) {
            int v = sc.nextInt();
            boolean result = isNasty(v);
            System.out.println(v+", "+result);        }
    }

}
