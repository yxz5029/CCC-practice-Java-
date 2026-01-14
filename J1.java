import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        printnumber(v);
    }

    static void printnumber(int nums) {
        int vl = 0;
        int vr = 0;
        int h = 0;
        switch (nums) {
            case 0:
                h = 5;
                vl = 0;
                vr = 0;
                break;
            case 1:
                h = 15;
                vl = 8;
                vr = 0;
                break;
            case 2:
                h = 0;
                vl = 2;
                vr = 6;
                break;
            case 3:
                h = 0;
                vl = 8;
                vr = 0;
                break;
            case 4:
                h = 10;
                vl = 6;
                vr = 0;
                break;
            case 5:
                h = 0;
                vl = 6;
                vr = 2;
                break;
            case 6:
                h = 0;
                vl = 0;
                vr = 2;
                break;
            case 7:
                h = 14;
                vl = 8;
                vr = 0;
                break;
            case 8:
                h = 0;
                vl = 0;
                vr = 0;
                break;
            case 9:
                h = 0;
                vl = 6;
                vr = 0;
                break;
            default:
                System.out.println("Fales");
        }
        for (int j = 0; j < 9; j++) {
            if (j == 0 | j == 4 | j == 8) {
                switch (h) {
                    case 0:
                        System.out.println("  * * *  ");
                        break;
                    case 5:
                        if (j != 4) {
                            System.out.println("  * * *  ");
                        } else {
                            System.out.println("         ");
                        }
                        break;
                    case 10:
                        if (j == 4) {
                            System.out.println("  * * *  ");
                        } else {
                            System.out.println("         ");
                        }
                        break;
                    case 14:
                        if (j == 0) {
                            System.out.println("  * * *  ");
                        } else {
                            System.out.println("         ");
                        }
                        break;
                    case 15:
                        System.out.println("         ");
                        break;
                }
            } else {
                switch (vr) {
                    case 0:
                        if (vl == 0) {
                            System.out.println("*       *");
                        } else if (vl == 6 && j > 4) {
                            System.out.println("        *");
                        } else if (vl == 6 && j < 4) {
                            System.out.println("*       *");
                        } else {
                            System.out.println("        *");
                        }
                        break;
                    case 2:
                        if ((vl == 0 | vl == 6) && j < 4) {
                            System.out.println("*        ");
                        } else if (vl == 0 && j > 4) {
                            System.out.println("*       *");
                        } else if (vl == 6 && j > 4) {
                            System.out.println("        *");
                        }
                        break;
                    case 6:
                        if (j < 4) {
                            System.out.println("        *");
                        } else {
                            System.out.println("*        ");
                        }
                        break;
                }
            }
        }
    }
}

class J1_0123456789 {

    static String[] lines = {
            " * * * ",
            "*",
            "      *",
            "*     *",
            "",
    };

    static int[][] patterns = {
            { 0, 3, 3, 3, 4, 3, 3, 3, 0 },
            { 4, 2, 2, 2, 4, 2, 2, 2, 4 },
            { 0, 2, 2, 2, 0, 1, 1, 1, 0 },
            { 0, 2, 2, 2, 0, 2, 2, 2, 0 },
            { 4, 3, 3, 3, 0, 2, 2, 2, 4 },
            { 0, 1, 1, 1, 0, 2, 2, 2, 0 },
            { 0, 1, 1, 1, 0, 3, 3, 3, 0 },
            { 0, 2, 2, 2, 4, 2, 2, 2, 4 },
            { 0, 3, 3, 3, 0, 3, 3, 3, 0 },
            { 0, 3, 3, 3, 0, 2, 2, 2, 0 },
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a digit between 0 and 9: ");
        print(sc.nextInt());
    }

    private static void print(int digit) {
        for (int i : patterns[digit]) {
            System.out.println(lines[i]);
        }
    }

}