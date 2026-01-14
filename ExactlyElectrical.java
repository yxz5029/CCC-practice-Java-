import java.util.Scanner;

public class ExactlyElectrical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sa = sc.nextInt();
        int sb = sc.nextInt();
        int da = sc.nextInt();
        int db = sc.nextInt();
        int bt = sc.nextInt();
        sc.close();
        int cal = Math.abs(sa - da) + Math.abs(sb - db);
        if (cal <= bt) {
            if (cal % 2 == 0) {
                System.out.println(bt % 2 == 0 ? "Y" : "N");
            } else {
                System.out.println(bt % 2 != 0 ? "Y" : "N");
            }
        } else {
            System.out.println("N");
        }
        /*
         bt -= cal;
         if (bt >= 0 && bt % 2 == 0) "Y"
         else "N"
         * 
         * 
         */

    }
}
