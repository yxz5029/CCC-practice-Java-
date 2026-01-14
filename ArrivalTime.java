import java.util.Scanner;

public class ArrivalTime {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String time = sc.nextLine();
        sc.close();
        String[] s = time.split(":");
        int t = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        int dist = 2 * 60 * 1;
        while (dist > 0) {
            dist--;
            if(t >= 7 *60 && t < 10*60 || t >= 15*60&& t < 19*60) {
                t += 2;
            }
            else {
                t++;
            }
        }
        t %= 24*60;
        //System.out.println((t/60)+":"+(t%60));
        System.out.printf("%02d:%02d%n", t/60, t%60);
    }
}
