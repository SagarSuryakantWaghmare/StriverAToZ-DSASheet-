import java.util.*;
public class PrintRootToNodePath {
            public static class TreeNode {
                int data;
                TreeNode left;
                TreeNode right;
                TreeNode(int data){
                    this.data=data;
                }
            }
            // Root to Node path:
            // Like the node =7 from the root
            public static boolean getPath(ArrayList<Integer> ls,TreeNode root,int val){
                if(root==null){
                    return false;
                }
                ls.add(root.data);
                if(root.data==val){
                    return true;
                }
                if(getPath(ls, root.left, val)||getPath(ls, root.right, val)){
                    return true;
                }
                ls.remove(ls.size()-1);
                return false;
            }
            public static ArrayList<Integer> rootToNode(TreeNode root,int val){
                ArrayList<Integer> ls=new ArrayList<>();
                if(root==null) return ls;
                getPath(ls,root,val);
                return ls;
            }
            public static void main(String[] args) {
                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);
                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(5);
                root.right.left = new TreeNode(6);
                root.right.left.right = new TreeNode(7);
        
                ArrayList<Integer> ls=rootToNode(root,7);
                System.out.println(ls);
            }
        }
        
    
