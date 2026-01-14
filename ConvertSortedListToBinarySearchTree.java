public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] agrs){
        ListNode head = new ListNode(-10);
        ListNode l = head;
        l.next = new ListNode(-3); l = l.next;
        l.next = new ListNode(0); l = l.next;
        l.next = new ListNode(5); l = l.next;
        l.next = new ListNode(9);
        TreeNode root = sortedListToBST(head);
    }

    private static TreeNode sortedListToBST(ListNode head) {

        ListNode mid = head;
        ListNode fast = head;
        ListNode tail = head;
        while(fast != null && fast.next != null){
            tail = mid;
            mid = mid.next;
            fast = fast.next.next;
        }
        TreeNode result = new TreeNode();
        result.val = mid.val;
        result.right = sortedListToBST(mid.next);
        tail.next = null;
        result.left = sortedListToBST(head);

        return result;
    }

}

class TreeNode1 {
    int val;
    TreeNode1 left, right;
    TreeNode1() {}
    TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}