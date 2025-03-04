import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorderTraversal {
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

    public static List<Integer> iterativeInOrder(ListNode root) {
        Stack<ListNode> st = new Stack<>();
        List<Integer> ls=new ArrayList<>();
        if (root == null)
            return ls;
        ListNode node=root;
        while (true) {
            if(node!=null){
                st.push(node);
                node=node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                node=st.pop();
                ls.add(node.data);
                node=node.right;
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
        // we are doing the iterative InOrder Traversal
        System.out.println("Inorder Traversal");
        List<Integer> res = iterativeInOrder(root);
        System.out.println(res);

    }
}
