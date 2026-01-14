import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Jersey {
    public static void main(String[] arge){
        Scanner sc = new Scanner(System.in);
        int jersey = sc.nextInt();
        int athlets = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < jersey; i++){
            StringBuilder put = new StringBuilder();
            put.append(sc.nextLine());
            list.add(put.charAt(0));
        }
        for(int i = 0; i < athlets; i++){
            char put;
            put = (sc.next()).charAt(0);
            distribute(put,sc.nextInt());
        }
        sc.close();
        System.out.println(numofsatisfied);
    }
    static int numofsatisfied = 0;
    static List<Character> list = new ArrayList<Character>();
    static List<Integer> nosamen = new ArrayList<Integer>();
    static void distribute(char s, int n){
        if(list.contains(s)){
            if(!nosamen.contains(n)){
                list.remove(list.indexOf(s));
                nosamen.add(n);
                numofsatisfied++;
            }
        }else{
            for(int i = 0; i < list.size(); i++){
                if(!nosamen.contains(n) && list.get(i) < s){
                    list.remove(i);
                    nosamen.add(n);
                    numofsatisfied++;
                    break;
                }
            }
        }
        /*for(int i = 0; i < list.size(); i++){
            if(list.get(i) == s){
                numofsatisfied += nosamen != n? 1:0;
            }else if(list.get(i) < s.charAt(0)){
                
            }
        }*/
    }
}
