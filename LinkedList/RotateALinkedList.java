public class RotateALinkedList {
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
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static ListNode rotateLL(ListNode head,int k){
    //  1 2 3 4 5 6 7 8 9 10
    // 9 10 1 2 3 4 5 6 7 8
    ListNode temp=head;
    int length=1;
    while (temp.next!=null) {
        length++;
        temp=temp.next;
    }
    if(k==length) return head;
    temp.next=head;
    temp=head;
    k=k%length;
    for(int i=0;i<k-1;i++){
        temp=temp.next;
    }
    head=temp.next;
    temp.next=null;
    return head;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
        head.next.next.next.next.next.next=new ListNode(7);
        head.next.next.next.next.next.next.next=new ListNode(8);
        head.next.next.next.next.next.next.next.next=new ListNode(9);
        head.next.next.next.next.next.next.next.next.next=new ListNode(10);
        head.next.next.next.next.next.next.next.next.next.next=null;
        int k=3;
        printList(head);
        System.out.println("After rotating the linked list");
        ListNode result=rotateLL(head,k);
        printList(result);
    }
}
