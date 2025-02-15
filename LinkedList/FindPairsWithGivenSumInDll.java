import java.util.ArrayList;
import java.util.List;

public class FindPairsWithGivenSumInDll {
    public static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static void findPairs(Node head, int sum) {
        Node temp1 = head;
        List<List<Integer>> result = new ArrayList<>();
        while (temp1 != null) {
            Node temp2 = temp1.next;
            while (temp2 != null) {
                if (temp1.data + temp2.data == sum) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(temp1.data);
                    pair.add(temp2.data);
                    result.add(pair);
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        if (result.isEmpty()) {
            System.out.println("No pairs found");
        } else {
            for (List<Integer> list : result) {
                System.out.println(list);
            }
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        Node first = new Node(2);
        Node second = new Node(3);
        Node third = new Node(4);
        Node forth = new Node(9);
        Node fifth = new Node(6);
        head.next = first;
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = null;
        fifth.prev = forth;
        forth.prev = third;
        third.prev = second;
        second.prev = first;
        first.prev = head;
        head.prev = null;
        int sum = 5;
        findPairs(head, sum);
    }
}
