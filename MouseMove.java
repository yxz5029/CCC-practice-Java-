import java.util.Scanner;

public class MouseMove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int r = sc.nextInt();
        int positionx = 0;
        int positiony = 0;
        while (true) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x == 0 && y == 0) {
                break;
            }
            positionx += x;
            if (positionx > c) {
                positionx = c;
            } else if(positionx < 0){
                positionx = 0;
            }
            positiony += y;
            if (positiony > r) {
                positiony = r;
            } else if(positiony < 0) {
                positiony = 0;
            }
            System.out.println(positionx + " " + positiony);
        }
        sc.close();
    }
}
