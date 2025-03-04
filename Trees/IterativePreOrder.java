import java.util.List;
import java.util.Stack;

public class IterativePreOrder {
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
    public static void iterativePreOrder(ListNode root){
    Stack<ListNode> st=new Stack<>();
    if(root==null) return;
    st.push(root);
    while (!st.isEmpty()) {
        ListNode curr=st.pop();
        System.out.print(curr.data+" ");
        if(curr.right!=null) st.push(curr.right);
        if(curr.left!=null) st.push(curr.left);
    }
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
            System.out.println("Preorder Traversal");
            iterativePreOrder(root);
            
    }
}
