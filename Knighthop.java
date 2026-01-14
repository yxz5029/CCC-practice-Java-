import java.util.Scanner;
import java.util.LinkedList;

public class Knighthop {

    static int[][] chessboard0 = new int[8][8];
    static Integer[][] chessboard = new Integer[8][8];
    static Coordinate k;
    static Coordinate cend;
    static LinkedList<Coordinate> candidates = new LinkedList<>();
 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt()-1;
        int y = sc.nextInt()-1;
        k = new Coordinate(x, y);
        x = sc.nextInt()-1;
        y = sc.nextInt()-1;
        cend = new Coordinate(x,y);
        sc.close();

        chessboard[k.x][k.y] = 0;

        // we need a queue
        candidates.addLast(k);

        while (candidates.size() > 0 && chessboard[cend.x][cend.y] == null) {
            Coordinate p = candidates.removeFirst();
            int steps = chessboard[p.x][p.y] + 1;

            processPoint(p.x+1, p.y+2, steps);
            processPoint(p.x+1, p.y-2, steps);
            processPoint(p.x+2, p.y+1, steps);
            processPoint(p.x+2, p.y-1, steps);
            processPoint(p.x-1, p.y-2, steps);
            processPoint(p.x-1, p.y+2, steps);
            processPoint(p.x-2, p.y+1, steps);
            processPoint(p.x-2, p.y-1, steps);

        }

        if (chessboard[cend.x][cend.y] == null) {
            // not found
        }
        else {
            // found
        }


    }

    static void processPoint(int x, int y, int steps) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8) {
            if (chessboard[x][y] == null) {
                chessboard[x][y] = steps;
                candidates.addLast(new Coordinate(x, y));
            }
        }

    }    

}










class KnighthopX {
    public static void main(String[] args){

        // byte, short, int, long, double, float, boolean, char
        long i = 20000;
        // assume i is located address 50, it size is 8 byte
        // we store value 20000 in it.

        // Class: variables are reference (pointer)

        // sc: 8 bytes, store address
        // assume sc itself is at address 100. We store 0 at this address
        Scanner sc = new Scanner(System.in);

        // after new Scanner(), it is stored at address 20000. allocate 20 bytes
        // we store value 20000 at sc (at address 100)

        // another new Scanner， at address 20020 to 20039
        sc = new Scanner(System.in);


        k.x = sc.nextInt();
        k.y = sc.nextInt();
        cend.x = sc.nextInt();
        cend.y = sc.nextInt();
        sc.close();



       // chessboard[cend.y][cend.x] = true;
        //while(!chessboard[k.y][k.x]){
        if(k.y < cend.y && k.x < cend.x){
            thirdqdt(k.y,k.x,cend.y,cend.x);
        }
    }
    static Coordinate k = new Coordinate(9,9);
    static Coordinate cend = new Coordinate(9,9);
    static Integer[][] chessboard = new Integer[8][8];

    static void thirdqdt(int ky, int kx, int cy, int cx){                       
        int com = 0;
        if(cy - 2 >= 0 && cx - 1 >= 0){
        com = Math.abs((cy -  + cx - 1) - (8));
        }
    }
}
class Coordinate {
    int x;
    int y;

    // constructor
    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}