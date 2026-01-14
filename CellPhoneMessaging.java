import java.util.Scanner;
import java.util.Stack;

public class CellPhoneMessaging {
    public static void main0(String[] args) {
        int upperb = 0;
        int lowwerb = 0;
        String check = "abcdefghijklmnopqrstuvwxyz";
        Scanner sc = new Scanner(System.in);
        String input = " ";
        Stack<String> stack = new Stack<>();
        Stack<Integer> out = new Stack<>();
        while (true) {
            input = sc.nextLine();
            if (input.equals("halt")) {
                sc.close();
                break;
            }
            stack.push(input);
        }
        while (!stack.isEmpty()) {
            input = stack.pop();
            int times = input.length();
            for (int i = 0; i < input.length(); i++) {
                char a = input.charAt(i);
                if (i != 0) {
                    if (check.indexOf(a) >= 22 || check.indexOf(a) >= 16 && check.indexOf(a) <= 19) {
                        times = check.indexOf(a) >= 22 ? times + check.indexOf(a) - 22 : times + check.indexOf(a) - 16;
                        times = check.indexOf(a) <= upperb && check.indexOf(a) >= lowwerb ? times + 2 : times;
                    } else if (check.indexOf(a) >= 3) {
                        times = check.indexOf(a) <= upperb && check.indexOf(a) >= lowwerb
                                ? times + 2 + check.indexOf(a) % 3
                                : times + check.indexOf(a) % 3;
                    } else {
                        times = check.indexOf(a) <= upperb && check.indexOf(a) >= lowwerb
                                ? times + 2 + check.indexOf(a)
                                : times + check.indexOf(a);
                    }
                } else {
                    if (check.indexOf(a) < 18) {
                        times = check.indexOf(a) >= 3 ? times + check.indexOf(a) % 3 : times + check.indexOf(a);
                    } else {
                        times = check.indexOf(a) > 24 ? times + 3 : times + (check.indexOf(a) - 1) % 3;
                    }
                }
                if (check.indexOf(a) >= 22 || check.indexOf(a) >= 16 && check.indexOf(a) <= 19) {
                    lowwerb = check.indexOf(a) >= 22 ? 22 : 16;
                    upperb = check.indexOf(a) >= 22 ? 25 : 19;
                } else {
                    lowwerb = check.indexOf(a) >= 3 ? check.indexOf(a) / 3 * 3 : 0;
                    upperb = check.indexOf(a) >= 3 ? (check.indexOf(a) / 3 + 1) * 3 : 2;
                }
            }
            out.push(times);
        }
        while (!out.isEmpty()) {
            System.out.println(out.pop());
        }
    }


// 'b' - 'a' = 1 


    public static void main(String[] args) {
        String[] keys = {"2", "22", "222", "3", "33", "333", "4", "44", "444", "5", "55", "555", "6", "66", "666", "7", "77", "777", "7777", "8", "88", "888", "9", "99", "999", "9999"};
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            if (input.equals("halt")) {
                sc.close();
                break;
            }
            int times = 0;
            char prev = ' ';
            for (int i = 0; i < input.length(); i++) {
                char a = input.charAt(i);
                String code = keys[a-'a'];
                times += code.length();
                if (prev == code.charAt(0)) {
                    times += 2; // this is pause
                }
                prev = code.charAt(0);
            }
            System.out.println(times);
        }
    }
}
