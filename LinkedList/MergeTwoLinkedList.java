public class MergeTwoLinkedList {
    public static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static ListNode mergeTwoLists(ListNode a,ListNode b)
    {
        ListNode temp=new ListNode(0);
        ListNode dummy=temp;
        ListNode t1=a;
        ListNode t2=b;
        while (t1!=null&&t2!=null) {
            if(t1.data<=t2.data){
                dummy.next=t1;
                t1=t1.next;
            }
            else{
                dummy.next=t2;
                t2=t2.next;
            }
            dummy=dummy.next;
        }
        if(t1==null){
            dummy.next=t2;
        }
        if(t2==null){
            dummy.next=t1;
        }
        return temp.next;
    }
    

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        ListNode mergedList = mergeTwoLists(l1, l2);
        printList(mergedList);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
