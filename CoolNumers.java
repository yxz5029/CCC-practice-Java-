import java.io.InputStream;
import java.lang.Math;
import java.text.DecimalFormat;
import java.util.Scanner;

public class CoolNumers {
    public static void main0(String[] args) {
        InputStream in = CoolNumers.class.getResourceAsStream("cool.txt");
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(in);

        int lowerbound = sc.nextInt();
        int upperbound = sc.nextInt();
        sc.close();
        int num = 0;
        for (Integer i = lowerbound; i <= upperbound; i++) {
            double tn = (double) Math.sqrt(i);
            double tn2 = (double) Math.cbrt(i);
            String check = DecimalFormat.getNumberInstance().format(tn);
            String check2 = DecimalFormat.getNumberInstance().format(tn2);
            num = check.indexOf(".") < 0 && check2.indexOf(".") < 0 ? num + 1 : num + 0;
        }
        System.out.println(num);
    }

    public static void main(String[] args) {
        InputStream in = CoolNumers.class.getResourceAsStream("cool.txt");
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(in);
        
        int lowerbound = sc.nextInt();
        int upperbound = sc.nextInt();
        sc.close();

        int start = (int)Math.cbrt(lowerbound);
        while (start*start*start < lowerbound) {
            start++;
        }
        int end = (int)Math.cbrt(upperbound);
        while (end*end*end < upperbound) {
            end++;
        }

        int num = 0;
        for (int i = start; i <= end; i++) {
            int cube = i*i*i;
            int sqr = (int) Math.sqrt(cube);
            if (sqr*sqr == cube) {
                num++;
            }
        }
        System.out.println(num);
    }
    //Knighthop.java is a non-project file, only syntax errors are reportedJava(16)


    public static void main1(String[] args) {
        InputStream in = CoolNumers.class.getResourceAsStream("cool.txt");
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(in);
        
        int lowerbound = sc.nextInt();
        int upperbound = sc.nextInt();
        sc.close();

        int num = 0;
        for (int i = 1; ; i++) {
            int x = i*i*i*i*i*i;
            if (x > upperbound) {
                break;
            }
            if (x >= lowerbound) {
                num++;
            }
        }
        System.out.println(num);
    }
}
