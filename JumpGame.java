public class JumpGame {
    public static void main(String[] args){
        int[] nums = {2,3,1,1,4};
        jump2(nums);
        System.out.print(jump(nums,0));
    }
    public static boolean jump(int[] nums, int i){
        if(i == nums.length-1){
            return true;
        }
        boolean result = false;
        for(int j = 1; j <= nums[i]; i++) {
            result = jump(nums, i + j);
            if(result){
                return true;
            }
        }
        return false;
    }
    public static boolean jump2(int[] nums){
        int limit = 0;
        int i = 0;
        for( ; i < nums.length && i <= limit; i++){
            limit = Math.max(limit, i+nums[i]);
        }
        return i == nums.length;
    }
}
