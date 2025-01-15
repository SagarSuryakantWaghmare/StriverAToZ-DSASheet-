public class DoublyLL {
    public static class ListNode {
        int data;
        ListNode next;
        ListNode prev;

        ListNode(int data) {
            this.data = data;
        }

        ListNode(int data, ListNode next, ListNode prev) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void convertArrayToDLL(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode curr = new ListNode(arr[i]);
            temp.next = curr;
            temp = curr;
        }
        print(head);
    }

    public static int lengthOfDLL(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }

    public static ListNode deleteHead(ListNode head) {
        if (head == null)
            return null;
        if (lengthOfDLL(head) == 1)
            return null;
        ListNode temp = head;
        temp = temp.next;
        temp.prev = null;
        head = temp;

        return head;
    }

    public static ListNode deleteTail(ListNode head) {
        if (head == null)
            return null;
        if (lengthOfDLL(head) == 1)
            return null;
        ListNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;

        return head;
    }

    public static ListNode deteteKthNode(ListNode head, int idx) {
        // Handle invalid cases
        if (head == null) {
            System.out.println("List is empty.");
            return null;
        }
        int length = lengthOfDLL(head);
        if (idx <= 0 || idx > length) {
            System.out.println("Enter a valid index.");
            return head; // Return the unchanged list
        }
    
        // Deleting the head node
        if (idx == 1) {
            return deleteHead(head);
        }
    
        // Deleting the tail node
        if (idx == length) {
            return deleteTail(head);
        }
    
        // Deleting a node in the middle
        ListNode temp = head;
        int count = 1;
        while (count < idx) {
            temp = temp.next;
            count++;
        }
    
        ListNode back = temp.prev;
        ListNode front = temp.next;
    
        if (back != null) {
            back.next = front;
        }
        if (front != null) {
            front.prev = back;
        }
    
        return head;
    }
    public static ListNode deleteANode(ListNode head,int val){
    ListNode temp=head;
    while (temp!=null) {
        if(temp.data==val){
            break;
        }
        temp=temp.next;
    }
    ListNode back=temp.prev;
    ListNode front=temp.next;
    if(back!=null){
        back.next=front;
    }
    if(front!=null){
        front.prev=back;
    }
    return head;
    }
    public static ListNode insertHead(ListNode head,int val){
        if(head==null||head.next==null) return null;
        ListNode temp=head;
        ListNode newNode=new ListNode(val);
        temp.prev=newNode;
        newNode.next=temp;
        head=newNode;
        return head;
    }

    public static ListNode insertTail(ListNode head,int val){
        if(head==null||head.next==null) return null;
        ListNode temp=head;
        ListNode newNode=new ListNode(val);
        while (temp.next!=null) {
            temp=temp.next;
        }
        ListNode curr=temp;
        temp.next=newNode;
        newNode.prev=curr;
        return head;
    }
    public static ListNode insertKthPos(ListNode head,int val,int idx){
        ListNode temp=head;
        int count=1;
        while (temp!=null) {
            if(count<idx){
                count++;
                break;
            }
            temp=temp.next;
        }
        ListNode newNode=new ListNode(val);
        ListNode curr=temp;
        ListNode front=temp.next;
        newNode.next=front;
        newNode.prev=curr;
        curr.next=newNode;
        return head;


    }
    public static void insertBeforeNode(ListNode node, int val) {
        ListNode prev = node.prev;
        ListNode newNode = new ListNode(val);
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = node;
        node.prev = newNode;
    }
    
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(4);
        head.prev = null;
        head.next = first;
        first.next = second;
        second.next = third;
        third.next = null;
        first.prev = head;
        second.prev = first;
        third.prev = second;
        print(head);
        // convert array into double linked list
        int arr[] = { 5, 6, 7, 8 };
        convertArrayToDLL(arr);
        System.out.println();
        // System.out.println("Length of the DLL:" + lengthOfDLL(head));
        // ListNode root = deleteHead(head);
        // print(root);
        // System.out.println();
        // ListNode root1 = deleteTail(root);
        // print(root1);
        // System.out.println();
        // ListNode root2 = deteteKthNode(head,3);
        // print(root2);
        // ListNode root3=deleteANode(head, 3);
        // print(root3);
        // inserting in the node
        // ListNode root4=insertHead(head,0);
        // print(root4);
        // ListNode root5=insertTail(head,5);
        // print(root5);
        // ListNode root6=insertKthPos(head,8,2);
        // print(root6);
        insertBeforeNode(head.next,8);
        print(head);

    }
}
