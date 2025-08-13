public class SortLinedListZOT {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node sortList(Node head) {
        Node temp = head;
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        while (temp != null) {
            if (temp.data == 0) {
                count0++;
            } else if (temp.data == 1) {
                count1++;
            } else {
                count2++;
            }
            temp = temp.next;
        }

        temp = head;

        // Fill with 0s
        while (count0-- > 0 && temp != null) {
            temp.data = 0;
            temp = temp.next;
        }

        // Fill with 1s
        while (count1-- > 0 && temp != null) {
            temp.data = 1;
            temp = temp.next;
        }

        // Fill with 2s
        while (count2-- > 0 && temp != null) {
            temp.data = 2;
            temp = temp.next;
        }

        return head;
    }

    public static Node sortListMerge(Node head) {
        if (head == null || head.next == null)
            return head;
        Node Middle = Middle(head);
        Node left = sortListMerge(head);
        Node right = sortListMerge(Middle);
        return mergeSort(left, right);
    }

    public static Node Middle(Node head){
       Node slow=head;
        Node fast=head;
        Node prev=null;
        while(fast!=null&&fast.next!=null){
            prev=slow;
            fast=fast.next.next;
            slow=slow.next;
        }
        if(prev!=null){
            prev.next=null;
        }
        return slow;
    }

    public static Node mergeSort(Node l1, Node l2) {
        Node l = new Node(-1);
        Node temp = l;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp=temp.next;
        }
        if (l1 != null) {
            temp.next = l1;
        }
        if (l2 != null) {
            temp.next = l2;
        }
        return l.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(0);

        System.out.println("Linked List before Sorting:");
        printList(head);

        // count ways
        // Node newL = sortList(head);

        // merge sort
        Node newL = sortListMerge(head);

        System.out.println("Linked List after Sorting:");
        printList(newL);
    }
}