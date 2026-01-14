public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public static void main(String[] agrs){
        int[] r = {8,8,8,1,2,2,3};
        // 0 1 2 1 0 0 0 0 3
        // 0 1 3 4 4 4 4 4 7
        int[] s = s2(r);
        for(int i : s){
            System.out.println(i);
        }

    }
    static int[] solution(int[] nums){
        int[] op = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                op[i] += nums[i] > nums[j]?1:0;
            }
        }
        return op;
    }
    static int[] s2(int[] nums){
        int[] op = new int[nums.length];
        int[] counts = new int[101];
        for(int i = 0; i < nums.length; i++){
            counts[nums[i]] += 1;
        }
        for(int i = 1; i < 101; i++){
            counts[i] += counts[i-1];
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0) {
                op[i] = counts[nums[i] - 1];
            }
        }
        return op;
    }
}
