import java.util.Stack;

public class ReverseLinkedList {
        public static class ListNode{
         int data;
         ListNode next;
         ListNode(int data){
             this.data=data;
             this.next=null;
         }
     
        }
        public static void printList(ListNode head){
         ListNode temp=head;
         while (temp!=null) {
             System.out.print(temp.data+" ");
             temp=temp.next;
         }
        }
        // Reverse using the stack
        // public static ListNode reverse(ListNode head){
        //     ListNode temp=head;
        //     Stack<Integer> st=new Stack<>();
        //     while (temp!=null) {
        //         st.push(temp.data);
        //         temp=temp.next;
        //     }
        //     temp=head;
        //     while (temp!=null) {
        //         temp.data=st.pop();
        //         temp=temp.next;
        //     }
        //     return head;
        // }

        // Without using any extra space 
        // Only O(1) space
        // By Linked list

        // public static ListNode reverse(ListNode head){
        //     ListNode curr=head;
        //     ListNode pre=null;
        //     ListNode front=null;
        //     while (curr!=null) {
        //         front=curr.next;
        //         curr.next=pre;
        //         pre=curr;
        //         curr=front;
        //     }
        //     return pre;
        // }

        // Recursion
        public static ListNode reverse(ListNode head){
            if(head==null||head.next==null){
                return head;
            }
            ListNode newHead=reverse(head.next);
            ListNode front=head.next;
            front.next=head;
            head.next=null;
            return newHead;
        }
     
         public static void main(String[] args) {
             ListNode head=new ListNode(1);
             ListNode first=new ListNode(2);
             ListNode second=new ListNode(3);
             ListNode third=new ListNode(4);
             ListNode forth=new ListNode(5);
             head.next=first;
             first.next=second;
             second.next=third;
             third.next=forth;
             forth.next=null;
             printList(head);
             System.out.println();
             ListNode newNode=reverse(head);
             printList(newNode);
         }
     }