public class BasicCalculatorIII {
    public static void main(String[] args){
        String s = "2*(5+5*2)/3+(6/2+8)";
        System.out.println(making(s));
    }
    static int ndx = 0;
    static int making(String exp) {
        int ans = 0;
        int num = 0;
        //int sign = 1;
        int mid = 0;
        char last = '+';
        while (ndx < exp.length()) {
            char c = exp.charAt(ndx++);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '(') {
                num = making(exp);
            }
            if (c == '*' || c == '/'||c == '+' || c == '-'|| c==')' || ndx == exp.length()) {// -1*3+4
                switch(last){
                    case '*': mid *= num; break;
                    case '/': mid = mid/num; break;
                    case '+': ans += mid; mid = num; break;
                    case '-': ans += mid; mid = -num; break;
                }
                last = c;
                num = 0;
                if (c == ')') {
                    return ans + mid;
                }
            }
        }
        return ans + mid;
    }
}
