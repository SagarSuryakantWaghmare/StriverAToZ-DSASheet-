import java.util.*;
public class ReverseaDLL {
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
        // time complexity:O(2n)
        // Space complexity:O(n)
        // public static ListNode ReverseaDLL(ListNode head){
        //     Stack<Integer> st=new Stack<>();
        //     ListNode temp=head;
        //     while (temp!=null) {
        //         st.push(temp.data);
        //         temp=temp.next;
        //     }
        //      temp=head;
        //      while (temp!=null) {
        //         temp.data=st.pop();
        //         temp=temp.next;
        //     }
        //     return head;
        // }
        // Swaping way
        public static ListNode ReverseaDLL(ListNode head){
            if(head==null||head.next==null){
                return head;
            }
            ListNode pre=null;
            ListNode curr=head;
            while (curr!=null) {
                // Swaping using the third varible
                pre=curr.prev;
                curr.prev=curr.next;
                curr.next=pre;
                curr=curr.prev;
            }
            return pre.prev;
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
            ListNode newHead=ReverseaDLL(head);
            System.out.println("After reversing the doubly linked list");
            print(newHead);
            
    
        }
    }
    
