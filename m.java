import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class m {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int totalLines = 3;
        int length = 0;
        String fl = "";
        String sl = "";
        for (int i = 0; i < totalLines; i++) {
            String line = in.readLine();
            if (i == 0) {
                StringTokenizer tk = new StringTokenizer(line);
                while (tk.hasMoreTokens()) {
                     String word = tk.nextToken();
                    length = Integer.parseInt(word);
                }
            } else if (i == 1) {
                fl = line;
            } else {
                sl = line;
            }
            System.out.println(line);
        }
        System.out.println(fl);
        // Scanner sc = new Scanner(System.in);
        /*
         * int length = sc.nextInt();
         * sc.nextLine();
         * String fl = sc.nextLine();
         * String sl = sc.nextLine();
         * sc.close();
         * /*
         */
        int r = 0;
        String[] fla = fl.split(" ", length);
        String[] sla = sl.split(" ", length);
        for (int i = 0; i < length; i++) {
            if (fla[i].equals("1")) {
                r++;
            }
        }
        for (int i = 0; i < length; i++) {
            if (sla[i].equals("1")) {
                r++;
            }
        }
        int c = 0;
        for (int i = 0; i < length - 1; i++) {
            if (fla[i].equals("1") && fla[i].equals(fla[i + 1])) {
                c++;
            }
            if (sla[i].equals("1") && sla[i].equals(sla[i + 1])) {
                c++;
            }
            if (fla[i].equals("1") && fla[i].equals(sla[i + 1])) {
                c++;
            }
            if (i == length - 1 && fla[i + 1].equals("1") && fla[i].equals(sla[i + 1])) {
                c++;
                ;
            }
        }
        System.out.println((r * 3) - (c * 2));
    }
}