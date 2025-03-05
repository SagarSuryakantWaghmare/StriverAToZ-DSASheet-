import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;
    TreeNode(int val) {
        this.data = val;
        left = right = null;
    }
}

class Pair {
    TreeNode node;
    int state;

    Pair(TreeNode node, int state) {
        this.node = node;
        this.state = state;
    }
}

public class TreeTraversal {
    public static List<List<Integer>> preInPost(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        
        if (root == null) return ls;

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {
            Pair p = st.pop();
            
            if (p.state == 1) { // Preorder
                pre.add(p.node.data);
                p.state++;
                st.push(p);
                if (p.node.left != null) {
                    st.push(new Pair(p.node.left, 1));
                }
            } 
            else if (p.state == 2) { // Inorder
                in.add(p.node.data);
                p.state++;
                st.push(p);
                if (p.node.right != null) {
                    st.push(new Pair(p.node.right, 1));
                }
            } 
            else { // Postorder
                post.add(p.node.data);
            }
        }

        ls.add(pre);
        ls.add(in);
        ls.add(post);
        return ls;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = preInPost(root);
        System.out.println("Preorder: " + result.get(0));
        System.out.println("Inorder: " + result.get(1));
        System.out.println("Postorder: " + result.get(2));
    }
}
