import java.util.Scanner;

public class dressup {
    static Scanner scn = new Scanner(System.in);


    static void f() {
        scn.nextInt();
    }


    public static void main(String[] ages) {
        Scanner scn = new Scanner(System.in);
        int v = scn.nextInt();
        String[][] asterisk = new String[v][2 * v];
        if (v % 2 == 0) {
            System.out.println("Fales");
        } else {
            String a = "";
            for (int i = 0; i < v / 2; i++) {
                for (int j = 0; j <= i + (i + 1); j++){
                    for (int t = 2 * v - 1; t >= 2 * v - j; t--) {
                        asterisk[i][j] = '*' + a;
                        asterisk[i][t] = '*' + a;
                    }
                }
            }
            for(int o = 1; o < 2*v; o++){
            asterisk[v/2][o] = '*' + a;
            }
            
            for (int i = v / 2 + 1; i < v; i++) {
                for (int j = 2*v - 2*i - 1; j >= 0; j--)
                    for (int t = 2*v - j; t < 2 * v; t++) {
                        {
                            asterisk[i][j] = '*' + a;
                            asterisk[i][t] = '*' + a;
                        }
                    }
            }
        }
        /*
        for(String[] line : asterisk) {
            for (String s : line) {
                System.out.print(s == null ? " " : s);
            }
            System.out.println();
        }
         */
        for(int i = 0; i < asterisk.length; i++) {
            for (int j=0; j<asterisk[i].length; j++) {
                System.out.print(asterisk[i][j] == null ? " " : asterisk[i][j]);
            }
            System.out.println();
        }

       //System.out.println(asterisk);
    }
}



class DressUp2 {

    static public void main(String[] a) {
        print(6);
    }


    static void printLine(boolean[] line) {
        /*
        for (boolean star : line) {
            System.out.print(star ? '*' : ' ');
        }
         */
        for (int i=0; i<line.length; i++) {
            System.out.print(line[i] ? '*' : ' ');
        }
        System.out.println();
    }


    static void print(int num) {
        boolean[] line = new boolean[num*2];
        line[0] = true;
        line[line.length-1] = true;

        printLine(line);
        int p = 1;
        while (--num > 0) {
            line[p] = !line[p];
            line[p+1] = !line[p+1];
            line[line.length-p-1] = !line[line.length-p-1];
            line[line.length-p-2] = !line[line.length-p-2];
            p += 2;
            printLine(line);
        }

    }




}



class LoopDemo {


    void demoContinue() { // applies to other loop: while, do... while

        int[] arr = new int[100];

        for (int i=0; i<arr.length; i++) {
            if (i % 2 == 0) {
                continue;
            }
 
            System.out.println(i);
        }


        nextI : for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                if (i % 2 == 0) {
                    continue nextI;
                }
                System.out.println(j);
            }
     
            System.out.println(i);
        }


    }

    void demoBreak() {
        int[] arr = new int[100];

        for (int i=0; i<arr.length; i++) {
            if (i % 2 == 0) {
                break;
            }
 
            System.out.println(i);
        }


        nextI : for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                if (i % 2 == 0) {
                    break nextI;
                }
                System.out.println(j);
            }
     
            System.out.println(i);
        }

    }

    void demoSwitch(int i) {
        int s = 0;

        switch(i) {
            case 0: s = 1; break;
            case 3: s = 100; break;
            case 5: 
                s = 500;
                s++;
                s--;
                break;
            default: s = 700; // optional
        }

    }


    void demoLiteral() {
        String str = "string literal\nsecond\tline"; // single line
        char ch = 'a';
        ch = '\u12AB';

        int i = 123;  // default, integer literal is int type
        byte b = 127;
        short s = 123;
        long l = 123L; // 123l 

        // octal
        i = 017;  // no digit 8 and 9 
        i = 0xBEEF; // hex, 0xbeef
        i = 0b00101001; // binary        

        i = 1_123_456; // 1,234,567

        double d = 2.3;  // 2.3D, 2.3d, .3; .3D
        float f = 2.3F; // 2.3f

        // void demoWidenNarrow() {
        b = (byte)i;   // casting
        s = (short)l;
        i = b;

        // by default, math operation result is at least int type

        b += 3; // this is OK
        b = (byte)(b + 1);

        ch = (char)s;
        ch = (char)b;
        i = ch;
        s = (short)ch;

        ch = 'a' + 1;
        ch = 'd' - 'a';  // needs more study
    }

}