import java.util.Scanner;

public class IconScaling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.close();
        String sca1 = "*";
        String sca2 = "x";
        String sca3 = " ";
        count = (3 * k) * (3 * k);
        print1(k, sca1, sca2);
        print2(k, sca3, sca2);
        print3(k, sca1, sca3);
    }

    static int count = 0;
    int s = 0;

    static void print1(int k, String sca1, String sca2) {
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < 3 * k; i++) {
                if (i < k || i >= 2 * k) {
                    System.out.print(sca1);
                } else {
                    System.out.print(sca2);
                }
            }
            System.out.println();
        }
    }

    static void print2(int k, String sca3, String sca2) {
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < 3 * k; i++) {
                if (i >= k) {
                    System.out.print(sca2);
                } else {
                    System.out.print(sca3);
                }

            }
            System.out.println();
        }
    }

    static void print3(int k, String sca1, String sca3) {
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < 3 * k; i++) {
                if (i < k || i >= 2 * k) {
                    System.out.print(sca1);
                } else {
                    System.out.print(sca3);
                }
            }
            System.out.println();
        }
    }
}



class IconScaling2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.close();

        String[] icon = {
            "*X*",
            " XX",
            "* *"
        };

        for (String line : icon) {
            for (int i=0; i<k; i++) {
                for (char ch : line.toCharArray()) {
                    for (int j=0; j<k; j++) {
                        System.out.println(ch);
                    }
                }
                System.out.println();
            }
        }
    }
}



