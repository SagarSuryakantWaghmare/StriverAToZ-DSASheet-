public class DeleteAKeyFromDLL {
    public static class DoublyLinkedList {
        Node head;

        static class Node {
            int data;
            Node prev;
            Node next;

            Node(int d) {
                data = d;
                prev = null;
                next = null;
            }
        }
        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }

        // Print the list
        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    public static void deleteKey(DoublyLinkedList dll,int key){
        DoublyLinkedList.Node temp = dll.head;
        if(temp!=null&&temp.data==key){
            dll.head=temp.next;
            dll.head.prev=null;
            return;
        }
        while (temp!=null&&temp.data!=key) {
            temp=temp.next;
        }
        if(temp==null){
            return;
        }
        if(temp.next!=null){
            temp.next.prev=temp.prev;
        }
        if(temp.prev!=null){
            temp.prev.next=temp.next;
        }
        


    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtEnd(1);
        dll.insertAtEnd(3);
        dll.insertAtEnd(2);
        dll.insertAtEnd(3);
        dll.insertAtEnd(4);
        deleteKey(dll, 3);
        dll.printList();
    }
}
