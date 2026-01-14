import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CountSubarraysWithMoreOnesThanZeros {
    public static void main(String[] args){
        int[] nums = {0,1,1,1,1}; // 1: 4, 11: 3, 111: 2, 1111: 1, 0+: 3:
        System.out.println(find(nums));

    }
    public static int find(int[] arr){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int M = 1_000_000_007;
        int total = 0;
        int sum = 0;
        map.put(0,1);
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) {
                sum -= 1;
                cnt -= map.getOrDefault(sum, 0);
            }else {
                sum += arr[i];
                cnt += map.getOrDefault(sum - 1, 0);
                cnt = cnt % M;
            }
            total = (total+cnt) % M;
            map.put(sum,1+map.getOrDefault(sum, 0));
        }
        return total;
    }
    public static int findsum(int[] arr){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int total = 0;
        map.put(0,1);
        for(int i = 1; i <= arr.length; i++){
            sum += arr[i];
            map.put(i,sum);
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                if(i == j){
                    if(arr[i] == 1){
                        total++;
                        System.out.println(i);
                    }
                }else if((map.get(j)-map.get(i))*2 > j-i+1){
                    total++;
                    System.out.println(i+" "+j);
                }
            }
        }
        return total;
    }
}
