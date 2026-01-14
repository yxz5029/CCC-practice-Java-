import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Bananas {
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        LinkedList<String> result = new LinkedList<>();
        while(true){
            //String word = sc.nextLine();
            String word = "BBANANASNBANANASS";
            numB = 0;
            if(word.equals("X")){
                break;
            }
            System.out.println(monkeyword(word) ?"YES":"NO");
            break;
        }
    }
    static int numB = 0;
    public static boolean monkeyword0(String word){
        char ch = word.charAt(0);
        if(ch == 'A'){
            if(word.length() == 1 && numB == 0){
                return true;
            }else if(word.length() == 1 && numB != 0){
                return false;
            }else if(word.charAt(1) != 'B'&& word.charAt(1) != 'A') {
                return monkeyword0(word.substring(1, word.length()));
            }
        }else if(ch == 'B'){
            numB ++;
            if(word.charAt(1) == 'A'|| word.charAt(1) == 'B') {
                return monkeyword0(word.substring(1, word.length()));
            }
        }else if(ch == 'N'){
            if(word.charAt(1) != 'S'){
                return monkeyword0(word.substring(1,word.length()));
            }
        }else if(ch == 'S'){
            if(numB > 0){
                numB--;
                if(word.length() == 1){
                    return numB == 0;
                }else {
                    return monkeyword0(word.substring(1, word.length()));
                }
            }
        }
        return false;
    }

    public static boolean monkeyword(String word) {
        Stack<Integer> stack = new Stack<>();
        boolean expectN = false;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            switch(ch) {
                case 'N':
                    if (!expectN) return false;
                    expectN = false;
                    break;
                case 'B':
                    if (expectN) return false;
                    stack.push(i);
                    break;
                case 'S':
                    if (stack.isEmpty()) return false;
                    int i0 = stack.pop();
                    if (i0 + 1 == i) return false; // BS
                    expectN = true;
                    break;
                case 'A':
                    if (expectN) return false;
                    expectN = true;
                    break;
            }
        }
        return stack.isEmpty();
    }
}
