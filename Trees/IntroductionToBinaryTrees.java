// Binary Tree
// Full BT-Either have 0 or2 children
// Complete binary tree-All levels are completely filled only the last is only
// the left side is possibly filled fully.
// Perfect Binary Tree-All leaf nodes are at same level.
// Balanced BT-Height of the tree max log(n) n=8 nodes log2(8)=3
// Degenerated Tree only one side is called as the DBT.Every node has single
// node.

// Binary tree representation in java
/*
 * We have to store in the form the left data right
 * so we have to pointers for the left right pointers
 * if it is not pointing towards any one's then it pointing to the null.
 * 
 * Representation of binary tree
 * class ListNode{
 * int data;
 * ListNode left;
 * ListNode right;
 * ListNode(int data){
 * this.data=data;
 * this.left=null;
 * this.right=null;
 * }
 * }
 * 
 * 
 */
public class IntroductionToBinaryTrees {
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
    // So we have two traversal techniques mainly dfs and bfs
    // In the dfs there are three traversals
    // Inorder traversal-left root right
    // PreOrder Traversal-root left right
    // PostOrder Traversal-left right root
    public static void preOrder(ListNode node){
     if(node==null) return;
     System.out.print(node.data+" ");
     preOrder(node.left);
     preOrder(node.right);
    }
    public static void postOrder(ListNode node){
        if(node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }
    public static void inOrder(ListNode node){
        if(node==null) return;
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
    
    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(6);
        ListNode d = new ListNode(9);
        a.left = b;
        a.right = c;
        b.right = d;
        System.out.println("PreOrder Traversal:");
        preOrder(a);
        System.out.println();
        System.out.println("PostOrder Traversal:");
        postOrder(a);
        System.out.println();
        System.out.println("InOrder Traversal:");
        inOrder(a);

    }
}
