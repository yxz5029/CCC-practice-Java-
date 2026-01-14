public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args){
        int[] nums = {-10,-3,0,5,9};
        TreeNode t = sortedArrayToBST(nums,0,nums.length-1);
        System.out.println(t);
    }
    static TreeNode sortedArrayToBST(int[] nums,int begin, int end){
        if(begin > end){
            return null;
        }
        TreeNode t = new TreeNode();
        int mid = (end+begin)/2;
        t.val = nums[mid];  // begin + (end-begin)/2 = (2begin/2) + (end-begin)/2
        t.left = sortedArrayToBST(nums,begin,mid-1);
        t.right = sortedArrayToBST(nums,mid+1,end);
        return t;
    }
}
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}