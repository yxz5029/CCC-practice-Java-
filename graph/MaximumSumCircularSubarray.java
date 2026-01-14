package graph;

import java.util.*;
import java.util.stream.Collectors;

public class MaximumSumCircularSubarray {
    public static void main(String[] args){
        int[] nums = {-1,-2,-3,-2};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int currmax = 0;
        int currmin = 0;
        int total = 0;
        boolean positive = false;
        int negmax = Integer.MIN_VALUE;
        for (int v : nums) {
            if(v > 0){
                positive = true;
            }
            negmax = Math.max(negmax,v);
            currmax = Math.max(currmax+v, v);
            max = Math.max(max, currmax);
            currmin = Math.min(currmin+v, v);
            min = Math.min(currmin, min);
            total += v;
        }
        System.out.println(positive?Math.max(total-min, max):negmax);
    }


    static void streamAPI() {

        // given list of numbers, how to get rid of odd number?
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(3);

        List<String> evens =
                nums.stream()
                        .filter( n -> n%2 == 0 )
                        .map( n -> n+"" )
                        .collect(Collectors.toList());


    }


}
