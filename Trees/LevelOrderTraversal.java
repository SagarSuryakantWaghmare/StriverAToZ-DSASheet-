import java.util.*;
public class LevelOrderTraversal {
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
    public static List<List<Integer>> bfs(ListNode root){
         List<List<Integer>> wrap=new LinkedList<>();
         Queue<ListNode> q=new LinkedList<>();
         if(root==null) return wrap;
         q.offer(root);
         while (!q.isEmpty()) {
            int level=q.size();
            List<Integer> sub=new LinkedList<>();
            for(int i=0;i<level;i++){
                ListNode curr=q.poll();
                sub.add(curr.data);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            wrap.add(sub);
         }
         return wrap;
    }
        public static void main(String[] args) {
            
            ListNode root = new ListNode(1);
            root.left = new ListNode(2);
            root.right = new ListNode(3);
            root.left.left = new ListNode(4);
            root.left.right = new ListNode(5);
            root.right.left = new ListNode(6);
            root.right.right = new ListNode(7);
            List<List<Integer>> res=bfs(root);
            System.out.println(res);
        
        }
    
}
