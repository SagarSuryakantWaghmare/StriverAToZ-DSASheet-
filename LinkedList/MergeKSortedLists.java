import java.util.*;

public class MergeKSortedLists {
    public static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static ListNode mergeList(List<ListNode> heads) {
        if (heads == null || heads.size() == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.data));

        // Add the head of each list to the heap
        for (ListNode head : heads) {
            if (head != null) {
                minHeap.add(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll(); // Get the smallest element
            temp.next = smallest;
            temp = temp.next;

            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        
        ListNode list2 = new ListNode(13);
        list2.next = new ListNode(21);

        ListNode list3 = new ListNode(21);
        list3.next = new ListNode(31);
        list3.next.next = new ListNode(32);

        ListNode list4 = new ListNode(11);
        list4.next = new ListNode(12);
        list4.next.next = new ListNode(31);
        list4.next.next.next = new ListNode(40);

        ListNode list5 = new ListNode(4);
        list5.next = new ListNode(6);
        list5.next.next = new ListNode(13);
        list5.next.next.next = new ListNode(14);
        list5.next.next.next.next = new ListNode(25);

        List<ListNode> heads = new ArrayList<>();
        heads.add(list1);
        heads.add(list2);
        heads.add(list3);
        heads.add(list4);
        heads.add(list5);

        System.out.println("Merged List:");
        ListNode newMerge = mergeList(heads);
        printList(newMerge);
    }
}
