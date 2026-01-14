import java.util.Scanner;
import java.util.Stack;

public class GenevaConvection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numt = sc.nextInt();
        for (int i = 0; i < numt; i++) {
            int numc = sc.nextInt();
            int[] car = new int[numc];
            for (int j = numc - 1; j >= 0; j--) {
                car[j] = sc.nextInt();
            }
            System.out.println(canBeComplete(car));
        }
        sc.close();
    }

    static Stack<Integer> stack = new Stack<>();

    static String canBeComplete(int[] car) {
        int exp = 1;
        for (int i = 0; i < car.length; i++){
            if (car[i] == exp){
                exp++;
                continue;
            }
            
            while (stack.size() > 0 && exp == stack.peek()) {
                exp++;
                stack.pop();
            }

            stack.push(car[i]);
        }

        while (stack.size() > 0 && exp == stack.peek()) {
            exp++;
            stack.pop();
        }

        if (stack.isEmpty()) {
            return "Y";
        }
        else{
            return "N";
        }
    }

    static String canBeCompleteRight(int[] car) {
        int exp = 1;
        for(int i = 0; i < car.length; i++){
            if(car[i] == exp){
                exp++;
            }else if(stack.size() >= 1){
                while(stack.size() >= 1 && exp == stack.peek()){
                exp++;
                stack.pop();
                }
                stack.push(car[i]);
            }else{
                stack.push(car[i]);
            }
        }
        while(stack.size() >= 1 && exp == stack.peek()){
            exp++;
            stack.pop();
            }
        if (exp == car.length + 1){
            return "Y";
        }
        else{
            return "N";
        }
    }

    static String canBeCompleteInCorrect(int[] car, int numc) {
        int nown = 1;
        int index = 0;
        if (car[index] != nown) {
            stack.push(car[index]);
            index++;
        }
        while (nown != numc) {
            if (index < car.length) {
                if (car[index] != nown && stack.peek() != nown) {
                    stack.push(car[index]);
                    index++;
                } else {
                    if (stack.peek() == nown) {
                        stack.pop();
                    } else {
                        index++;
                    }
                    nown++;
                }
            } else {
                if (stack.peek() == nown) {
                    nown++;
                } else {
                    return "N";
                }
            }
        }
        return "Y";

    }

}
