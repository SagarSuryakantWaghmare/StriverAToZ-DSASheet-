import java.util.Stack;

public class PalindromeLL {
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

    //    extra space:O(n)
    // Time complexity:O(2n)
    //    public static boolean isPalindrome(ListNode head){
    //     Stack<Integer> st=new Stack<>();
    //     ListNode temp=head;
    //     while (temp!=null) {
    //         st.push(temp.data);
    //         temp=temp.next;
    //     }
    //     temp=head;
    //     while (!st.isEmpty()) {
    //         int data=st.pop();
    //         if(temp.data!=data){
    //             return false;
    //         }
    //         temp=temp.next;
    //     }
    //     return true;
    //    }
    public static ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode pre=null;
        ListNode front=null;
        while (curr!=null) {
            front=curr.next;
            curr.next=pre;
            pre=curr;
            curr=front;
        }
        return pre;
    }
    public static boolean isPalindrome(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while (fast.next!=null&&fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode newNode=reverse(slow.next);
        ListNode first=head;
        ListNode second=newNode;
        while (second!=null) {
            if(first.data!=second.data){
                return false;
            }
            first=first.next;
            second=second.next;
        }
        slow.next=reverse(newNode);
      return true;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
             ListNode first=new ListNode(2);
             ListNode second=new ListNode(3);
             ListNode third=new ListNode(2);
             ListNode forth=new ListNode(1);
             head.next=first;
             first.next=second;
             second.next=third;
             third.next=forth;
             forth.next=null;
             printList(head);
             System.out.println("Given linked list is palindrome :"+isPalindrome(head));
        //     ListNode newNode =reverse(head);
        // printList(newNode);
      
           }
}
