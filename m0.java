import java.util.Arrays;
import java.util.Scanner;

public class m0 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();
        int C = sc.nextInt();
        Character[][] poster = new Character[N][M];
        if(R != 0||C!=0){
            for(Character[] a: poster){
                Arrays.fill(a,'a');
            }
            int rleft = N-R;
            int cleft = M-C;
        }else{
            System.out.println("IMPOSSIBLE");
        }
    }
}
