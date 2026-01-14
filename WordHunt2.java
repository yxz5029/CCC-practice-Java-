import java.util.Scanner;

class WordHunt2 {

    static enum Direction {
        U,
        D,
        R,
        L,
        UL,
        UR,
        DL,
        DR;
    }
    static char[][] wbox;
    static String word;
    static int R, C;
    static Direction prev;

    public static void main(String[] args){
        Scanner sc = new Scanner(WordHunt2.class.getResourceAsStream("wh.txt"));
        word = sc.nextLine();
        //sc.nextLine();
       // R = Integer.parseInt(sc.nextLine());
       R = sc.nextInt();
        C = sc.nextInt();
        wbox = new char[R][C];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++)
                wbox[i][j] = sc.next().charAt(0);
        }
        sc.close();

        //Direction dir = Direction.R;

        int result = 0; 
        for(int j = 0; j < R; j++){
            for(int i = 0; i < C; i++){
                prev = null;
                result = findword(j, i, 0, null);
            }
        }
    }
    /* 
    static void findwordR(int r, int c, int w) {
        if(w >= word.length()) {
            result++;
        }
        if (c >= C) {
            return;
        }

        if(wbox[r][c] == word.charAt(w)){
            findwordR(r, c+1, w+1);
        }
    }
    static void findwordL(int r, int c, int w) {
        if(w >= word.length()) {
            result++;
        }
        if (c < 0) {
            return;
        }

        if(wbox[r][c] == word.charAt(w)){
            findwordL(r, c-1, w+1);
        }
    }
    static void findwordU(int r, int c, int w) {
        if(w >= word.length()) {
            result++;
        }
        if (r < 0) {
            return;
        }

        if(wbox[r][c] == word.charAt(w)){
            findwordR(r-1, c, w+1);
        }
    }
    static void findwordD(int r, int c, int w) {
        if(w >= word.length()) {
            result++;
        }
        if (r >= R) {
            return;
        }

        if(wbox[r][c] == word.charAt(w)){
            findwordD(r+1, c, w+1);
        }
///*
        for (; w < word.length() && r < R; r--, w++) {
            if(wbox[r][c] != word.charAt(w)){
                break;
            }
        }
        if(w >= word.length()) {
            result++;
        }



    }
    static void findwordRU(int r, int c, int w) {
        if(w >= word.length()) {
            result++;
        }
        if (r < 0 || c >= C) {
            return;
        }

        if(wbox[r][c] == word.charAt(w)){
            findwordRU(r-1, c+1, w+1);
        }
    }
*/
    static int findword(int r, int c, int w, Direction dir) {
        if(w >= word.length()-1) {
            return 1;
        }
        if (r < 0 || r >= R || c < 0 || c >= C) {
            return 0;
        }
        if(wbox[r][c] != word.charAt(w)){
            return 0;
        }

        int sum = 0;
        if (prev != dir) {
            switch(dir) {
                case L: c--; break;
                case R: c++; break;
                case U: r--; break;
                case D: r++; break;
                case UR: r--; c++; break;
                case UL: r--; c--; break;
                case DR: r++; c++; break;
                case DL: r++; c--; break;
            }
            sum += findword(r, c, w+1, dir);
        }
        else {
            if (w==0) prev = Direction.D;
            if (prev == Direction.D || prev == Direction.L || prev == Direction.R) {
                sum += findword(r+1, c, w+1, Direction.D);
            }

            if (w==0) prev = Direction.U;
            if (prev == Direction.U || prev == Direction.L || prev == Direction.R) {
                sum += findword(r-1, c, w+1, Direction.U);
            }

            if (w==0) prev = Direction.L;
            if (prev == Direction.L || prev == Direction.U || prev == Direction.D) {
                sum += findword(r, c-1, w+1, Direction.L);
            }

            if (w==0) prev = Direction.R;
            if (prev == Direction.R || prev == Direction.U || prev == Direction.D) {
                sum += findword(r, c+1, w+1, Direction.R);
            }

            if (w==0) prev = Direction.UR;
            if (prev == Direction.UR || prev == Direction.UL || prev == Direction.DR) {
                sum += findword(r-1, c+1, w+1, Direction.UR);
            }

            if (w==0) prev = Direction.UL;
            if (prev == Direction.UL || prev == Direction.DL || prev == Direction.UR) {
                sum += findword(r-1, c-1, w+1, Direction.UL);
            }

            if (w==0) prev = Direction.DL;
            if (prev == Direction.DL || prev == Direction.UL || prev == Direction.DR) {
                sum += findword(r+1, c-1, w+1, Direction.DL);
            }

            if (w==0) prev = Direction.DR;
            if (prev == Direction.DR || prev == Direction.UR || prev == Direction.DL) {
                sum += findword(r+1, c+1, w+1, Direction.DR);
            }
        }
        return sum;
    }
}
