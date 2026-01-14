import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AttackOfTheCipertext {
    public static void main(String[] args) {
        Scanner sc = new Scanner(AttackOfTheCipertext.class.getResourceAsStream("at.txt"));
        String pt = sc.nextLine();
        String ct = sc.nextLine();
        String ct1 = sc.nextLine();
        sc.close();
        for (int i = 0; i < pt.length(); i++) {
            map.put(ct.charAt(i), pt.charAt(i));
        }

        String valid = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        if (map.size() == (valid.length() - 1)) {
            Collection<Character> plained = map.values();
            Character missingP = null;
            for (int i = 0; i < valid.length(); i++) {
                if (!plained.contains(valid.charAt(i))) {
                    missingP = valid.charAt(i);
                    break;
                }
            }
            Character missingE = null;
            for (int i = 0; i < valid.length(); i++) {
                if (map.get(valid.charAt(i)) == null) {
                    missingE = valid.charAt(i);
                    break;
                }
            }
            map.put(missingE, missingP);
        }

        for (int i = 0; i < ct1.length(); i++) {
            Character c = map.get(ct1.charAt(i));
            System.out.print(c == null ? '.' : c);
        }
        System.out.println();

        // translate(ct1,pt);
    }

    static Map<Character, Character> map = new HashMap<>();
    /*
     * 'A' -> 'B'
     * 'B' -> 'C'
     * 'C' -> 'D'
     * 
     * 'B', 'C'
     * 
     * static Map<String, String> map = new HashMap<>();
     * "A" -> "B"
     * "B" -> "C"
     * "C" -> "D"
     * 
     * 
     * 
     */
/* 
    static void translate(String ct1,String pt) {
        String op = "";
        String check = "NA";
        String check1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        String replace = "";
        int c = 0;
        for(int i = 0; i < check.length(); i++){
            String contain = check1.charAt(i) +"";
            if(!pt.contains(contain)){
                replace = contain;
                c++;
            }
        }
        for (int i = 0; i < ct1.length(); i++) {
            if (map.containsKey(ct1.charAt(i) + "")) {
                op = op + map.get(ct1.charAt(i) + "");
            } else {
                op = c == 1 ? op + replace : op + ".";
                if(check.equals("NA")){
                    check = ct1.charAt(i)+"";
                }else if(!check.equals(ct1.charAt(i)+"")){
                    check = "false";
                }
            }
        }
        if(!check.equals("false") && !check.equals("NA")){
            String regex = "[.]";
            op.replaceAll(regex, );
            System.out.println(op);
        }
    }
    */

}
