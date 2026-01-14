import java.util.Scanner;
/*
class CrossSpiral2 {
    static boolean[][] room; // = null
    static int mh = 0;
    static int mw = 0;
    static int h1 = 0;
    static int v1 = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int v = sc.nextInt();
        int hco = sc.nextInt();
        int vco = sc.nextInt();
        int step = sc.nextInt();
        sc.close();
        h1 = h;
        v1 = v;
        room = new boolean[v][h];
        for (int j = 0; j < vco; j++) {
            for (int i = 0; i < hco; i++) {
                if (i < hco||i > h - hco - 1){
                        room[j][i] = true;
                        room[j][i+h-hco] = true;
                        room[j+v-vco][i] = true;
                        room[j+v-vco][i+h-hco] = true; 
                }else {
                    room[j][i] = false;
                }
            }
            right(0, hco, step);
        }
    }
    static void right(int nh, int nw, int step) {
        while (step != 0) {
            if (nw < h1 && !room[nh][nw]) {
                if (nw != 0 && nh != 0 && room[nh - 1][nw - 1]) {
                        up(nh, nw - 1, step, room);
                        break;
                } else {
                    room[nh][nw] = true;
                    nw++;
                    step--;
                }
            } else {
                down(nh, nw - 1, step, room);
                
            }
        }
        System.out.println(nh + " " + nw);
    }

    static void down(int nh, int nw, int step) {
        while (step != 0) {
            if (nh < v1 && !room[nh][nw]) {
                if (nh != 0 && nw != 0&&room[nh - 1][nw + 1]) {
                        left(nh, nw - 1, step, room);
                        return;
                } else {
                    room[nh][nw] = true;
                    nh++;
                    step--;
                }
            } else {
                right(nh - 1, nw, step, room);
                return;
            }
        }
        System.out.println(nh - 1 + " " + nw);
    }

    static void up(int nh, int nw, int step,boolean room) {
        while (step != 0) {
            if (nh >= 0 && !room[nh][nw]) {
                if (nh != 0 && nw != 0&&room[nh + 1][nw - 1]) {
                        left(nh, nw - 1, step, room);
                        return;
                } else {
                    room[nh][nw] = true;
                    nh--;
                    step--;
                }
            } else {
                right(nh - 1, nw, step, room);
                return;
            }
        }
        System.out.println(nh - 1 + " " + nw);
    }

    static void left(int nh, int nw, int step) {
        while (step != 0) {
            if (nw >= 0 && !room[nh][nw] && room[nh + 1][nw + 1]) {
                if (nh != 0 && nw != 0&&room[nh + 1][nw + 1]) {
                        down(nh, nw - 1, step, room);
                        return;
                } else {
                    room[nh][nw] = true;
                    nw--;
                    step--;
                }
            } else {
                up(nh, nw - 1, step, room);
                return;
            }
        }
        System.out.println(nh + " " + nw);
    }
}
/*static void right(int nh, int nw, int step, boolean[][] room) {
        while (step != 0) {
            if (nw < h1 && !room[nh][nw]) {
                if (nw != 0 && nh != 0 && room[nh - 1][nw - 1]) {
                        up(nh, nw - 1, step, room);
                        break;
                } else {
                    room[nh][nw] = true;
                    nw++;
                    step--;
                }
            } else {
                down(nh, nw - 1, step, room);
            }
        }
        System.out.println(nh + " " + nw);
    }

    static void down(int nh, int nw, int step, boolean[][] room) {
        while (step != 0) {
            if (nh < v1 && !room[nh][nw]) {
                if (nh != 0 && nw != 0&&room[nh - 1][nw + 1]) {
                        left(nh, nw - 1, step, room);
                        return;
                } else {
                    room[nh][nw] = true;
                    nh++;
                    step--;
                }
            } else {
                right(nh - 1, nw, step, room);
                return;
            }
        }
        System.out.println(nh - 1 + " " + nw);
    }

    static void up(int nh, int nw, int step, boolean[][] room) {
        while (step != 0) {
            if (nh >= 0 && !room[nh][nw]) {
                if (nh != 0 && nw != 0&&room[nh + 1][nw - 1]) {
                        left(nh, nw - 1, step, room);
                        return;
                } else {
                    room[nh][nw] = true;
                    nh--;
                    step--;
                }
            } else {
                right(nh - 1, nw, step, room);
                return;
            }
        }
        System.out.println(nh - 1 + " " + nw);
    }

    static void left(int nh, int nw, int step, boolean[][] room) {
        while (step != 0) {
            if (nw <= 0 && !room[nh][nw] && room[nh + 1][nw + 1]) {
                if (nh != 0 && nw != 0&&room[nh + 1][nw + 1]) {
                        down(nh, nw - 1, step, room);
                        return;
                } else {
                    room[nh][nw] = true;
                    nw--;
                    step--;
                }
            } else {
                up(nh, nw - 1, step, room);
                return;
            }
        }
        System.out.println(nh + " " + nw);
    }
}
 */