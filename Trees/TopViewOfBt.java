import java.util.*;
public class TopViewOfBt {
        public static class TreeNode{
            int data;
            TreeNode left;
            TreeNode right;
            TreeNode(int data){
                this.data=data;
                this.left=null;
                this.right=null;
            }
        }
        public static class Pair{
            TreeNode hd;
            int val;
            Pair(TreeNode hd,int val){
                this.hd=hd;
                this.val=val;
            }
        }
        public static List<Integer> topView(TreeNode root){
            List<Integer> res=new ArrayList<>();
            if(root==null) return res;
            Map<Integer,Integer> mp=new HashMap<>();
            Queue<Pair> q=new LinkedList<Pair>();
            q.add(new Pair(root, 0));
            while (!q.isEmpty()) {
                Pair it=q.remove();
                int hd=it.val;
                TreeNode temp=it.hd;
                if(mp.get(hd)==null) mp.put(hd, temp.data);
                if(temp.left!=null){
                    q.add(new Pair(temp.left, hd-1));
                }
                if(temp.right!=null){
                    q.add(new Pair(temp.right, hd+1));
                }
            }
            for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
                res.add(entry.getValue());
            }
            return res;
        }
        
        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            List<Integer> ls=topView(root);
            System.out.println(ls);

        }
    }
    