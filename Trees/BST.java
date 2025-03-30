import java.util.Stack;

public class BST {
    // BST Iteration
    // next, hasnext
    public class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    // Iterator for BST
    public class BstIterator {
        Stack<Node> st = new Stack<>();

        public BstIterator(Node root) {
            pushAll(root);
        }

        public boolean hasNext() {
            return !st.isEmpty();
        }

        public Node next() {
            Node temp = st.pop();
            pushAll(temp.right);
            return temp;
        }

        private void pushAll(Node node) {
            for (; node != null; node = node.left) {
                st.push(node);
            }
        }
    }

    public static void main(String[] args) {
        // Main body of the program
        BST bst = new BST();
        Node root = bst.new Node(10);
        root.left = bst.new Node(5);
        root.right = bst.new Node(15);
        root.left.left = bst.new Node(3);
        root.left.right = bst.new Node(7);
        root.right.left = bst.new Node(12);
        root.right.right = bst.new Node(18);

        // Using the BstIterator
        BstIterator iterator = bst.new BstIterator(root);
        while (iterator.hasNext()) {
            System.out.print(iterator.next().val + " ");
        }
    }
}