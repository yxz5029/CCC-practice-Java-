import java.util.Scanner;

public class BoringBusiness {
    public static void main0(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lr = -1;
        int ud = -5;
        int long1 = 28;
        String check = "Wrong";
        int[][] drill = new int[80001][2];
        int[] drill1 = { 0, -1, 0, -2, 0, -3, 1, -3, 2, -3, 3, -3, 3, -4, 3, -5, 4, -5, 5, -5, 5, -4, 5, -3, 6, -3, 7,
                -3, 7, -4, 7, -5, 7, -6, 7, -7, 6, -7, 5, -7, 4, -7, 3, -7, 2, -7, 1, -7, 0, -7, -1, -7, -1, -6, -1,
                -5 };
        for (int i = 0, j = 0; i < 28 && j < drill1.length; i++, j += 2) {
            drill[i][0] = drill1[j];
            drill[i][1] = drill1[j + 1];
        }
        while (true) {
            String drct = sc.next();
            int step = sc.nextInt();
            if (drct.equals("q")) {
                break;
            } else if (drct.equals("l") || drct.equals("r")) {
                f1: for (int i = 0; i < long1; i++) {
                    for (int j = 1; j <= step; j++) {
                        if (drct.equals("l")) {
                            check = drill[i][0] == lr - j && drill[i][1] == ud ? "DANGER"
                                    : "safe";

                        } else {
                            check = drill[i][0] == lr + j && drill[i][1] == ud ? "DANGER"
                                    : "safe";
                        }
                        if (check.equals("DANGER")) {
                            break f1;
                        }
                    }
                }
                if (drct.equals("l")) {
                    drill[long1][0] = lr - step;
                    drill[long1][1] = ud;
                    long1 += 1;
                    lr -= step;
                } else {
                    drill[long1][0] = lr + step;
                    drill[long1][1] = ud;
                    long1 += 1;
                    lr += step;
                }
            } else {
                f2: for (int i = 0; i < long1; i++) {
                    for (int j = 1; j <= step; j++) {
                        if (drct.equals("d")) {
                            check = drill[i][0] == lr && drill[i][1] == ud - j ? "DANGER"
                                    : "safe";

                        } else {
                            check = drill[i][0] == lr && drill[i][1] == ud + j ? "DANGER"
                                    : "safe";
                        }
                        if (check.equals("DANGER")) {
                            break f2;
                        }
                    }

                }
                if (drct.equals("d")) {
                    drill[long1][0] = lr;
                    drill[long1][1] = ud - step;
                    long1 += 1;
                    ud -= step;
                } else {
                    drill[long1][0] = lr;
                    drill[long1][1] = ud + step;
                    long1 += 1;
                    ud += step;
                }
            }
            System.out.println(drill[long1 - 1][0] + " " + drill[long1-1][1] + " " + check);
            if (check.equals("DANGER")) {
                break;
            }
        }
        sc.close();
    }
    static boolean[][] drill = new boolean[201][401];
        static int x = 201;
        static int y = 0;
        static boolean danger = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        drill[y][x] = true;
        down(2);
        right(3);
        down(2);
        right(2);
        up(2);
        right(2);
        down(4);
        left(8);
        up(2);
        while(!danger){
            String drct = sc.next();
            int step = sc.nextInt();
            if(drct.equals("q")){
                break;
            }
            else if(drct.equals("l")){
                left(step);
            } else if(drct.equals("r")){
                right(step);
            } else if(drct.equals("d")){
                down(step);
            } else if(drct.equals("u")){
                up(step);
            } 
            System.out.println((y - 201) + " " + (-1 - x) + (danger ?"DANGER":"safe"));
        }
        sc.close();
    }
    static void down(int d){
        for(int i = 0; i < d; i++){
            y++;
            if(drill[y][x]){
                danger = true;
                return;
            }else{
                drill[y][x] = true;
            }
        }
    }
    static void up(int d){
        for(int i = 0; i < d; i++){
            y--;
            if(drill[y][x]){
                danger = true;
                return;
            }else{
                drill[y][x] = true;
            }
        }
    }
    static void left(int d){
        for(int i = 0; i < d; i++){
            x--;
            if(drill[y][x]){
                danger = true;
                return;
            }else{
                drill[y][x] = true;
            }
        }
    }
    static void right(int d){
        for(int i = 0; i < d; i++){
            x++;
            if(drill[y][x]){
                danger = true;
                return;
            }else{
                drill[y][x] = true;
            }
        }
    }
}
