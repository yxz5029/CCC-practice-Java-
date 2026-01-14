import java.util.Scanner;
public class m1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] hat = new int[N];
        int result = 0;
        for(int i = 0; i < N;i++){
            hat[i] = sc.nextInt();
        }
        sc.close();
        for(int width = 0; width < N/2; width++){
            if(hat[width] == hat[width+(N/2)]){
                result += 2;
            }
        }
        System.out.println(result);
    }
}
