import java.util.*;

public class ConstructBTFromInorderAndPreorder {
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

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mp.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, mp);
    }

    public static TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, Map<Integer, Integer> mp) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        int inRoot = mp.get(root.data); 
        int numsLeft = inRoot - inStart;

        root.left = buildTree(pre, preStart + 1, preStart + numsLeft, in, inStart, inRoot - 1, mp);
        root.right = buildTree(pre, preStart + numsLeft + 1, preEnd, in, inRoot + 1, inEnd, mp);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root.data);
    }
}
