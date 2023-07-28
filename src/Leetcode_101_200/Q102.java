package Leetcode_101_200;

import java.util.*;

public class Q102 {
    public static void main(String[] args) {

    }
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
    public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            Queue<TreeNode> queue = new ArrayDeque<>();
            if (root != null){
                queue.add(root);
            }
            while (!queue.isEmpty()){
                int n = queue.size();
                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null){
                        queue.offer(node.left);
                    }
                    if (node.right != null){
                        queue.offer(node.right);
                    }
                }
                result.add(level);
            }
            return result;

    }

}
