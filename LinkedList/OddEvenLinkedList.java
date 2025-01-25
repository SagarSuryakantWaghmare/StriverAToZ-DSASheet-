public class OddEvenLinkedList {
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
    public static ListNode oddEvenLL(ListNode head){
        ListNode temp=head;
        ListNode Eodd=new ListNode(-1);
        ListNode Eeven=new ListNode(-1);
        ListNode odd=Eodd;
        ListNode even=Eeven;
        while (temp!=null&&temp.next!=null) {
            odd.next=temp;
            odd=odd.next;
            temp=temp.next;

            even.next=temp;
            even=even.next;
            temp=temp.next;
        }
        odd.next=Eeven.next;
        head=Eodd.next;
        return head;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode first=new ListNode(2);
        ListNode second=new ListNode(3);
        ListNode third=new ListNode(4);
        ListNode forth=new ListNode(5);
        ListNode fifth=new ListNode(6);
        head.next=first;
        first.next=second;
        second.next=third;
        third.next=forth;
        forth.next=fifth;
        printList(head);
        System.out.println();
        ListNode newNode=oddEvenLL(head);
        printList(newNode);
        
    }
}
