import java.util.Scanner;
import java.util.Stack;

public class DecodeString {

    public static void main0(String[] agrs){
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        //System.out.println(making(exp));
        StringBuilder result = new StringBuilder();
        String str = "";
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> num = new Stack<>();
        Stack<String> substr = new Stack<>();
        Stack<String> l = new Stack<>();
        //StringBuilder l = new StringBuilder();
        int k = 0;
        for(int i = 0; i < exp.length();i++){
            if(exp.charAt(i) == '['){
                stack.push(i+1);
                num.push(k);
                k = 0;
            }else if(exp.charAt(i) == ']'){
                int times = num.pop();
                int begin = stack.pop();
                if(stack.isEmpty()) {
                    //str = exp.substring(l.pop());
                }else{
                    if(!l.peek().equals(" ")) {
                        str = substr.pop() + l.pop();
                    }else{
                        str = substr.pop();
                    }
                }
                StringBuilder midresult = new StringBuilder();
                for(int j = 0; j < times; j++) {
                    midresult.append(str);
                }
                if(stack.isEmpty()){
                    result.append(midresult);
                }else{
                    substr.push(midresult+"");
                }
            }
            else if(Character.isDigit(exp.charAt(i))){
                k = k*10 + exp.charAt(i)-'0';
                if(l.size() != stack.size()){
                    l.push(" ");
                }
            }else{
                if(stack.isEmpty()){
                    String w = l.pop();
                    l.push(w+exp.charAt(i));
                }
            }
        }

    }

    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        StringBuilder result = new StringBuilder();
        Stack<StringBuilder> stack = new Stack<>();
        Stack<Integer> num = new Stack<>();
        int k = 0;
        for(char c : exp.toCharArray()){
            if(c == '['){
                stack.push(result);
                num.push(k);
                result = new StringBuilder();
                k = 0;
            }else if(c == ']'){
                int times = num.pop();
                StringBuilder str = new StringBuilder();
                for (int i=0; i<times; i++) {
                    str.append(result);
                }
                StringBuilder prev = stack.pop();
                prev.append(str);
                result = prev;
            }
            else if(Character.isDigit(c)){
                k = k*10 + c-'0';
            }else{
                result.append(c);
            }
        }
        System.out.println(result);
    }



    static String making(String exp){
        int begin = -1;
        int braket = 0;
        int k = 0;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < exp.length();i++){
            if(Character.isDigit(exp.charAt(i))){
                if(braket == 0) {
                    k = k*10 + exp.charAt(i)-'0';
                }
            }
            else if(exp.charAt(i) == '['){
                if(braket == 0){
                    begin = i+1;
                }
                braket++;
            }
            else if(exp.charAt(i) == ']'){
                braket--;
                if(braket == 0){
                    String str = making(exp.substring(begin,i));
                    for(int j = 0; j < k; j++){
                        result.append(str);
                    }
                    begin = -1;
                    k = 0;
                }
            }
            else{
                if(braket == 0) {
                    result.append(exp.charAt(i));
                }
            }
        }
        return result.toString();
    }
}
