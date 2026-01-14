import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AssigningPartners {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numstut = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numstut; i++) {
            String input = sc.next();
            namearray1.add(input);
        }
        sc.nextLine();
        for (int i = 0; i < numstut; i++) {
            String input = sc.next();
            namearray2.add(input);
        }
        sc.close();
        boolean output = consistenlyCheck(numstut);
        System.out.println(output ? "good" : "bad");
    }

    static List<String> namearray1 = new ArrayList<>();
    static List<String> namearray2 = new ArrayList<>();

    static boolean consistenlyCheck(int l) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            String n1 = namearray1.get(i);
            String n2 = namearray2.get(i);
            if (n1.equals(n2)) return false;

            if(!map.containsKey(n1)){
                map.put(n1, n2);
            }
            else {
                String n3 = map.get(n1);
                if (!n2.equals(n3)) {
                    return false;
                }
            }
            
            if(!map.containsKey(n2)){
                map.put(n2, n1);
            }
            else {
                String n3 = map.get(n2);
                if (!n1.equals(n3)) {
                    return false;
                }
            }
        }
        return true;
    }
}

class AssigningPartners_Issue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numstut = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numstut; i++) {
            String input = sc.next();
            namearray1.add(input);
        }
        sc.nextLine();
        for (int i = 0; i < numstut; i++) {
            String input = sc.next();
            namearray2.add(input);
        }
        sc.close();
        boolean output = consistenlyCheck(numstut);
        System.out.println(output ? "good" : "bad");
    }

    static List<String> namearray1 = new ArrayList<>();
    static List<String> namearray2 = new ArrayList<>();

    static boolean consistenlyCheck(int l) {
        for (int i = 0; i < l; i++) {
            int back = i + 1;
            int front = i - 1;
            if (i == 0) {
                front = l - 1;
            } else if (i == l - 1) {
                back = 0;
            }
            if (namearray1.get(back).equals(namearray2.get(i))
                    || namearray1.get(front).equals(namearray2.get(i))) {
                int checkindex = namearray1.get(back).equals(namearray2.get(i)) ? back : front;
                if (namearray1.get(checkindex).equals(namearray2.get(i))
                        && namearray2.get(checkindex).equals(namearray1.get(i))) {
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}