import java.util.*;
public class LowestCommonAncestor {
                public static class TreeNode {
                    int data;
                    TreeNode left;
                    TreeNode right;
                    TreeNode(int data){
                        this.data=data;
                    }
                }
                // Lowest Common Ancestor(Binary Tree);
                public static TreeNode lowestCommonAncestor(TreeNode root,TreeNode a,TreeNode b){
                if(root==null||root==a||root==b){
                    return root;
                }
                TreeNode left=lowestCommonAncestor(root.left, a, b);
                TreeNode right=lowestCommonAncestor(root.right, a, b);
                if(left==null){
                    return right;
                }
                else if(right==null){
                    return left;
                }
                else{
                    return root;
                }
                }
                public static void main(String[] args) {
                    TreeNode root = new TreeNode(1);
                    root.left = new TreeNode(2);
                    root.right = new TreeNode(3);
                    root.left.left = new TreeNode(4);
                    root.left.right = new TreeNode(5);
                    root.left.right.left = new TreeNode(6);
                    root.left.right.right = new TreeNode(7);
                    root.right.left = new TreeNode(8);
                    root.right.right = new TreeNode(9);
                    TreeNode ans=lowestCommonAncestor(root,root.left.left,root.left.right.left);
                    System.out.println(ans.data);
                }
            }
            
        
    