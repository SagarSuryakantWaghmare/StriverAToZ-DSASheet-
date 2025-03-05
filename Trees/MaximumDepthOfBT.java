import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBT {
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.data = val;
            left = right = null;
        }
    }
    // public static int maxDepth(TreeNode root){
    //     if(root==null) return 0;
    //     int left=maxDepth(root.left);
    //     int right=maxDepth(root.right);
    //     return Math.max(left,right)+1;
    // }
    
    // Using level order Traversal
    public static int maxDepth(TreeNode root){
        if(root==null) return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int Depth=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            Depth++;
        }
        return Depth;
    }
    public static void main(String[]args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println("Maximum Depth of Binary Tree: "+maxDepth(root));
    }
}
