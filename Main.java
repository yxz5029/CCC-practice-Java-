import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Q = sc.nextInt();
        ArrayList<Integer> list = new ArrayList();
        Map<Integer,ArrayList<Integer>> map = new HashMap();
        int max = 0;
        for(int i = 0 ; i < N; i++) {
            int j = sc.nextInt();
            int p = sc.nextInt();
            if(!map.containsKey(p)) {
                map.put(p, new ArrayList<>());
            }
            map.get(p).add(j);
            if(!list.contains(p)) {
                list.add(p);
            }
            Collections.sort(map.get(p));
            max = Math.max(max,p);
        }
        Collections.sort(list);
        int pretty = 0;
        int last = 0;
        boolean change = false;
        int m = M-1;
        if(m == N){
        }
        w:for(int i = list.size()-1; i >= 0; i--) {
            for(int j = 0; j < map.get(list.get(i)).size();j++) {
                if(m < 0){
                    break w;
                }
                int now = map.get(list.get(i)).get(j);
                if(last == now && change) {
                    continue;
                }
                if(last == now && !change){
                    change = true;
                }
                pretty += list.get(i);
                m--;
            }
        }
        System.out.println(pretty);
    }
}
