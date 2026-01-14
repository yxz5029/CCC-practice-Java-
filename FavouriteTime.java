import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FavouriteTime {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        sc.close();
        int nt = 0;
        int[] as = new int[] {
                34,
                1 * 60 + 11, 1 * 60 + 23, 1 * 60 + 35, 1 * 60 + 47, 1 * 60 + 59,
                2 * 60 + 10, 2 * 60 + 22, 2 * 60 + 34, 2 * 60 + 46, 2 * 60 + 58,
                3 * 60 + 33, 3 * 60 + 57,
        };
        nt = time / (12 * 60) * as.length;
        time = time % (12 * 60);
        for (int i = 0; i < as.length; i++) {
            if (as[i] == time) {
                nt += i + 1;
                break;
            } else if (as[i] > time) {
                nt += i;
                break;
            }
        }
        System.out.println(nt);
    }
}

class FavouriteTime2 {

    static boolean isFavouriteTime(int time) {
        int hour = time / 60;
        int minute = time % 60;
        if (hour == 0) {
            hour = 12;
        }

        int m1 = minute / 10;
        int m2 = minute % 10;
        int diff = m1 - m2;

        if (hour > 9) {
            int h1 = hour / 10;
            int h2 = hour % 10;
            return (h1 - h2) == diff && (h2 - m1) == diff;
        }

        return (hour - m1) == diff;
    }

    public static void main(String[] agrs) {
        final int max = 12 * 60;

        boolean[] isFTs = new boolean[max]; // FT: favourite time
        int totalFTs = 0;

        for (int i=0; i<max; i++) {
            isFTs[i] = isFavouriteTime(i);
            if (isFTs[i]) totalFTs++;
        }

        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        sc.close();

        int nt = time / max * totalFTs;

        for (int i = 0; i <= time%max; i++) {
            if (isFTs[i]) {
                nt++;
            }
        }
        System.out.println(nt);
    }
}


class FastIO {

    static void demo() {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int totalLines = 5;
        for (int i=0; i<totalLines; i++) {
            //String line = in.readLine("p");
            //StringTokenizer tk = new StringTokenizer(line);    // 2 3 AA 4333: we have four tokens here
            /*
            while (tk.hasMoreTokens()) {   // loop four times
                String word = tk.nextToken();
                int n = Integer.parseInt(word); // read int:   scanner.nextInt();
*/
            }
        }
}