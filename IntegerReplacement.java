import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {
    public static void main(String[] args){
        int n = 8;
        System.out.println(find(n));

    }
    static Map<Long,Integer> map = new HashMap<>();
    static int find(long n){
        if(n == 1){
            return 0;
        }
        if(!map.containsKey(n)) {
            if (n % 2 == 0) {
                map.put(n, find(n / 2) + 1);
            } else map.put(n, Math.min(find(n + 1), find(n - 1)) + 1);
        }
        return map.get(n);
    }
}



// (hex)7F FF FF FF + 1 = (hex)80 00 00 00 (Integer.MIN_VALUE)