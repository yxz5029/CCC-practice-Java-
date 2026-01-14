import java.util.Scanner;

public class m2 {
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N = sc.nextInt();
        int[] check = new int[T];
        String[] letters = new String[T];
        for(int i = 0; i < T; i++){
            letters[i] = sc.next();
        }
        for(int i = 0; i < T; i++){
            w:for(int j = 0; j < N; j++){
                String l = letters[i];
                String ch = letters[i].substring(j,j+1);
                l = letters[i].substring(0,j)+ letters[i].substring(j+1);
                if(l.contains(ch)){
                    if(check[i] != 2){
                        check[i] = 2;
                    }else{
                        check[i] = -1;
                        break w;
                    }
                }else{
                    if(check[i] != 1){
                        check[i] = 1;
                    }else{
                        check[i] = -1;
                        break w;
                    }
                }
            }
        }
        for(int i = 0; i< T; i++) {
            System.out.println(check[i] != -1 ? "T" : "F");
        }
    }
}
