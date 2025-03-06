public class DiameterOfABT {
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
    // o(n*n)
    // public static int diameterOfBinaryTree(TreeNode root){
    //     // we have to find each node diameter
    //     // After from that we get the max Diameter
    //     int max=0;
    //     if(root==null) return 0;
    //     int lh=findH(root.left);
    //     int rh=findH(root.right);
    //     max=Math.max(max, lh+rh);
    //     diameterOfBinaryTree(root.left);
    //     diameterOfBinaryTree(root.right);
    //     return max;
    // }
        public static int diameterOfBinaryTree(TreeNode root) {
            int[] maxi = new int[]{0}; 
            findMax(root, maxi);
            return maxi[0];
        }
        public static int findMax(TreeNode root, int[] maxi) {
            if (root == null) {
                return 0;
            }
            int lh = findMax(root.left, maxi);
            int rh = findMax(root.right, maxi);
            maxi[0] = Math.max(maxi[0], lh + rh);
            return 1 + Math.max(lh, rh);
        }
   
    
    
    public static int findH(TreeNode root){
        if(root==null) return 0;
        int lh=findH(root.left);
        int rh=findH(root.right);
        return lh+rh+1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println("Diameter of the Binary Tree: " + diameterOfBinaryTree(root));
    }
}
