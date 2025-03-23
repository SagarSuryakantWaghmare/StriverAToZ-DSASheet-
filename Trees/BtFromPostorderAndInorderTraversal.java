import java.util.HashMap;
import java.util.Map;

public class BtFromPostorderAndInorderTraversal {

    public static class TreeNode { 
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode buildTree(int[] postorder, int[] inorder) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) { 
            mp.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, mp);
    }

    public static TreeNode buildTree(int[] post, int postStart, int postEnd, int[] in, int inStart, int inEnd, Map<Integer, Integer> mp) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(post[postEnd]);
        int inRoot = mp.get(post[postEnd]);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(post, postStart, postStart + numsLeft - 1, in, inStart, inRoot - 1, mp);
        root.right = buildTree(post, postStart + numsLeft, postEnd - 1, in, inRoot + 1, inEnd, mp);

        return root;
    }

    public static void printInorder(TreeNode root) { 
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int post[] = {40, 50, 20, 60, 30, 10};
        int in[] = {40, 20, 50, 10, 60, 30};
        TreeNode newRoot = buildTree(post, in);
        System.out.println("Inorder traversal of constructed tree:");
        printInorder(newRoot);
    }
}
