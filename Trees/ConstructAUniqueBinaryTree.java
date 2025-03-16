import java.util.*;

public class ConstructAUniqueBinaryTree {
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
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderIndexMap);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, 
                                            int[] inorder, int inStart, int inEnd,
                                            Map<Integer, Integer> inorderIndexMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = inorderIndexMap.get(rootValue);
        int leftTreeSize = rootIndex - inStart;

        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftTreeSize, inorder, inStart, rootIndex - 1, inorderIndexMap);
        root.right = buildTreeHelper(preorder, preStart + leftTreeSize + 1, preEnd, inorder, rootIndex + 1, inEnd, inorderIndexMap);

        return root;
    }

    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6}; 
        int[] inorder = {4, 2, 5, 1, 6, 3};  

        TreeNode root = buildTree(preorder, inorder);
        System.out.println("Inorder traversal of constructed tree:");
        printInorder(root);
    }
}
