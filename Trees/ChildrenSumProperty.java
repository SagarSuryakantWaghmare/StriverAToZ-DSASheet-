import java.util.*;
public class ChildrenSumProperty {
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
    
        public static class Pair {
            TreeNode hd;
            int val;
    
            Pair(TreeNode hd, int val) {
                this.hd = hd;
                this.val = val;
            }
        }
    
        public static void childrenSum(TreeNode root){
            if(root==null){
                return;
            }
            int child=0;
            if(root.left!=null){
                child+=root.left.data;
            }
            if(root.right!=null){
                child+=root.right.data;
            }
            if(child>=root.data){
                root.data=child;
            }
            else{
                if(root.left!=null) root.left.data=root.data;
                else if(root.right!=null) root.right.data=root.data;
            }
            childrenSum(root.left);
            childrenSum(root.right);
            int tot=0;
            if(root.left!=null) tot+=root.left.data;
            if(root.right!=null) tot+=root.right.data;
            if(root.left!=null||root.right!=null) root.data=tot;

        }
        public static void inorder(TreeNode root){
            if(root==null) {
                return ;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    
        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            childrenSum(root);
            inorder(root);

    
        }
    }
    
