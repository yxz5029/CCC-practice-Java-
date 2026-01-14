//import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
//import java.util.Map;
import java.util.Scanner;

class Friends0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new LinkedList<>();
        //Map<Integer, Integer> m = new HashMap<>(); // sometime we need to think a better one
        Integer[] friends = new Integer[10000];
        for (int i = 0; i < n; i++) {
            friends[sc.nextInt()] = sc.nextInt();
        }
        while (true) {
            s = 0;
             x = sc.nextInt();
            int y = sc.nextInt();
            if (x == 0 && y == 0) {
                break;
            }
            list.add(calculate(friends, x, y,n));
        }
        sc.close();
        for (String i : list) {
            System.out.println(i);
        }
    }
    static int x;
    static int s = 0;
    static int rs = 0;
    static boolean cyc = false;

    static String calculate(Integer[] f, int n1, int n2, int fn) {
        Integer n = f[n1];
        if(n == null){
            return "No";
        }
        if(n2 == n){
            cyc = true;
            rs = s;
        }
        if (x == n && cyc) {
            return "Yes " + rs;
        }else if(s == fn-1){
            return "No";
        }
        s++;
        return calculate(f, n, n2,fn);
    }
}


public class Friends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new LinkedList<>();
        Integer[] friends = new Integer[10000];
        for (int i = 0; i < n; i++) {
            friends[sc.nextInt()] = sc.nextInt();
        }
        while (true) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x == 0 && y == 0) {
                break;
            }
            Integer sep = calcSeparation(friends, x, y);
            if (sep != null) {
                if (calcSeparation(friends, y, x) == null) {
                    sep = null; // cannot reach x from y
                }
            }
            list.add(sep == null ? "No" : ("Yes "+sep));
        }
        sc.close();
        for (String i : list) {
            System.out.println(i);
        }
    }

    static Integer calcSeparation(Integer[] friends, int x, int y) {
        if (y == friends[x]) {
            return 0;
        }
        if (friends[x] == null) {
            return null;
        }

        Integer sep = calcSeparation(friends, friends[x], y);
        if (sep != null) {
            sep += 1;
        }
        return sep;
    }
}


/*
 * 
     int factorial(int n) {
        if (n == 1) return 1;

        return factorial(n-1) * n;
     }
 * 
 */