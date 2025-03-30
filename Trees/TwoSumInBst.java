import java.util.Stack;

public class TwoSumInBst {
    public class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public Stack<Node> st = new Stack<>();
    boolean reverse = true;

    public TwoSumInBst(Node root, boolean reverse) {
        this.reverse = reverse;
        pushAll(root);
    }

    public int next() {
        Node temp = st.pop();
        if (reverse) pushAll(temp.right);
        else pushAll(temp.left);
        return temp.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void pushAll(Node node) {
        if (reverse) {
            for (; node != null; node = node.right) {
                st.push(node);
            }
        } else {
            for (; node != null; node = node.left) {
                st.push(node);
            }
        }
    }

    public boolean findTarget(Node root, int k) {
        if (root == null) return false;
        TwoSumInBst left = new TwoSumInBst(root, false);
        TwoSumInBst right = new TwoSumInBst(root, true);

        int l = left.next();
        int r = right.next();

        while (l < r) {
            if (l + r == k) return true;
            else if (l + r < k) l = left.next();
            else r = right.next();
        }
        return false;
    }

    public static void main(String[] args) {
        // Example usage of the TwoSumInBst class
        TwoSumInBst bst = new TwoSumInBst(null, true); // Placeholder for initialization
        TwoSumInBst.Node root = bst.new Node(10);
        root.left = bst.new Node(5);
        root.right = bst.new Node(15);
        root.left.left = bst.new Node(3);
        root.left.right = bst.new Node(7);
        root.right.left = bst.new Node(12);
        root.right.right = bst.new Node(18);

        System.out.println(bst.findTarget(root, 22)); // Example target
    }
}