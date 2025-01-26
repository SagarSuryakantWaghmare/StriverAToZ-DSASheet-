

public class MiddleOfTheLL {
    public  static class ListNode{
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
    public static int countNode(ListNode head){
        int count=0;
        ListNode temp=head;
        while (temp!=null) {
            temp=temp.next;
            count++;
        }
        return count;
    }
    // public static int middleNode(ListNode head){
    //     int count=countNode(head);
    //     int middleElement=(count/2)+1;
    //     ListNode temp=head;
    //     while (temp!=null) {
    //         middleElement--;
    //         if(middleElement==0){
    //             break;
    //         }
    //         temp=temp.next;
    //     }
    //     return temp.data;
    // }
    //optimize solution
    public static int middleNode(ListNode head){
        if(head==null||head.next==null) return head.data;
      ListNode slow=head;
      ListNode fast=head;
      while (fast!=null&&fast.next!=null) {
        slow=slow.next;
        fast=fast.next.next;
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
        fifth.next=null;
        System.out.println("Middle element in the given linked list :"+middleNode(head));
    }
}
