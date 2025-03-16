import java.util.*;

public class PrintAllTheNodesAtDistanceOfKinBT {
    public static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int val) {
            this.data = val;
            left = right = null;
        }
    }
    public static void printNodesAtDistanceK(TreeNode root, TreeNode target, int k) {
        if (root == null || target == null || k < 0) return;
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParents(root, parentMap);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);

        int level = 0;
        while (!queue.isEmpty()) {
            if (level == k) break;
            int size = queue.size();
            level++;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Add children
                if (current.left != null && !visited.contains(current.left)) {
                    queue.offer(current.left);
                    visited.add(current.left);
                }
                if (current.right != null && !visited.contains(current.right)) {
                    queue.offer(current.right);
                    visited.add(current.right);
                }

                // Add parent node
                if (parentMap.containsKey(current) && !visited.contains(parentMap.get(current))) {
                    queue.offer(parentMap.get(current));
                    visited.add(parentMap.get(current));
                }
            }
        }

        // Print all nodes at distance k
        while (!queue.isEmpty()) {
            System.out.print(queue.poll().data + " ");
        }
    }

    // Function to store parent pointers in a map
    private static void markParents(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode target = root.left; // Target node (2)
        int k = 2; // Distance

        System.out.print("Nodes at distance " + k + " from node " + target.data + ": ");
        printNodesAtDistanceK(root, target, k);
    }
}
