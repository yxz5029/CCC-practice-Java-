import java.util.Scanner;

public class GPSTextEntry {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        String[][] board = {
                { "A", "B", "C", "D", "E", "F" },
                { "G", "H", "I", "J", "K", "L" },
                { "M", "N", "O", "P", "Q", "R" },
                { "S", "T", "U", "V", "W", "X" },
                { "Y", "Z", " ", "-", ".", "#" }
        };
        int xv = 0;
        int yh = 0;
        int steps = 0;
        for (int i = 0; i < input.length(); i++) {
            char find = input.charAt(i);
            for (int v = 0; v < 5; v++) {
                for (int h = 0; h < 6; h++) {
                    if (board[v][h].indexOf(find) >= 0) {
                        steps += Math.abs(v - xv);
                        steps += Math.abs(h - yh);
                        if (i + 1 == input.length()) {
                            steps += 4 - v;
                            steps += 5 - h;
                        }
                        xv = v;
                        yh = h;
                        break;
                    }
                }
            }

        }

        System.out.println(steps);
        /*
         * // String board1 = “ABCDEF”;
         * // String board2 = “GHIJKL”;
         * // String board3 = “MNOPQR”;
         * // String board4 = “STUVWX”;
         * // String board5 = “YZ -_#”;
         * String board = "ABCDEFGHIJKLMNOPQRSTUVWXYZ -.#";
         * int step = 0;
         * int lasti = 0;
         * String input = sc.nextLine();
         * sc.close();
         * for (int i = 0; i < input.length(); i++) {
         * char find = input.charAt(i);
         * step += i != 0
         * ? Math.abs((lasti + 6) / 6 - (board.indexOf(find) + 6) / 6)
         * + Math.abs((lasti + 6) % 6 - (board.indexOf(find) + 6) % 6)
         * : ((board.indexOf(find) + 6) / 6 - 1) + (board.indexOf(find) + 6) % 6;
         * lasti = board.indexOf(find);
         * }
         * step += Math.abs((lasti + 6) / 6 - 5) + Math.abs((lasti + 6) % 6 - 5);
         * System.out.println(step);
         * 
         */
    }

}