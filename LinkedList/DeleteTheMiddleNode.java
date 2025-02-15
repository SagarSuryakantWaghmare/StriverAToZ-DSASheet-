public class DeleteTheMiddleNode {
    public static class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static void printLL(ListNode head){
        ListNode temp=head;
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    // we can simply measure all the length of the linked list and the just 
    // Remove the n/2 form the linked list

    // Tortoise and hear algorithm
    public static ListNode deleteMiddle(ListNode head){
        if(head==null||head.next==null) return null;
        ListNode slow=head;
        ListNode fast=head;
        // we just add and skip on step of the fast
        fast=fast.next.next;
        while (fast!=null&&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=slow.next.next;
        return head;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        printLL(head);
        ListNode middleDelete=deleteMiddle(head);
        System.out.println("After delete the middle element");
        printLL(middleDelete);
    }
}
