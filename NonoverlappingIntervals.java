import java.util.Arrays;

public class NonoverlappingIntervals {
    public static void main(String[] args){
        //int[][] intervals = {{1,2},{1,3},{2,3},{3,4}};
        //int[][] intervals = {{1,2},{2,3}};
        int[][] intervals = {{1,2},{0,4},{2,3},{3,4}};

        Arrays.sort(intervals, (a, b) -> a[1]-b[1]);
        int end = intervals[0][1];
        int total = 0;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < end){
                total++;
            }
            else{
                end = intervals[i][1];
            }
        }
        System.out.println(total);
    }
    public static void mainXX(String[] args){ //can't use start to sort array
        //int[][] intervals = {{1,2},{1,3},{2,3},{3,4}};
        //int[][] intervals = {{1,2},{2,3}};
        int[][] intervals = {{1,2},{0,4},{2,3},{3,4}};

        Arrays.sort(intervals, (a, b)->{
            int start = a[0]-b[0];
            if(start == 0) {
                return a[1] - b[1];
            }
            return start;
            // {1, 4} and {2, 3} are equal
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        int total = 0;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= start){
                total++;
            }
            else if(intervals[i][0] < end){
                total++;
            }
            else{
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        System.out.println(total);
    }
}
