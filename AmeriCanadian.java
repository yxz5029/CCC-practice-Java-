import java.util.Scanner;

public class AmeriCanadian {
    static String letter = "o";
    static String letters = "r";
    static String vowels = "AaEeIiOoUuYy";

    /*
     * public static void main(String[] args) {
     * Scanner sc = new Scanner(System.in);
     * String v = " ";
     * while (!v.equals("quit!")) {
     * v = sc.nextLine();
     * String[] v1 = new String[] { v };
     * if (v.length() > 3) {
     * int vs = 0;
     * for (int i = 1; i < v.length()-1; i++) {
     * char ch1 = v.charAt(i-1);
     * char ch = v.charAt(i);
     * char ch2 = v.charAt(i+1);
     * vs = vowels.indexOf(ch1) + 1 != letter.indexOf(ch) && letter.indexOf(ch) + 1
     * == letters.indexOf(ch2)
     * ? letters.indexOf(ch)
     * : 0;
     * }
     * String substr = v.substring(vs);
     * String substr2 = v.substring(vs+1);
     * 
     * 
     * System.out.println(vs == 0 ? substr + "u" + substr2
     * : v1);
     * 
     * } else {
     * System.out.println(v);
     * }
     * }
     * // repeat until "quit!":
     * // input a word
     * // translate or not
     * // print result
     * 
     * }
     */

    /*static boolean isVowel(char ch) {
        return vowels.indexOf(ch) >= 0;
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String v = sc.nextLine();
            if (v.equals("quit!")) {
                break;
            }
            if (v.length() >= 4) {
                if (v.matches("[a-zA-Z]{1,}[^ aeiouy]or\\b")) {
                    v = v.substring(0, v.length() - 2) + "our";
                
                }
            }

            // Right regex:
            //   "[a-zA-Z]{1,}[^ aeiouy]or\\b"

            System.out.println(v);
            /*
             * \s, \b: \\s
             * 
             * "\\s+": \s+
             * "\s+" : it is not \s+
             * "\n\t"
             * 
             * //how to use RegEx to solve?
             * // if (v.matches("");
             */
            /*
         * while (true) {
         * String v = sc.nextLine();
         * if (v.equals("quit!")) {
         * break;
         * }
         * 
         * if (v.length() > 3
         * && v.endsWith("or")
         * && !isVowel(v.charAt(v.length()-3)))
         * {
         * v = v.substring(0, v.length()-2) + "our";
         * }
         * 
         * System.out.println(v);
         * }
         */
        }
    }
}