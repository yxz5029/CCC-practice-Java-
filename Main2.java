import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int np = sc.nextInt();
        sc.nextLine();
        int tspiciness = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("Poblano", 1500);
        map.put("Mirasol", 6000);
        map.put("Serrano", 15500);
        map.put("Cayenne", 40000);
        map.put("Thai", 75000);
        map.put("Habanero", 125000);
        for(int i = 0; i < np; i++){
            tspiciness += map.get(sc.nextLine());
        }
        sc.close();
        System.out.println(tspiciness);
    }
}
class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        sc.nextLine();
        String fl = sc.nextLine();
        String sl = sc.nextLine();
        sc.close();
        int r = 0;
        String[] fla = fl.split(" ", length);
        String[] sla = sl.split(" ", length);
        for (int i = 0; i < length; i++) {
            if (fla[i].equals("1")) {
                r++;
            }
        }
        for (int i = 0; i < length; i++) {
            if (sla[i].equals("1")) {
                r++;
            }
        }
        int c = 0;
        for (int i = 0; i < length-1; i++) {
            if (fla[i].equals("1") && fla[i].equals(fla[i+1])) {
                c++;
            } if(sla[i].equals("1") && sla[i].equals(sla[i+1])) {
                c++;
            }
            if(fla[i].equals("1") && fla[i].equals(sla[i+1])){
                c++;
            }if(i == length-1 && fla[i+1].equals("1") && fla[i].equals(sla[i+1])){
                c++;;
            }
        }
        System.out.println((r*3)-(c*2));
    }
}