package homework;

public class SplitBST {
    public static void main(String[] args){

    }
    static TreeNode[] splitBST(TreeNode root, int target){
        if(root == null){
            TreeNode[] result = new TreeNode[2];
            return result;
        }
        if(root.val <= target) {
            TreeNode[] result = splitBST(root.right, target);
            root.right = result[0];
            result[0] = root;
            return result;
        }else{
            TreeNode[] result = splitBST(root.left, target);
            root.left = result[1];
            result[1] = root;
            return result;
        }
    }
}
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
