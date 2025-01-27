public class DetectLoopInLL {
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
    // Tortoise and hare algorithm
    public static boolean detectLL(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
        
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
        System.out.println("Detect the loop in LL:"+detectLL(head));
    }
}
