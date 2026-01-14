import java.time.temporal.JulianFields;
import java.util.Scanner;

public class Englishfrench {
    static String letter = "Ss";
    static String letters = "Tt";

    public static void main(String[] args) {
        //Scanner sc = new Scanner(Englishfrench.class.getResourceAsStream("ef.txt"));
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        sc.nextLine();
        int s = 0;
        int t = 0;
        // Scanner sc = new Scanner(System.in);
        for (int i = 0; i < v; i++) {
            String line = sc.nextLine();
            
            char ch = line.charAt(i);
            t += letters.indexOf(ch) >= 0 ? 1 : 0;
            s += letter.indexOf(ch) >= 0 ? 1 : 0;

            if (line.length() > 1) {
                String substr = line.substring(1);
            }
      
            // try to use switch...case

        }
        sc.close();
        System.out.println(s < t ? "English" : "French");

        // show result
    }
}
