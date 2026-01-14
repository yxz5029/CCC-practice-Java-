import java.util.*;

public class FloorPlan {
    static int fln;
    static int r;
    static int c;
    static char[][] room;



    public static void main(String[] args){
        Scanner sc = new Scanner(FloorPlan.class.getResourceAsStream("ef.txt"));
        fln = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();
        room = new char[r][c];
        for(int j = 0; j < r; j++){
            String in = sc.nextLine();
            for(int i = 0; i < c; i++){
                room[j][i] = in.charAt(i);
            }
        }

        List<Integer> sizes = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(room[i][j]=='.') {
                    sizes.add(getRoomSize(i, j));
                }
            }
        }

        // sorting
        Collections.sort(sizes, Collections.reverseOrder());

        int total = 0;
        for(int sz : sizes) {
            if (fln >= sz) {
                total++;
                fln -= sz;
            }
            else break;
        }



        sc.close();
    }

    /*
     *              ..  ..
     *          ..... ....
     *              ...
     */

    static class Spot {
        int r, c;

        Spot() {
            // empty body
        }

        Spot(int i, int c) {
            r = i;
            this.c = c;
        }
    }



    static int getRoomSize(int row, int col) {
        LinkedList<Spot> queue = new LinkedList<>();
        queue.add(new Spot(row, col));
        int total = 0;
        while (!queue.isEmpty()) {
            Spot curr = queue.removeFirst();
            if (room[curr.r][curr.c] != '.') {
                continue;
            }
            total++;
            room[curr.r][curr.c] = 'X';
            if (curr.r > 0 && room[curr.r-1][curr.c] == '.') {
                //spots.add(new Spot(curr.r-1, curr.c));
                Spot sp = new Spot();
                sp.r = curr.r-1;
                sp.c = curr.c;
                queue.add(sp);
            }
            if (curr.r < r-1 && room[curr.r+1][curr.c] == '.') {
                queue.add(new Spot(curr.r+1, curr.c));
            }
            if (curr.c > 0 && room[curr.r][curr.c-1] == '.') {
                queue.add(new Spot(curr.r, curr.c-1));
            }
            if (curr.c < c-1 && room[curr.r][curr.c+1] == '.') {
                queue.add(new Spot(curr.r, curr.c+1));
            }

        }
        return total;


    }

}