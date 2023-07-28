package dp;


import java.util.HashMap;
import java.util.Map;

public class Q337 {

    Map<TreeNode,Integer> f = new HashMap<TreeNode,Integer>();
    Map<TreeNode,Integer> g = new HashMap<TreeNode,Integer>();

    public static class TreeNode {
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

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root,0),g.getOrDefault(root,0));
    }

    public void dfs(TreeNode node){
        if (node == null){
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node,node.val + g.getOrDefault(node.left,0)+g.getOrDefault(node.right,0));
        g.put(node,Math.max(f.getOrDefault(node.left,0),g.getOrDefault(node.left,0))+
                Math.max(f.getOrDefault(node.right,0),g.getOrDefault(node.right,0)));


    }

    public static void main(String[] args) {
        TreeNode treeNode_1 = new TreeNode(3,
                new TreeNode(4,new TreeNode(1),new TreeNode(3)),
                new TreeNode(5,null,new TreeNode(1)));


    }

}
