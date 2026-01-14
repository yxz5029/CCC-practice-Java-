package dynamic.programing;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubstring {
    public static void main(String[] argas){
        int[] nums = {1,3,5,4,7};
        int[] lens = new int[nums.length];
        int[] counts = new int[nums.length];
        Arrays.fill(lens,1);
        Arrays.fill(counts,1);
        // for example,
        // lens[5] = 3: nums[0..5] we found increasing sequence length is 3
        // counts[5] = 2； nums[0..5], we found there are two such sequence
        // nums[6] ?
        // lens[6]?  must check from lens[0] to lens[5]
        // counts[6]?
        int maxLen = 0;
        int answer = 0;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if (lens[i] == lens[j]+1) {
                        counts[i] += counts[j];
                    }
                    else if (lens[i] < lens[j]+1) {
                        lens[i] = lens[j] + 1;
                        counts[i] = counts[j];
                    }
                }
            }
            if (lens[i] == maxLen) {
                answer += counts[i];
            }
            else if (maxLen < lens[i]) {
                maxLen = lens[i];
                answer = counts[i];
            }
        }
        System.out.println(answer);
    }
}
