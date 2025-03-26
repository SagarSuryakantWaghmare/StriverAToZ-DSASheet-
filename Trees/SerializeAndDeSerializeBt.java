import java.util.*;

public class SerializeAndDeSerializeBt {
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

    public static String serialize(TreeNode root) {
        if (root == null) return "null";
        return root.data + "," + serialize(root.left) + "," + serialize(root.right);
    }
    public static TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    private static TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serializedTree = serialize(root);
        System.out.println("Serialized Tree: " + serializedTree);

        TreeNode deserializedTree = deserialize(serializedTree);
        System.out.println("Deserialization completed.");
    }
}
