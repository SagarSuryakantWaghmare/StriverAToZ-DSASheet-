import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class iterativePostOrderUsingSingleStack {

    public static class ListNode {
        int data;
        ListNode left;
        ListNode right;

        ListNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> postOrder(ListNode root) {
        Stack<ListNode> st = new Stack<>();
        List<Integer> ls = new ArrayList<>();
        ListNode curr = root;
        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                ListNode temp = st.peek().right;
                if (temp == null) {
                    temp = st.pop();
                    ls.add(temp.data);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        ls.add(temp.data);
                    }
                } else {
                    curr = temp;
                }
            }
        }
        return ls;

    }

    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        root.left = new ListNode(2);
        root.right = new ListNode(3);
        root.left.left = new ListNode(4);
        root.left.right = new ListNode(5);
        root.right.left = new ListNode(6);
        root.right.right = new ListNode(7);
        // we are doing the iterative preOrder Traversal
        System.out.println("Postorder Traversal");
        List<Integer> res = postOrder(root);
        System.out.println(res);

    }
}
