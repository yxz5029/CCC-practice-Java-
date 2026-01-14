import java.util.Scanner;

public class BigBangSecrets {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String sm = sc.nextLine();
        sc.close();
        //String output = "";
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < sm.length(); i++){
            char ch = sm.charAt(i);
            //output += calculate(s,i+1,ch);
            builder.append(calculate(k,i+1,ch));
        }
        //System.out.println(output);
        System.out.println(builder.toString());
    }
    static char calculate(int k, int p, char ch){
        int s = (3*p)+k;  // %26
        if(ch-'A' >= s){
            return (char)(ch - s);
        }else{
            return (char)('Z' - Math.abs((ch - 'A') - (s-1)));
        }

    }
    /*
     * String is immutable
     * 
     */
}
