import java.util.Scanner;

public class GoodSample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        sc.close();
        String r = "";
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++) {
            int rem = N - i-1;
            int cur = Math.min(K - rem, M);
            if (cur <= 0 || K > ((1+M)*M/2)+((N-M)*M)) {
                break;
            }
            int val;
            if(cur > i){
                val = Math.min(M,i+1);
                cur = val;
            }else{
                val = sequence[i-cur];
            }
            sequence[i] = val;
            if(!r.isEmpty()) {
                r = r + " " + val;
            }else{
                r = ""+val;
            }
            K = K-cur;
        }
        if(K == 0 && sequence[N-1] != 0){
            System.out.println(r);
        }else{
            System.out.println(-1);
        }
    }
}