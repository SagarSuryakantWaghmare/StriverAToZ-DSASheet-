import java.util.LinkedList;

public class IsCycle {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        System.out.println("Is the IsCycle in the linked list?");
        LinkedList<ListNode> list = new LinkedList<>();
        // Add nodes to the list
        list.add(new ListNode(1));
        list.add(new ListNode(2));
        list.add(new ListNode(3));
        System.out.println("Cycle detected: " + hasCycle(list));
    }

    public static boolean hasCycle(LinkedList<ListNode> list) {
        if (list == null || list.size() < 2) return false;

        ListNode slow = list.get(0);
        ListNode fast = list.get(0);

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }
}