public class QueueUsingArray {
    public static class QueueArray {
        int size = 4;
        int arr[] = new int[size];
        int length = 0;
        int start = -1;
        int end = -1;

        void push(int val) {
            if (length == size) {
                System.out.println("Queue is full");
                return;
            }
            if (length == 0) {
                start = 0;
                end = 0;
            } else {
                end = (end + 1) % size;
            }
            arr[end] = val;
            length++;
        }

        void pop() {
            if (length == 0) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.println("Popped: " + arr[start]);
            if (length == 1) {
                start = -1;
                end = -1;
            } else {
                start = (start + 1) % size;
            }
            length--;
        }

        int peek() {
            if (length == 0) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[start];
        }

        boolean isEmpty() {
            return length == 0;
        }

        void display() {
            if (length == 0) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.print("Queue elements: ");
            for (int i = 0; i < length; i++) {
                System.out.print(arr[(start + i) % size] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QueueArray queue = new QueueArray();

        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.push(40);
        queue.display();

        queue.pop();
        queue.display();

        queue.push(50);
        queue.display();

        System.out.println("Front element: " + queue.peek());

        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop(); // Queue is empty now
        queue.display();
    }
}
