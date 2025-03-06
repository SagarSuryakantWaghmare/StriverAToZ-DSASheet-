public class MaximumPathSum {
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static int maxPath(TreeNode root,int maxValue[]){
        if(root==null) return 0;
        int lSum=Math.max(0, maxPath(root.left, maxValue));
        int rSum=Math.max(0, maxPath(root.right, maxValue));
        maxValue[0]=Math.max(maxValue[0], lSum+rSum+root.data);
        return root.data+Math.max(lSum, rSum);
    }
    public static int maxPath(TreeNode root){
        int maxValue[]=new int[1];
        maxValue[0]=Integer.MIN_VALUE;
        maxPath(root,maxValue);
        return maxValue[0];
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println("Maximum Path Sum of the Binary Tree: " + maxPath(root));
    }
}
