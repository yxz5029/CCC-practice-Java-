public class BasicCalculator {
    public static void main(String[] args){
        String s = "-(1+(4+5+2)-3)+(6+8)";
        System.out.println(making(s));
    }
    static int making(String exp){
        int begin = -1;
        int braket = 0;
        int k = 0;
        int result = 0;
        char sign = ' ';
        //StringBuilder result = new StringBuilder();
        for(int i = 0; i < exp.length();i++){
            if(Character.isDigit(exp.charAt(i))){
                if(braket == 0) {
                    k = k*10 + exp.charAt(i)-'0';
                    if(sign == ' '){//7+0
                        result = k;
                    }if(i == exp.length()-1){
                        switch(sign){
                            case '+': result += k; break;
                            case '-': result -= k; break;
                        }
                    }
                }
            }
            else if(exp.charAt(i) == '('){
                if(braket == 0){
                    begin = i+1;
                }
                braket++;
            }
            else if(exp.charAt(i) == ')'){
                braket--;
                if(braket == 0){
                    int str = making(exp.substring(begin,i));
                    if(sign != ' ') {
                        switch (sign) {
                            case '+':
                                result += str;
                                break;
                            case '-':
                                result -= str;
                                break;
                        }
                    }else{
                        result = str;
                    }
                    begin = -1;
                    k = 0;
                }
            }
            else{
                if(braket == 0) {
                    if(sign != ' '&&(exp.charAt(i) == '+' || exp.charAt(i) == '-')){
                        switch(sign){
                            case '+': result += k; break;
                            case '-': result -= k; break;
                        }
                        k = 0;
                        sign = exp.charAt(i);
                    }else if (exp.charAt(i) == '+' || exp.charAt(i) == '-'){
                        sign = exp.charAt(i);
                        k = 0;
                    }

                }
            }
        }
        return result;
    }


    static int ndx = 0;
    static int making2(String exp) {
        int ans = 0;
        int num = 0;
        int sign = 1;
        while (ndx < exp.length()) {
            char c = exp.charAt(ndx++);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '(') {
                num = making2(exp);
            } else if (c == '+' || c == '-') {
                ans += sign * num;
                num = 0;
                sign = c == '+' ? 1 : -1;
            } else if (c == ')') {
                return ans + sign * num;
            }
        }
        return ans + sign * num;
    }
}
