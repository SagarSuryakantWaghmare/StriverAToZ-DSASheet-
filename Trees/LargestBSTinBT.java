public class LargestBSTinBT {
    // Brute force:O(n)*O(n)
    
    // Intution and thought  process
    // If not bst size=max(left.size,right.size);
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static class NodeValue{
        int maxNode,minNode,maxSize;
        NodeValue(int minNode,int maxNode,int maxSize){
            this.maxNode=maxNode;
            this.minNode=minNode;
            this.maxSize=maxSize;
        }
    }
    public static NodeValue largestBSTSubtreeHelper(Node root){
        if(root==null){
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        NodeValue left=largestBSTSubtreeHelper(root.left);
        NodeValue right=largestBSTSubtreeHelper(root.right);
        if(left.maxNode<root.data&&root.data<right.minNode){
            return new NodeValue(Math.min(root.data,left.minNode), Math.max(root.data, right.maxNode), left.maxSize+right.maxSize+1);
        }
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
    public static int largestBSTSubtree(Node root) {
        return largestBSTSubtreeHelper(root).maxSize;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(8);
        root.right.right = new Node(7);
        System.out.println("Size of the largest BST is " + largestBSTSubtree(root));
    }
}
