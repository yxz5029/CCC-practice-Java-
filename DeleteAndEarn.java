import java.util.ArrayList;
import java.util.Collection;

public class DeleteAndEarn {
    public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(2);
        nums.add(3);
        nums.add(3);
        nums.add(3);
        nums.add(4);
        //Integer[] dp = new Integer[nums.size()];
        int point = 0;
        if(nums.size() == 2){
            System.out.println(Math.max(nums.get(0),nums.get(1)));
            return;
        }
        for(int i = 0 ; i < nums.size(); i++){
            point = Math.max(findMinPoint(nums,i),point);
            p = 0;
        }
        System.out.println(point);
    }
    //static ArrayList<Integer> nums;
    static int p = 0;
    static Integer findMinPoint(ArrayList<Integer> nums, int i){
        if(nums.size() == 3){
            return p+Math.max(Math.max(nums.get(0),nums.get(1)),nums.get(2));
        }
        if(nums.size() == 2){
            return p+Math.max(nums.get(0),nums.get(1));
        }
        if(nums.size() == 1){
            return p+nums.get(0);
        }
        p += nums.get(i);
        nums.remove(i);
        if(i-1>=0){
            nums.remove(i-1);
        }if(i + 1 <= nums.size()){
            nums.remove(i+1);
        }
        for(int j = 0; j < nums.size(); j++){
            p = Math.max(findMinPoint(nums,j),p);
        }
        return i;

    }

}
