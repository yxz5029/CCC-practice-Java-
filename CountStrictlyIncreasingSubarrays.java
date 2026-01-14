public class CountStrictlyIncreasingSubarrays {
    public static void main0(String[] args){
        int[] nums = {1,2,3,4,5};  // 1,2,3,4,5,6,7, 3:  7+6+5+4+3+2+1=
        int start = 0;
        int total = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] >= nums[i+1]){
                total += (1+i-start+1)*(i-start+1)/2;
                start = i+1;
            }
            else if(i == nums.length - 2){
                total += (1+i+1-start+1)*(i-start+2)/2;
            }
            System.out.println(total);
        }
        System.out.print(total+"no");
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};  // 1,2,3,4,5,6,7, 3:  7+6+5+4+3+2+1=
        int start = 0;
        int total = 0;
        while (start < nums.length) {
            int end = start;
            while (end < nums.length-1 && nums[end] < nums[end+1]) {
                end++;
            }
            long n = end-start+1;
            total+= (n+1)*n/2;
            start = end+1;
        }
        System.out.println(total);
    }
}
