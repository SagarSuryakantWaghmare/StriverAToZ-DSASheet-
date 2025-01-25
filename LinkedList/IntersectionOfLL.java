public class IntersectionOfLL {
    public static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }

        ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode findIntersection(ListNode a, ListNode b) {
        if (a == null || b == null) return null;

        ListNode n1 = a;
        ListNode n2 = b;

        // Traverse both lists. When one pointer reaches the end, switch to the other list's head.
        while (n1 != n2) {
            n1 = (n1 == null) ? b : n1.next;
            n2 = (n2 == null) ? a : n2.next;
        }

        return n1; // This will either be the intersection node or null if no intersection exists.
    }

    public static void main(String[] args) {
        // Create two lists with an intersection
        ListNode common = new ListNode(6);
        common.next = new ListNode(2);
        common.next.next = null;

        ListNode a = new ListNode(3);
        a.next = new ListNode(1);
        a.next.next = new ListNode(4);
        a.next.next.next = common; // Intersection starts here

        ListNode b = new ListNode(1);
        b.next = new ListNode(2);
        b.next.next = common; // Intersection starts here

        // Print both lists
        printList(a);
        printList(b);

        // Find intersection
        ListNode ans = findIntersection(a, b);
        if (ans != null) {
            System.out.println("Intersection at node with value: " + ans.data);
        } else {
            System.out.println("No intersection.");
        }
    }
}
