import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumTimeTakenToBurnTheBT {
    public static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int val) {
            this.data = val;
            left = right = null;
        }
    }

    public static int timeToBurnTree(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode target = bfsToMapParents(root, parentMap, start);
        return findMaxDistance(parentMap, target);
    }

    public static TreeNode bfsToMapParents(TreeNode root, HashMap<TreeNode, TreeNode> parentMap, int start) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        parentMap.put(root, null);
        TreeNode target = null;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.data == start) {
                target = node;
            }
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }
        return target;
    }

    public static int findMaxDistance(HashMap<TreeNode, TreeNode> parentMap, TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null && !visited.contains(node.left)) {
                    queue.offer(node.left);
                    visited.add(node.left);
                    burned = true;
                }
                if (node.right != null && !visited.contains(node.right)) {
                    queue.offer(node.right);
                    visited.add(node.right);
                    burned = true;
                }
                if (parentMap.get(node) != null && !visited.contains(parentMap.get(node))) {
                    queue.offer(parentMap.get(node));
                    visited.add(parentMap.get(node));
                    burned = true;
                }
            }
            if (burned) time++;
        }
        return time;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.left.left.left.left = new TreeNode(9);
        root.left.left.left.left.left = new TreeNode(10);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(3);

        int startNode = 4; // The node value where fire starts
        System.out.println("Minimum time to burn the tree: " + timeToBurnTree(root, startNode));
    }
}
