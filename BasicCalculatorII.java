public class BasicCalculatorII {
    public static void main(String[] args){
        String s = "-1*3+4*2";
        System.out.println(making2(s));
    }

    static int making2(String exp) {
        int ans = 0;
        int num = 0;
        int ndx = 0;
        int mid = 0;
        char last = '+';
        while (ndx < exp.length()) {
            char c = exp.charAt(ndx++);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '*' || c == '/'||c == '+' || c == '-'|| ndx == exp.length()) {// -1*3+4
                switch(last){
                    case '*': mid *= num; break;
                    case '/': mid = mid/num; break;
                    case '+': ans += mid; mid = num; break;
                    case '-': ans += mid; mid = -num; break;
                }
                last = c;
                num = 0;
            }
        }
        return ans + mid;
    }
}
