import java.util.LinkedList;

public class JumpGame3 {
    public static void main(String[] args){
        int[] arr = {4,2,3,0,3,1,2};
        int start = 5;
        LinkedList<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        que.add(start);
        boolean result = false;
        while(!que.isEmpty()){
            int i = que.removeFirst();
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            if(arr[i] == 0){
                result = true;
                break;
            }
            if(arr[i]+i < arr.length) {
                que.add(arr[i] + i);
            }
            if(i-arr[i] >= 0){
                que.add(i-arr[i]);
            }
        }
        System.out.println(result);
    }
}
