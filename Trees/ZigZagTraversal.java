import java.util.*;

public class ZigZagTraversal {
    public static class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static List<List<Integer>> zigzag(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if (root == null) return ls;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            Integer[] res = new Integer[size];

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int index = leftToRight ? i : size - i - 1;
                res[index] = node.data;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            leftToRight = !leftToRight;
            ls.add(Arrays.asList(res));
        }
        return ls;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> ls = zigzag(root);
        System.out.println(ls);
    }
}
