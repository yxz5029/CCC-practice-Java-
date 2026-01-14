import java.util.Scanner;
import java.util.Stack;

public class Zerothatout {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int klines = sc.nextInt();
        //sc.nextLine();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < klines; i++) {
            int money = sc.nextInt();
            if (money != 0) {
                stack.push(money);
            }else{
                stack.pop();
            }
        }
        //sc.nextLine();
        sc.close();
        int total = 0;
        while(!stack.isEmpty()){
            total += stack.pop();
        }
        System.out.println(total);
    }
}
