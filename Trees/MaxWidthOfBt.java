import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBt {
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

    public static int maxWidth(TreeNode root) {
        if (root == null) return 0;

        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().hd;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair currentPair = q.poll(); 
                int currmin = currentPair.hd;
                TreeNode node = currentPair.node;

                if (i == 0) first = currmin;
                if (i == size - 1) last = currmin;

                if (node.left != null) {
                    q.offer(new Pair(node.left, currmin * 2 + 1));
                }
                if (node.right != null) {
                    q.offer(new Pair(node.right, currmin * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Maximum Width of the binary Tree: " + maxWidth(root));
    }
}
