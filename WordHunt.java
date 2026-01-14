import java.util.Scanner;

public class WordHunt {

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
    static int R, C,result;
    public static void main(String[] args){
        Scanner sc = new Scanner(WordHunt.class.getResourceAsStream("wh.txt"));
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

        result = 0; 
        for(int j = 0; j < R; j++){
            for(int i = 0; i < C; i++){
                if(wbox[j][i] == word.charAt(0)){
                    findword(j, i+1, 1, Direction.R);
                    findword(j, i-1, 1, Direction.L);
                    findword(j-1, i, 1, Direction.U);
                    findword(j+1, i, 1, Direction.D);
                    findword(j-1, i-1, 1, Direction.UL);
                    findword(j-1, i+1, 1, Direction.UR);
                    findword(j+1, i-1, 1, Direction.DL);
                    findword(j+1, i+1, 1, Direction.DR);
                    /*  findwordL(j, i-1, 1);
                    // findwordU(j-1, i, 1);
                    // findwordD(j+1, i, 1);
                    // findwordRU(j-1, i+1, 1);
                    */
                }
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
    static void findword(int r, int c, int w, Direction dir) {
        if(w >= word.length()) {
            result++;
            return;
        }
        if (r < 0 || r >= R || c < 0 || c >= C) {
            return;
        }

        if(wbox[r][c] == word.charAt(w)){
            switch(dir) {
                case L: c--; if (w != word.length()-1){ findword_turn(r-1,c,w+1,Direction.U);findword_turn(r+1,c,w+1,Direction.D);} break;
                case R: c++; if (w != word.length()-1){findword_turn(r-1,c,w+1,Direction.U);findword_turn(r+1,c,w+1,Direction.D);} break;
                case U: r--; if (w != word.length()-1){findword_turn(r+1,c-1,w+1,Direction.L);findword_turn(r,c+1,w+1,Direction.R);} break;
                case D: r++; if (w != word.length()-1){findword_turn(r,c-1,w+1,Direction.L);findword_turn(r,c+1,w+1,Direction.R);} break;
                case UR: r--; c++; if (w != word.length()-1){findword_turn(r-1,c-1,w+1,Direction.UL);findword_turn(r+1,c+1,w+1,Direction.DR);} break;
                case UL: r--; c--; if (w != word.length()-1){findword_turn(r-1,c+1,w+1,Direction.UR);findword_turn(r+1,c-1,w+1,Direction.DL);} break;
                case DR: r++; c++; if (w != word.length()-1){findword_turn(r-1,c-1,w+1,Direction.UL);findword_turn(r+1,c+1,w+1,Direction.DR);} break;
                case DL: r++; c--; if (w != word.length()-1){findword_turn(r-1,c+1,w+1,Direction.UR);findword_turn(r+1,c-1,w+1,Direction.DL);} break;
            }
            findword(r, c, w+1, dir);
        }
    }
    static void findword_turn(int r, int c, int w, Direction dir) {
        if(w >= word.length()) {
            result++;
        }
        if (r < 0 || r >= R || c < 0 || c >= C) {
            return;
        }

        if(wbox[r][c] == word.charAt(w)){
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
            findword_turn(r, c, w+1, dir);
        }
    }
}
