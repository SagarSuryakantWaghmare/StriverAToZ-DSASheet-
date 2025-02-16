public class QueueUsingLL {
    public static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class QueueLL {
        ListNode head, tail;

        QueueLL() {
            head = tail = null;
        }

        void push(int val) {
            ListNode newNode = new ListNode(val);
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        int pop() {
            if (head == null) {
                System.out.println("Queue is empty");
                return -1;
            }
            int val = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return val;
        }

        void print() {
            ListNode temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QueueLL q = new QueueLL();
        q.push(2);
        q.push(20);
        q.push(12);
        q.push(42);
        q.push(72);
        
        System.out.println(q.pop()); 
        q.print(); 
    }
}
