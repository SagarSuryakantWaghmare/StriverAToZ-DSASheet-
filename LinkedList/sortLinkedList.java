public class sortLinkedList {
    public static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    // sort linked list having only 0 1 2
    // public static ListNode sortLL(ListNode head){
    // ListNode temp=head;
    // int c0=0;
    // int c1=0;
    // int c2=0;
    // while (temp!=null) {
    // if(temp.data==0){
    // c0++;
    // }
    // else if(temp.data==1){
    // c1++;
    // }
    // else{
    // c2++;
    // }
    // temp=temp.next;
    // }
    // temp=head;
    // while (temp!=null) {
    // if(c0>0){
    // temp.data=0;
    // c0--;
    // }
    // else if(c1>0){
    // temp.data=1;
    // c1--;
    // }
    // else{
    // temp.data=2;
    // c2--;
    // }
    // temp=temp.next;
    // }
    // return head;

    // }

    public static ListNode sortLL(ListNode head) {
        ListNode temp = head;
        ListNode z = new ListNode(-1);
        ListNode o = new ListNode(-1);
        ListNode t = new ListNode(-1);
        ListNode zero = z;
        ListNode one = o;
        ListNode two = t;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            }
            if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            }
            if (temp.data == 2) {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        zero.next = (o.next!=null)?(o.next):(t.next);
        one.next = t.next;
        two.next=null;
        head=z.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(0);
        ListNode third = new ListNode(2);
        ListNode forth = new ListNode(0);
        ListNode fifth = new ListNode(1);
        head.next = first;
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        printList(head);
        System.out.println();
        ListNode newNode = sortLL(head);
        printList(newNode);

    }
}
