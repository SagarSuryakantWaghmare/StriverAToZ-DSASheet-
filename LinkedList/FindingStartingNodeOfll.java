import java.util.HashMap;

public class FindingStartingNodeOfll {
        public static class ListNode{
            int data;
            ListNode next;
            ListNode(int data){
                this.data=data;
    
            }
            ListNode(int data,ListNode next){
                this.data=data;
                this.next=null;
            }
        }
        // public static int startOfLoop(ListNode head){
        //     HashMap<ListNode,Integer> mp=new HashMap<>();
        //     ListNode temp=head;
        //     int index=0;
        //     while (temp!=null) {
        //         if(mp.containsKey(temp)){
        //             return temp.data;
        //         }
        //         mp.put(temp, index++);
        //         temp=temp.next;
        //     }
        //     return -1;
        // }

        // Tortoise and hear method
        public static int startOfLoop(ListNode head){
            // Detect in the loop
            ListNode slow=head;
            ListNode fast=head;
            while (fast!=null) {
                slow=slow.next;
                fast=fast.next.next;
                if(slow==fast){
                    slow=head;
                    return middle(slow,fast);
                }
            }
            // Finding the starting loop
            return -1;
        }
        public static int middle(ListNode slow,ListNode fast){
            while (slow!=fast) {
                slow=slow.next;
                fast=fast.next;
            }
            return slow.data;
        }
        
        public static void main(String[] args) {
            ListNode head=new ListNode(1);
            ListNode first=new ListNode(2);
            ListNode second=new ListNode(3);
            ListNode third=new ListNode(4);
            ListNode forth=new ListNode(5);
            ListNode fifth=new ListNode(6);
            head.next=first;
            first.next=second;
            second.next=third;
            third.next=forth;
            forth.next=fifth;
            fifth.next=second;
            System.out.println("Starting node of  the loop in LL:"+startOfLoop(head));
        }
    
}
