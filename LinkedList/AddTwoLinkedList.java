public class AddTwoLinkedList {
    // Node structure for the linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to print a linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static Node addTwoLL(Node a,Node b ){
        Node r=new Node(0);
        Node t=r;
        Node t1=a;
        Node t2=b;
        int carry=0;
        while (t1!=null&&t2!=null) {
            int n1=t1.data;
            int n2=t2.data;
            int sum=n1+n2+carry;
            carry=sum/10;
            Node newNode=new Node(sum%10);
            t1=t1.next;
            t2=t2.next;
            t.next=newNode;
            t=t.next;
        }
        if (t1==null) {
            t.next=t2;
        }
        if(t2==null) {
            t.next=t1;
        }
        if(carry!=0){
            Node newNode=new Node(carry);
            t.next=newNode;
        }
        return r.next;
    }

    public static void main(String[] args) {
        // First Linked List
        Node head1 = new Node(7);
        head1.next = new Node(2);
        head1.next.next = new Node(6);

        // Second Linked List
        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = new Node(6);

        // Printing both linked lists
        System.out.println("First Linked List:");
        printList(head1);
        System.out.println("Second Linked List:");
        printList(head2);
        System.out.println("Linked list after adding both linked lists:");
        Node head=addTwoLL(head1,head2);
        printList(head);
    }
}
