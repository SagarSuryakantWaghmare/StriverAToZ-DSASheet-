public class CloneLinkedList {
    public static class ListNode {
        int data;
        ListNode next;
        ListNode random;

        ListNode(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }

    public static ListNode cloneList(ListNode head) {
        if (head == null) return null;

        // Step 1: Create interleaved copy nodes
        ListNode temp = head;
        while (temp != null) {
            ListNode copyNode = new ListNode(temp.data);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = copyNode.next;
        }

        // Step 2: Assign random pointers
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // Step 3: Separate original and cloned lists
        ListNode newHead = head.next;
        ListNode copy = newHead;
        temp = head;
        while (temp != null) {
            temp.next = temp.next.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            temp = temp.next;
            copy = copy.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        head.random = head.next.next;  // 1 -> 3
        head.next.random = head;       // 2 -> 1
        head.next.next.random = head.next; // 3 -> 2

        ListNode clonedHead = cloneList(head);

        // Print original and cloned list for verification
        System.out.println("Original list:");
        printList(head);
        System.out.println("Cloned list:");
        printList(clonedHead);
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print("Data: " + temp.data);
            if (temp.random != null) {
                System.out.println(", Random: " + temp.random.data);
            } else {
                System.out.println(", Random: null");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}
