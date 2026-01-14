import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class m3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        int[] index = new int[N];
        int num = 0;
        int[][] range = new int[N][2];
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
            Arrays.fill(range[i],-1);
        }
        int a = 0;//
        int last = -1;//
        int b = -1;
        for(int j = 0; j < N; j++){
            B[j] = sc.nextInt();
            if(B[j] == b){

            }else{
                b = B[j];
            }
            if(B[j] != last){
                while(a<N-1&&B[j] != A[a]){
                    a++;
                }
                if (B[j] == A[a]) {
                    index[j] = a;
                    last = B[j];
                    if(j != a){
                        num++;
                    }
                }else{
                    System.out.println("NO");
                    return;
                }
            }else{
                index[j] = a;
            }
        }
        for(int i=0; i<index.length; ) {
            int left = i;
            int right = i;
            while(right < index.length-1 && index[right+1] == index[left]) {
                right++;
            }
            i = right+1;
        }
        /*
        System.out.println("YES");
        System.out.println(num);
        for(int i = 0; i < index.length; i++){
            int r = index[i];
            int l = -1;
            for(int j = i;j < index.length-1;j++){
                if(r == index[j+1]){
                    l = j;
                }
            }
            if(index[i] != i){
                if(index[i] > i){
                    System.out.println("R");
                }else{
                    System.out.println("L");
                }
                System.out.println((i+1)+" "+(Math.abs(index[i]-i)+1));
            }
        }
         */

        for(int i = 0; i < index.length; i++) {
            if(index[i] != i){
                if(index[i] < i){
                    range[index[i]][1] = i;
                }else{
                    range[index[i]][0] = i;
                }
            }
            System.out.println(index[i]);
            System.out.println(range[i][0]+" "+range[i][1]);
        }
        for(int i = 0; i < index.length;i++){
            if(range[i][0] != -1){

            }
        }
/*
    8
    7 5 1 8 7 4 7 4
    7 7 5 5 5 5 4 4

    0 0 1 1 1 1 5 5
    0 1 2 3 4 5 6 7

    0 0 1 1 1 1 5 5

    0 1
    1 5
    5 7


    0   1
    0 1 2         6
    0 0 1 1 1 1 1 1

    3 7 1 2 6 6 5 4 4 5 3
    3 1 1 1 6 5 5 4 4 4 4


    0 2 2 2 4 6 6 7 7 7 7
    0 1 2 3 4 5 6 7 8 9 10
    0 1   3

    6
    1 2 5 3 4 3
    2 2 3 4 3 3

    3 4 5 6
    6 4 3 5
     */

        /*
        6
        1 2 5 3 4 3
        2 2 3 4 3 3
         */
    }

    public static void main0(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] B = new int[N+1];
        int[][] dp = new int[N+1][N+1];
        int[] same = new int[N+1];
        LinkedList<String> list = new LinkedList<>();
        boolean result = true;
        String dire = "";
        Arrays.fill(dp[0],-2);
        dp[1][0] = -2;
        Arrays.fill(same,-1);
        String a = "";
        String b = "";
        for(int i = 1; i <= N; i++){
            a = a+sc.nextInt();
        }for(int j = 1; j <= N; j++){
            B[j] = sc.nextInt();
            b = b+B[j];
            if(!a.contains(B[j]+"")){
                result = false;
            }
        }
        if(!result){
            System.out.println("NO");
        }else if(a.equals(b)){
            System.out.println("YES");
            System.out.println(0);
        }else {
            for(int i = 1; i < N+1; i++){
                dp[1][i] = B[i];
            }
            for (int width = 2; width <= N; width++) {
                for (int j = 1; j <= N - width+1; j++) {
                    if (B[j] == B[j + (width - 1)] && (dp[width - 2][j + 1] == B[j]||dp[width - 2][j + 1] == -2)) {
                        dp[width][j] = B[j];
                        same[j] = j+(width-1);
                    }
                }
            }
            for(int i = 1; i < N; i++){
                if(same[i] == -1){
                    if(i != 1){
                        String q = a.charAt(i-2)+"";
                        String h = a.charAt(i)+"";
                        /*
                        if(q.equals(B[i]+"") ){
                            dire += "L";
                            list.addLast(a.charAt(i-2)+" "+a.charAt(i-1));
                            a = a.substring(0,i-1)+b.substring(i-1,same[i])+a.substring(i);
                        }*/
                        if(h.equals(B[i]+"")){
                            dire += "R";
                            list.addLast(a.charAt(i-1)+" "+a.charAt(i));
                            a = a.substring(0,i-1)+B[i]+a.substring(i);
                        }
                    }
                    continue;
                }else{
                    String s = a.substring(i-1,same[i]);
                    int index = s.indexOf(B[i]+"");
                    index += i-1;
                    if(index >= i-1 && index <= same[i]-1){
                        if(index == i-1){
                           dire += "R";
                           list.addLast(a.charAt(i-1)+" "+a.charAt(same[i]-1));
                        }else if(index == same[i]-1){
                            dire += "L";
                            list.addLast(a.charAt(i-1)+" "+a.charAt(same[i]-1));
                        }else{
                            dire += "L";
                            list.addLast(a.charAt(i-1)+" "+a.charAt(index));
                            dire += "R";
                            list.addLast(a.charAt(index)+" "+a.charAt(same[i]-1));
                        }
                        a = a.substring(0,i-1)+b.substring(i-1,same[i])+a.substring(same[i]);
                    }
                }
                if(a.equals(b)){
                    break;
                }
            }
            if(a.equals(b)) {
                System.out.println("YES");
                System.out.println(list.size());
                for(int i = 0; i < list.size();i++){
                    System.out.println(dire.charAt(i)+" "+list.get(i));
                }
            }else{
                System.out.println("NO");
            }
        }

    }

}
