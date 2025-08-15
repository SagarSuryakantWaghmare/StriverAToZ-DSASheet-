import java.util.*;

public class FlattenALinkedList {
    static class Node {
        int data;
        Node next;
        Node child;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }
    }

    public static Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;
        if (a.data < b.data) {
            result = a;
            result.child = merge(a.child, b);
        } else {
            result = b;
            result.child = merge(a, b.child);
        }
        result.next = null; 
        return result;
    }

    public static Node flattenLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        head.next = flattenLL(head.next);
        head = merge(head, head.next);

        return head;
    }

    public static void main(String[] args) {
        /* Example structure:
            1 -> 2 -> 3
            |    | 
            4    6
            |
            5
        */
        Node head = new Node(1);
        head.child = new Node(4);
        head.child.child = new Node(5);

        head.next = new Node(2);
        head.next.child = new Node(6);

        head.next.next = new Node(3);

        head = flattenLL(head);

        // Print flattened list
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.child;
        }
    }
}
