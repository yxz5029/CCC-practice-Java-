import java.util.Scanner;

public class CrossSpiral {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(); // columns
        int v = sc.nextInt(); // rows
        int hco = sc.nextInt();
        int vco = sc.nextInt();
        int step = sc.nextInt();
        sc.close();
        int nh = 0;
        int nw = hco;
        boolean[][] room = new boolean[v][h];
        // step += 1;
        for (int j = 0; j < vco; j++) {
            for (int i = 0; i < hco; i++) {
                room[j][i] = true;
                room[j][i + h - hco] = true;
                room[j + v - vco][i] = true;
                room[j + v - vco][i + h - hco] = true;
            }
        }
        room[nh][nw] = true;
        while (step > 0) {
            step--;

            if (nh < 1 || room[nh - 1][nw]) { // top occupied, we can consider move right
                if (nw + 1 < h && !room[nh][nw + 1]) { // can move right
                    nw += 1;
                    room[nh][nw] = true;
                    continue;
                }
            }

            if ((nw+1) >= h || room[nh][nw+1]) { // righ occupied, we can consider move 
                if (nh + 1 < v && !room[nh+1][nw]) { // can move down
                    nh += 1;
                    room[nh][nw] = true;
                    continue;
                }
            }

            if ((nh+1) >= v || room[nh+1][nw]) { // bottom occupied, we can consider move left 
                if (nw - 1 >= 0 && !room[nh][nw-1]) { // can move left
                    nw -= 1;
                    room[nh][nw] = true;
                    continue;
                }
            }

            if ((nw-1) < 0 || room[nh][nw-1]) { // left occupied, we can consider move up 
                if (nh - 1 >= 0 && !room[nh-1][nw]) { // can move up
                    nh -= 1;
                    room[nh][nw] = true;
                    continue;
                }
            }
            
            break; // cannot move
        }
        System.out.println((nw + 1));
        System.out.println((nh + 1));
    }
}
/*
 * static int mh = 0;
 * static int mw = 0;
 * static int h = 0;
 * static int v = 0;
 * 
 * static void right(int nh, int nw, int step, boolean[][] room) {
 * while (step != 0) {
 * if (nw < h && !room[nh][nw]) {
 * if (nw != 0 && nh != 0 && room[nh - 1][nw - 1]) {
 * up(nh, nw - 1, step, room);
 * break;
 * } else {
 * room[nh][nw] = true;
 * nw++;
 * step--;
 * }
 * } else {
 * down(nh, nw - 1, step, room);
 * }
 * }
 * System.out.println(nh + " " + nw);
 * }
 * 
 * static void down(int nh, int nw, int step, boolean[][] room) {
 * while (step != 0) {
 * if (nh < v && !room[nh][nw]) {
 * if (nh != 0 && nw != 0&&room[nh - 1][nw + 1]) {
 * left(nh, nw - 1, step, room);
 * return;
 * } else {
 * room[nh][nw] = true;
 * nh++;
 * step--;
 * }
 * } else {
 * right(nh - 1, nw, step, room);
 * return;
 * }
 * }
 * System.out.println(nh - 1 + " " + nw);
 * }
 * 
 * static void up(int nh, int nw, int step, boolean[][] room) {
 * while (step != 0) {
 * if (nh >= 0 && !room[nh][nw]) {
 * if (nh != 0 && nw != 0&&room[nh + 1][nw - 1]) {
 * left(nh, nw - 1, step, room);
 * return;
 * } else {
 * room[nh][nw] = true;
 * nh--;
 * step--;
 * }
 * } else {
 * right(nh - 1, nw, step, room);
 * return;
 * }
 * }
 * System.out.println(nh - 1 + " " + nw);
 * }
 * 
 * static void left(int nh, int nw, int step, boolean[][] room) {
 * while (step != 0) {
 * if (nw >= 0 && !room[nh][nw] && room[nh + 1][nw + 1]) {
 * if (nh != 0 && nw != 0&&room[nh + 1][nw + 1]) {
 * down(nh, nw - 1, step, room);
 * return;
 * } else {
 * room[nh][nw] = true;
 * nw--;
 * step--;
 * }
 * } else {
 * up(nh, nw - 1, step, room);
 * return;
 * }
 * }
 * System.out.println(nh + " " + nw);
 * }
 * }
 * /*static void right(int nh, int nw, int step, boolean[][] room) {
 * while (step != 0) {
 * if (nw < h1 && !room[nh][nw]) {
 * if (nw != 0 && nh != 0 && room[nh - 1][nw - 1]) {
 * up(nh, nw - 1, step, room);
 * break;
 * } else {
 * room[nh][nw] = true;
 * nw++;
 * step--;
 * }
 * } else {
 * down(nh, nw - 1, step, room);
 * }
 * }
 * System.out.println(nh + " " + nw);
 * }
 * 
 * static void down(int nh, int nw, int step, boolean[][] room) {
 * while (step != 0) {
 * if (nh < v1 && !room[nh][nw]) {
 * if (nh != 0 && nw != 0&&room[nh - 1][nw + 1]) {
 * left(nh, nw - 1, step, room);
 * return;
 * } else {
 * room[nh][nw] = true;
 * nh++;
 * step--;
 * }
 * } else {
 * right(nh - 1, nw, step, room);
 * return;
 * }
 * }
 * System.out.println(nh - 1 + " " + nw);
 * }
 * 
 * static void up(int nh, int nw, int step, boolean[][] room) {
 * while (step != 0) {
 * if (nh >= 0 && !room[nh][nw]) {
 * if (nh != 0 && nw != 0&&room[nh + 1][nw - 1]) {
 * left(nh, nw - 1, step, room);
 * return;
 * } else {
 * room[nh][nw] = true;
 * nh--;
 * step--;
 * }
 * } else {
 * right(nh - 1, nw, step, room);
 * return;
 * }
 * }
 * System.out.println(nh - 1 + " " + nw);
 * }
 * 
 * static void left(int nh, int nw, int step, boolean[][] room) {
 * while (step != 0) {
 * if (nw <= 0 && !room[nh][nw] && room[nh + 1][nw + 1]) {
 * if (nh != 0 && nw != 0&&room[nh + 1][nw + 1]) {
 * down(nh, nw - 1, step, room);
 * return;
 * } else {
 * room[nh][nw] = true;
 * nw--;
 * step--;
 * }
 * } else {
 * up(nh, nw - 1, step, room);
 * return;
 * }
 * }
 * System.out.println(nh + " " + nw);
 * }
 * }
 */