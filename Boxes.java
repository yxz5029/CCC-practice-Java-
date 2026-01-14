import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Map;

class Boxes0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int[][] box = new int[b][3];
        for (int i = 0; i < b; i++) {
            box[i][0] = sc.nextInt();
            box[i][1] = sc.nextInt();
            box[i][2] = sc.nextInt();
        }
        int it = sc.nextInt();
        String output[] = new String[it];
        for (int i = 0; i < it; i++) {
            output[i] = calculate(box, sc.nextInt(), sc.nextInt(), sc.nextInt(), it, b);
        }
        sc.close();
        for (String i : output) {
            System.out.println(i== null ? "Item does not fit.": i);
        }
    }

    static String calculate(int[][] box, int l, int w, int h, int it, int b) {
        Integer r = null;
        w1: for (int i = 0; i < b; i++) {
            List<Integer> bl = new ArrayList<>();
            List<Integer> gl = new ArrayList<>();
            bl.add(box[i][0]);
            bl.add(box[i][1]);
            bl.add(box[i][2]);
            gl.add(l);
            gl.add(w);
            gl.add(h);
            Collections.sort(bl);
            Collections.sort(gl);
            for (int j = 0; j < 3; j++) {
                if (bl.get(j) < gl.get(j)) {
                    continue w1;
                }
            }
            if (r == null || r > (box[i][0] * box[i][1] * box[i][2])) {
                r = box[i][0] * box[i][1] * box[i][2];
            }
        }
        return r + "";
    }

}

public class Boxes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();

        TreeMap<Long, int[]> boxes = new TreeMap<>();
        for (int i = 0; i < b; i++) {
            int[] box = new int[3];
            box[0] = sc.nextInt();
            box[1] = sc.nextInt();
            box[2] = sc.nextInt();
            Arrays.sort(box);
            boxes.put(((long)box[0])*box[1]*box[2], box);
        }

        int it = sc.nextInt();
        String output[] = new String[it];
        for (int i = 0; i < it; i++) {
            int[] item = new int[3];
            item[0] = sc.nextInt();
            item[1] = sc.nextInt();
            item[2] = sc.nextInt();
            Arrays.sort(item);
            long vol = ((long)item[0])*item[1]*item[2];

            String result = null;
            nextBox:for (Map.Entry<Long, int[]> e : boxes.entrySet()) {
                if (vol > e.getKey()) {
                    continue;
                }
                int[] box = e.getValue();
                for (int j=0; j<box.length; j++) {
                    if (item[j] > box[j]) {
                        continue nextBox;
                    }
                }
                result = e.getKey()+"";
                break;
            }
            output[i] = result;
        }

        sc.close();
        for (String i : output) {
            System.out.println(i== null ? "Item does not fit.": i);
        }
    }
}
