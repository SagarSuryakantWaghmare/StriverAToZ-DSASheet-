public class FlatteringLL {
    public static class ListNode {
        int data;
        ListNode next;
        ListNode child;
        
        ListNode(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }
    }

    // Merge two sorted child-linked lists
    public static ListNode mergeList(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        
        while (a != null && b != null) {
            if (a.data <= b.data) {
                temp.child = a;
                a = a.child;
            } else {
                temp.child = b;
                b = b.child;
            }
            temp = temp.child;
        }
        
        if (a != null) temp.child = a;
        if (b != null) temp.child = b;
        
        return dummy.child;
    }

    // Flatten the multilevel linked list
    public static ListNode flattenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursively flatten the next list
        head.next = flattenList(head.next);
        
        // Merge current node with flattened next
        head = mergeList(head, head.next);
        
        return head;
    }

    // Print the flattened list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.child;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h1 = new ListNode(4);
        ListNode h2 = new ListNode(7);
        ListNode h3 = new ListNode(9);
        ListNode first = new ListNode(6);
        ListNode f1 = new ListNode(15);
        ListNode f2 = new ListNode(20);
        ListNode second = new ListNode(8);
        ListNode s1 = new ListNode(13);
        ListNode s2 = new ListNode(20);

        head.next = first;
        first.next = second;
        second.next = null;

        head.child = h1;
        h1.child = h2;
        h2.child = h3;
        h3.child = null;

        first.child = f1;
        f1.child = f2;
        f2.child = null;

        second.child = s1;
        s1.child = s2;
        s2.child = null;

        // Flatten the list
        head = flattenList(head);

        // Print the flattened list
        printList(head);
    }
}
