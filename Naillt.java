import java.util.Scanner;

public class Naillt {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] woods = new int[2001];
        int[] boards = new int[4001];

        // woods[1000] = 50_000;
        // boards[1000] = 20_000;

        for(int i = 0; i < n; i++){
            woods[sc.nextInt()]++;
        }
        sc.close();
        for(int i = 1; i < woods.length; i++){
            if (woods[i] > 0) {
                boards[i*2] += woods[i]/2;
                for(int j = i+1; j < woods.length; j++){
                    if(woods[j] >0){
                        boards[j+i] += Math.min(woods[i], woods[j]);
                    }
                }
            }
        }
        int len = 0;
        int total = 0;
        for(int i = 2; i < boards.length; i++){
            if(boards[i] > len){
                len = boards[i];
                total = 1;
            }else if(boards[i] == len){
                total++;
            }
        }
        System.out.println(len + " " + total);
    }

}