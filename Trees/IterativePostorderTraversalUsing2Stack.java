import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IterativePostorderTraversalUsing2Stack {
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
    // we using 2 stack for the iterative Postorder traversal
    public static List<Integer> iterativePostorder(ListNode root){
        List<Integer> ls=new LinkedList<>();
        Stack<ListNode> st1=new Stack<>();
        Stack<ListNode> st2=new Stack<>();
        if(root==null) return ls;
        st1.push(root);
        while (!st1.isEmpty()) {
            root=st1.pop();
            st2.add(root);
            if(root.left!=null) st1.push(root.left);
            if(root.right!=null) st1.push(root.right);
        }
        while (!st2.isEmpty()) {
            ls.add(st2.pop().data);
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
        // we are doing the iterative InOrder Traversal
        System.out.println("Inorder Traversal");
        List<Integer> res = iterativePostorder(root);
        System.out.println(res);
    }
}
