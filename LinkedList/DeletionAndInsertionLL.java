public class DeletionAndInsertionLL {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
            this.next=null;
        }
    }
    public static ListNode printList(ListNode head){
     ListNode temp=head;
     while (temp!=null) {
        System.out.print(temp.val+"->");
        temp=temp.next;
     }
     System.out.println("null");
     return head;
    }
    public static ListNode DeleteAtStart(ListNode head){
        if(head==null) return head;
        ListNode temp=head;
        head=head.next;
        return head;
    }
    public static ListNode DeleteAtLast(ListNode head){
        if(head==null &&head.next==null ) return null;
        ListNode temp=head;
        while (temp.next.next!=null) {
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }
    public static int lengthLL(ListNode head){
        ListNode temp=head;
        int len=1;
        while (temp.next!=null) {
            temp=temp.next;
            len++;
        }
        return len;
    }
    public static ListNode DeleteAtPos(ListNode head,int idx){
        if(head==null) return null;
        if(idx>lengthLL(head)){
            System.out.println("Please enter valid index");
            return head;
        } 
        if(idx==1) return DeleteAtStart(head);
        if(idx==lengthLL(head)) return DeleteAtLast(head);
        int len=lengthLL(head);
        ListNode temp=head;
        int count=1;
        while (temp!=null) {
            count++;
            if(count==idx){
                temp.next=temp.next.next;
            }
            temp=temp.next;
        }
        return head;
        

    }

    public static boolean DeleteVal(ListNode head,int target){
        if(head==null) return false;
        ListNode temp=head;
        while (temp!=null) {
            if(temp.val==target){
                return true;
            }
            temp=temp.next;
        }
        return false;
        

    }
    public static ListNode insertAtHead(ListNode head,int val){
        if(head==null) return null;
        ListNode temp=head;
        ListNode newNode=new ListNode(val)  ;
        newNode.next=temp;
        head=newNode;
        return head;
    }
    public static ListNode insertAtEnd(ListNode head,int val){
        ListNode temp=head;
        if(head==null) return null;
        while (temp.next!=null) {
            temp=temp.next;
        }
        ListNode newNode=new ListNode(val);
        temp.next=newNode;
        return head;
    }
    public static ListNode insertAtPos(ListNode head, int val, int idx) {
        if (idx < 1 || (head == null && idx > 1)) return head;
        ListNode newNode = new ListNode(val);
        if (idx == 1) {
            newNode.next = head;
            return newNode;
        }
        ListNode temp = head;
        for (int i = 1; i < idx - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) return head;
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        printList(head);
        System.out.println();
        // System.out.println("Deleting the first node");
        // ListNode root=DeleteAtStart(head);
        // printList(root);
        // System.out.println();
        // ListNode root1=DeleteAtLast(root);
        // printList(root1);
        // System.out.println("Hi");
        // System.out.println("Length of the linked list:"+lengthLL(head));
        // ListNode root2=DeleteAtPos(head,2);
        // printList(root2);
        // System.out.println(DeleteVal(head,3));
        // ListNode root4=insertAtHead(head,0);
        // printList(root4);
        // ListNode root5=insertAtEnd(head,6);
        // printList(root5);
        ListNode root6=insertAtPos(head,8,2);
        printList(root6);
    }
}
