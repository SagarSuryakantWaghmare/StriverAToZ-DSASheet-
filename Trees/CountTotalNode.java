import java.util.*;
public class CountTotalNode {
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
            TreeNode node;
            int hd;
    
            Pair(TreeNode node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        // So we calculate the nodes by the traversal inorder we get time complexity:O(n)
        public static int countNodes(TreeNode root){
        // Complete tree:O log n
        // no of nodes=2^3-1;
        if(root==null) return 0;
        int left=getHeightLeft(root);
        int right=getHEightRight(root);
        if(left==right) return((2<<(left))-1);
        else return countNodes(root.left)+countNodes(root.right)+1;
        }
        public static int getHeightLeft(TreeNode root){
            int count=0;
            while (root.left!=null) {
                count++;
                root=root.left;
            }
            return count;
        }
        public static int getHEightRight(TreeNode root){
            int count=0;
            while (root.right!=null) {
                count++;
                root=root.right;
            }
            return count;
        }
    
        
        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
    
            System.out.println("Count total nodes of the binary Tree: " + countNodes(root));
        }
    }
    
