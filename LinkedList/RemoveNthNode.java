
public class RemoveNthNode {
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
   }
   public static ListNode removeNthNode(ListNode head,int count){
    ListNode fast=head;
    ListNode slow=head;
    for (int i = 0; i < count; i++) {
        fast=fast.next;
    }
    while (fast.next!=null) {
        slow=slow.next;
        fast=fast.next;
    }
    slow.next=slow.next.next;
    return head;
   }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode first=new ListNode(2);
        ListNode second=new ListNode(3);
        ListNode third=new ListNode(4);
        ListNode forth=new ListNode(5);
        head.next=first;
        first.next=second;
        second.next=third;
        third.next=forth;
        forth.next=null;
        printList(head);
        System.out.println();
        ListNode newNode=removeNthNode(head,3);
        printList(newNode);
    }
}