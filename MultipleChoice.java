import java.util.Scanner;

public class MultipleChoice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int correct = 0;
        String[] check = new String[2 * n];
        sc.nextLine();
        for (int i = 0; i < 2 * n; i++) {
            check[i] = sc.nextLine();
        }
        sc.close();
        for (int i = 0; i < n; i++) {
            if (check[i].equals(check[i + n])) {
                correct++;
            }
        }
        System.out.println(correct);
    }
}
