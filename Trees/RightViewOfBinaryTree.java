import java.util.*;

public class RightViewOfBinaryTree {
    public static class ListNode {
        int data;
        ListNode left;
        ListNode right;
        ListNode(int data){
            this.data=data;
        }
    }
    public static List<Integer> res;
    public static List<Integer> rightView(TreeNode root){
        res=new ArrayList<>();
        if(root==null) return res;
        traversal(root,0);
        return res;
    }
    public static void traversal(TreeNode root,int level){
        if(root==null) return;
        if(level==res.size()){
            res.add(root.data);
        }
        traversal(root.right,level+1);
        traversal(root.left, level+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> ls=rightView(root);
        System.out.println(ls);
    }
}
