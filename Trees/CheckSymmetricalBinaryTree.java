import java.util.*;
public class CheckSymmetricalBinaryTree {
            public static class ListNode {
                int data;
                ListNode left;
                ListNode right;
                ListNode(int data){
                    this.data=data;
                }
            }
            public static boolean isSymmetric(TreeNode root){
                return root==null||helper(root.left,root.right);

            }
            public static boolean helper(TreeNode left,TreeNode right){
                if(left==null||right==null) return left==right;
                if(left.data!=right.data) return false;
                return helper(left.left, right.right)&&helper(left.right, right.left);
            }

            public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(2);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(5);
                root.right.left = new TreeNode(5);
                root.right.right = new TreeNode(4);
        
                System.out.println("Is Symmetric Binary Tree:"+isSymmetric(root));
            }
        }
        
    
