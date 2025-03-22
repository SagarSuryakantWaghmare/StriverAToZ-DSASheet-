import java.util.HashMap;
import java.util.Map;

public class BtFromPreorderAndInorder {
    public static class TreeNode { 
        int data;
        TreeNode left, right;

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
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(pre[preStart]);
        int inRoot = mp.get(root.data);
        int numsLeft = inRoot - inStart; 

        root.left = buildTree(pre, preStart + 1, preStart + numsLeft, in, inStart, inRoot - 1, mp);
        root.right = buildTree(pre, preStart + numsLeft + 1, preEnd, in, inRoot + 1, inEnd, mp);

        return root;
    }

    public static void printInorder(TreeNode root) { 
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int pre[] = {1, 2, 4, 5, 3, 6, 7};
        int in[] = {4, 2, 5, 1, 6, 3, 7};
        TreeNode newRoot = buildTree(pre, in);
        System.out.println("Inorder traversal of constructed tree:");
        printInorder(newRoot);
    }
}
