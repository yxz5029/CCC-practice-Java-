import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartyInvitation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        for (int i = 0; i < l; i++) {
            list.add(i + 1);
        }
        for (int i = 0; i < r; i++) {
            int ri = sc.nextInt();
            filter(l, r, ri);

        }
        sc.close();
        for (int i : list) {
            System.out.println(i);
        }
    }

    static List<Integer> list = new ArrayList<>();

    static void filter(int l, int r, int ri) {
        int index = list.size();
        int c = 0;
        for (int i = 1; i <= index; i++) {
            if (i % ri == 0) {
                list.remove(i - 1 - c);
                c++;
            }
        }
    }
}
