import java.util.Scanner;
import java.util.Stack;

public class Narcissistic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ip = sc.nextInt();
        sc.close();
        Stack<Integer> stack = new Stack<>();
        boolean op = true;
        int demo = ip;
        int comp = 10;
        if (ip < 10) {
            op = true;
        } else {
            while (ip !=  0) {
                stack.push((ip % comp)/(comp/10));
                ip -= ip % comp;
                comp = comp*10;
            }
            int m = stack.size();
            while (!stack.isEmpty()) {
                int add = stack.peek();
                for(int i = 1; i < m; i++){
                add = add * stack.peek();
            }
            stack.pop();
            ip += add;
        }
            op = ip == demo ? true : false;
        }
        System.out.println(op ? "Narcissistic" : "Not Narcissistic");

    }
}
