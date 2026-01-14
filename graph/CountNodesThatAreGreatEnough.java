package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class CountNodesThatAreGreatEnough {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        countGreatEnoughNodes(root, 2);
        System.out.println(num);
    }
    static int num = 0;
    /*

            k=3

                8         k=2
            6       8
           4 5    5   7


    Collection:
    Set:  HashSet, TreeSet(this is sorted)
    List:
    Stack:
    Queue: PriorityQueue


     PriorityQueue<Integer> queue = new PriorityQueue<>(); // remove smallest first:  poll();
                                    new PriorityQueue<>(Collections.reverseOrder());  // poll(): remove largest

     */


    static PriorityQueue<Integer> countGreatEnoughNodes(TreeNode root, int k){
        PriorityQueue<Integer> f = new PriorityQueue<>();
        PriorityQueue<Integer> l = new PriorityQueue();
        PriorityQueue<Integer> r = new PriorityQueue();
        if(root.left == null && root.right == null){
            f.add(root.val);
            return f;
        }
        if(root.left != null){
            l = countGreatEnoughNodes(root.left, k);
        }
        if(root.right != null){
            r = countGreatEnoughNodes(root.right, k);
        }
        PriorityQueue<Integer> total = l;
        l.addAll(r);
        int kcopy = k;
        for(int i : total){
            if(k > 0) {
                if (i < root.val) {
                    k--;
                }
            }else{
                num+=1;
                break;
            }
        }
        total.add(root.val);
        PriorityQueue<Integer> ft = new PriorityQueue<>();
        while(ft.size() < kcopy && !total.isEmpty()){
            ft.add(total.poll());
        }
        return ft;
    }
    static PriorityQueue<Integer> countGreatEnoughNodes2(TreeNode root, int k){
        if(root == null) {
            return new PriorityQueue<>();
        }
        PriorityQueue<Integer> l = countGreatEnoughNodes(root.left, k);
        PriorityQueue<Integer> r = countGreatEnoughNodes(root.right, k);
        l.addAll(r);
        int kcopy = k;
        PriorityQueue<Integer> ft = new PriorityQueue<>();
        for(int i : l){
            if(kcopy > 0){
                ft.add(i);
                kcopy--;
            }
            if(k > 0) {
                if (i < root.val) {
                    k--;
                }
            }else{
                num+=1;
                break;
            }
        }
        ft.add(root.val);
        return ft;
    }
    static PriorityQueue<Integer> countGreatEnoughNodes3(TreeNode root, int k){
        if(root == null) {
            return new PriorityQueue<>();
        }
        PriorityQueue<Integer> l = countGreatEnoughNodes(root.left, k);
        PriorityQueue<Integer> r = countGreatEnoughNodes(root.right, k);
        l.addAll(r);
        PriorityQueue<Integer> ft = new PriorityQueue<>();
        boolean valSmaller = false;
        for(int i : l) {
            if (ft.size() >= k) {
                break;
            }
            valSmaller = i < root.val;
            ft.add(i);
        }
        if (ft.size() == k && valSmaller) {
            num++;
        }
        ft.add(root.val);
        return ft;
    }
    static PriorityQueue<Integer> countGreatEnoughNodes4(TreeNode root, int k){
        if(root == null) {
            return new PriorityQueue<>(Collections.reverseOrder());
        }
        PriorityQueue<Integer> l = countGreatEnoughNodes(root.left, k);
        PriorityQueue<Integer> r = countGreatEnoughNodes(root.right, k);
        l.addAll(r);

        while (l.size() > k) {
            l.poll();
        }
        if (l.size() == k && root.val > l.peek()) {
            num++;
        }

        l.add(root.val);
        return l;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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