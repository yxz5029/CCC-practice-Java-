package graph;

public class SplitArraywithEqualSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 1, 2, 1};
        boolean result = solution(nums);
        System.out.println(result);
    }

    public static boolean solution(int[] nums) {
        int[] sum = new int[nums.length + 1];
        boolean result = false;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }
        for (int i = 1; i < nums.length - 5; i++) {
            int currsum = sum[i];
            for (int j = i + 2; j < nums.length - 3; j++) {
                if (sum[j] - sum[i + 1] == currsum) {
                    //System.out.println(sum[j]+"-"+sum[i+1]+"="+(sum[j]-sum[i+1])+" "+currsum);
                    for (int m = j + 2; m < nums.length - 1; m++) {
                        //System.out.println(sum[m]+"-"+sum[j+1]+"="+(sum[m]-sum[j+1])+" "+currsum);
                        if (sum[m] - sum[j + 1] == currsum) {
                            //System.out.println(sum[n]+"-"+sum[m+1]+"="+(sum[n]-sum[m+1])+" "+currsum);
                            if (sum[nums.length] - sum[m + 1] == currsum) {
                                return true;
                            }
                            //else{System.out.println(3);}
                        }
                    }
                    //else{System.out.println(2);}
                }
            }
            //else{System.out.println(1);}
        }
        return false;
    }

    public static boolean solution2(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i-1];
        }

        for (int j=3; j < nums.length - 3; j++) {
            for (int i = 1; i < j-1; i++) {
                if (sum[i-1] == sum[j-1] - sum[i]) {
                    for (int k = j + 2; k < nums.length - 1; k++) {
                        //System.out.println(sum[m]+"-"+sum[j+1]+"="+(sum[m]-sum[j+1])+" "+currsum);
                        if (sum[i-1] == sum[k-1] - sum[j]) {
                            //System.out.println(sum[n]+"-"+sum[m+1]+"="+(sum[n]-sum[m+1])+" "+currsum);
                            if (sum[nums.length-1] - sum[k] == sum[i-1]) {
                                return true;
                            }
                            //else{System.out.println(3);}
                        }
                    }
                    //else{System.out.println(2);}
                }
            }
            //else{System.out.println(1);}
        }
        return false;
    }
}
