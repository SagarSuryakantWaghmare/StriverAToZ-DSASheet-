import java.util.*;

public class CheckForBalancedBinaryTree {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // Condition:Balance Binary Tree
    // For every node, height(left)-height(right)<=1
    // Brute force approach
    public static boolean isBalanced(TreeNode node){
        if(node==null) return true;
        int lh=findH(node.left);
        int rh=findH(node.right);
        if(Math.abs(rh-lh)>1) return false;
        boolean left=isBalanced(node.left);
        boolean right=isBalanced(node.right);
        if(!left||!right) return false;
        return true;

    }
    public static int findH(TreeNode root){
        if(root==null) return 0;
        int lRoot=findH(root.left);
        int rRoot=findH(root.right);
        return Math.max(lRoot, rRoot)+1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println("Is the Binary Tree Balanced: " + isBalanced(root));
    }
}
