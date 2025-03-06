import java.util.*;
public class BoundaryTraversal {
    
        public static class TreeNode {
            int data;
            TreeNode left, right;
            TreeNode(int data) {
                this.data = data;
                this.left = null;
                this.right = null;
            }
        }

        // Leaf node
        public static boolean isLeaf(TreeNode root){
            return root!=null&&root.left==null&&root.right==null;
        }
        public static void leftBoundary(TreeNode root,List<Integer> ans){
            TreeNode curr=root.left;
            while (curr!=null) {
                if(isLeaf(curr)==false) ans.add(curr.data);
                if(curr.left!=null) curr=curr.left;
                else curr=curr.right;
            }
        }
        public static void rightBoundary(TreeNode root,List<Integer> ans){
          TreeNode curr=root.right;
          ArrayList<Integer> ls=new ArrayList<>();
          while (curr!=null) {
            if(isLeaf(curr)==false)ls.add(curr.data);
            if(curr.right!=null) curr=curr.right;
            else curr=curr.left;
          }
          for (int i = ls.size()-1; i >=0; i--) {
            ans.add(ls.get(i));
          }
        }
        public static void leafTraversal(TreeNode root,List<Integer> ans){
            if(isLeaf(root)){
                ans.add(root.data);
                return;
            }
            if(root.left!=null) leafTraversal(root.left, ans);
            if(root.right!=null) leafTraversal(root.right, ans);
        }
       public static List<Integer> boundaryTraversal(TreeNode root){
        // left boundary excluding the leaf
        // Leaf nodes
        // right boundary in the reverse
        List<Integer> ans=new ArrayList<>();
        if(isLeaf(root)==false) ans.add(root.data);
        if(root==null) return ans;
        leftBoundary(root,ans);
        leafTraversal(root,ans);
        rightBoundary(root,ans);
        return ans;

       }
        
        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
    
            List<Integer> ls=boundaryTraversal(root);
            System.out.println(ls);
        }
    }
    
