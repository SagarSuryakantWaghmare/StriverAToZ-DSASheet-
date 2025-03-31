public class recoverBST {
    // Two nodes swapped so we have to recover bst
    // Case:Always two nodes are swapped not more that or less than that
    // Brute force:Inorder Traversal
    // we can to the inorder traversal and sort it 
    // And then point to the node and check if it equal

    // Optimal solution:We just have to find the which nodes are swapped
    // 3 25 7 8 10 15 20 5
    // so find out 25>7 so there is 5 also which 20>5
    // so can simple first and last store we have to swap that
    // f(node.left)
    // node
    // f(node.right)


    // case: 3 5 8 7 10 15 20 25
    // here 8>7 we store 8 and 7 
    // There is not other valuation
    // So there is adjacent nodes are not correct
    // So we have to swap first and middle


    // so are directly doing the inorder traversal
    // So can also do the morre's traveral
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static Node first;
    public static Node prev;
    public static Node middle;
    public static Node last;

    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null&&(root.data<prev.data)){
          if(first==null){
            first=prev;
            middle=root;
          }
          else{
            last=root;
          }
        }
        prev=root;
        inorder(root.right);
    }
    public static void recoverTree(Node root){
        first=middle=last=null;
        prev=new Node(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null&&last!=null){
            int t=first.data;
            first.data=last.data;
            last.data=t;
        }
        else if(first!=null&&middle!=null){
            int t=first.data;
            first.data=middle.data;
            middle.data=t;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(6); // Corrected root value
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(1);
        root.left.right = new Node(10); // Corrected value to maintain BST property
        root.right.left = new Node(7);
        root.right.right = new Node(4); // Corrected value to maintain BST property
       inorderPrint(root);
       System.out.println("After recovery");
        recoverTree(root);

        inorderPrint(root);
    }

    public static void inorderPrint(Node root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.data + " ");
        inorderPrint(root.right);
    }
}
