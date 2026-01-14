import java.util.*;

public class Golf {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int dt = sc.nextInt();
        int clubn = sc.nextInt();
        int[] clubs = new int[clubn];
        for(int i = 0; i < clubn; i++){
            clubs[i] = sc.nextInt();
        }
        // strokes[12]=1 means 1 strokes to reach distance 12 meters
        // strokes[27]=2 means 2 strokes to reach distance 27 meters
        // strokes[42]=3 means 3 strokes to reach distance 42 meters
        int[] strokes = new int[dt+1];
        Arrays.fill(strokes, Integer.MAX_VALUE);
        strokes[0] = 0;
        for(int d = 0; d < strokes.length; d++){
            if (strokes[d] == Integer.MAX_VALUE) {
                continue;
            }
            for(int i = 0; i < clubn; i++) {
                int newDistance = d+clubs[i];  // from d
                if (newDistance <= dt && strokes[d]+1 < strokes[newDistance]) {
                    strokes[newDistance] = strokes[d]+1;
                }
            }
        }
        sc.close();
        System.out.println(strokes[dt] != Integer.MAX_VALUE ? "Roberta wins in "+ strokes[dt] +"strokes.": "Roberta acknowledges defeat.");
    }
}
