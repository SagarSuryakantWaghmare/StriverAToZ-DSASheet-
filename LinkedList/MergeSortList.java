public class MergeSortList {
    public static class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static void printList(ListNode head){
        ListNode temp=head;
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static ListNode findMiddle(ListNode head ){
        if(head==null||head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head;
        while (fast.next!=null&&fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static ListNode mergeSort(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode middle=findMiddle(head);
        ListNode left=head;
        ListNode right=middle.next;
        middle.next=null;
        left=mergeSort(left);
        right=mergeSort(right);
        return merge(left,right);

    }
    public static ListNode merge(ListNode left,ListNode right){
        ListNode dummy =new ListNode(0);
        ListNode temp=dummy;
        while (left!=null&&right!=null) {
            if(left.data<=right.data){
                temp.next=left;
                left=left.next;
            }
            else{
                temp.next=right;
                right=right.next;
            }
            temp=temp.next;
        }
        if(left==null){
            temp.next=right;
        }
        if(right==null){
            temp.next=left;
        }
        return dummy.next;

    }
    public static void main(String[] args) {
        ListNode head=new ListNode(4);
        ListNode first=new ListNode(3);
        ListNode second=new ListNode(2);
        ListNode third=new ListNode(9);
        ListNode forth=new ListNode(5);
        head.next=first;
        first.next=second;
        second.next=third;
        third.next=forth;
        forth.next=null;
        printList(head);
        ListNode newMerge=mergeSort(head);
        printList(newMerge);
       }
}
