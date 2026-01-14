import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Anagramchecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String f1 = sc.nextLine();
        String f2 = sc.nextLine();
        sc.close();
        boolean is = true;
        f1 = f1.replaceAll("[\\W]", "");
        f2 = f2.replaceAll("[\\W]", "");
        List<Character> flist = new ArrayList<>(f1.length());
        List<Character> slist = new ArrayList<>(f2.length());
        if (f1.length() == f2.length()) {
            for (int i = 0; i < f1.length(); i++) {
                flist.add(i, f1.charAt(i));
                slist.add(i, f2.charAt(i));
            }
            for (Character s : slist) {
                if (!flist.remove(s)) {
                    is = false;
                    break;
                }
            }
        } else {
            is = false;
        }
       
        /*
         * for(int i = 0; i < flist.size()+times; i++){
         * for(int j = 0; j < slist.size(); j++){
         * if(flist.get(i-times).equals(slist.get(j))){
         * flist.remove(i-times);
         * slist.remove(j);
         * times += 1;
         * break;
         * }
         * }
         * }
         */
        System.out.println(is ? "Is an anagram." : "Is not an anagram.");
    }
}
