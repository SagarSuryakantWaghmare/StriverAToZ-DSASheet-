public class FlattenABTtoLL {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        TreeNode(int data) {
            this.data = data;
        }
    }

    public static TreeNode flatten(TreeNode root) {
        if (root == null) return null;

        // Flatten the left and right subtrees
        TreeNode leftTail = flatten(root.left);
        TreeNode rightTail = flatten(root.right);

        // If there is a left subtree, attach it to the right of the current node
        if (root.left != null) {
            TreeNode tempRight = root.right;
            root.right = root.left;
            root.left = null;

            // Connect the tail of the left subtree to the original right subtree
            TreeNode current = root.right;
            while (current.right != null) {
                current = current.right;
            }
            current.right = tempRight;
        }

        // Return the tail of the flattened tree
        if (rightTail != null) return rightTail;
        if (leftTail != null) return leftTail;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        flatten(root);

        // Print the flattened tree
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
    }
}
