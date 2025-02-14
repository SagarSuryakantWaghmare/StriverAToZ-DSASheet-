import java.util.HashMap;

public class FindLengthInLoopLL {
    public static class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }
    // Using hash and O(n) time
    // public static int lengthOfLoop(ListNode head){
    //     HashMap<ListNode,Integer> mp=new HashMap<>();
    //     ListNode temp=head;
    //     int index = 0;
    //     while (temp != null) {
    //         if (mp.containsKey(temp)) {
    //             return index - mp.get(temp);
    //         }
    //         mp.put(temp, index);
    //         temp = temp.next;
    //         index++;
    //     }
    //     return -1;
    // }

    // Opitmal solution
    // Tortoise and hare algorithm
    // Slow and fast pointer method
    public static int lengthOfLoop(ListNode head){
        //we just have to traverse and just when  
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return findLength(slow,fast);
        }
        return -1;

    }
    public static int findLength(ListNode slow,ListNode fast){
        int count=1;
        fast=fast.next;
        while (slow!=fast) {
            count++;
            fast=fast.next;
        }
        return count;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        System.out.println(lengthOfLoop(head));
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = third; 
        System.out.println(lengthOfLoop(head));

       
    }
}
