import javax.naming.NameAlreadyBoundException;

public class AddOneToLL {
    public static class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static void print(ListNode head){
        ListNode temp=head;
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode front=null;
        while (curr!=null) {
            front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }
        return prev;
    }
    // O(3n )
    // public static ListNode addOne(ListNode head){
    //  head= reverse(head);
    //  ListNode temp=head;
    //  int carry=1;
    //  while (temp!=null) {
    //     temp.data=temp.data+carry;
    //     if(temp.data<10){
    //         carry=0;
    //         break;
    //     }
    //     else{
    //         temp.data=0;
    //         carry=1;
    //     }
    //     temp=temp.next;
    //  }
    //  if(carry==1){
    //     ListNode newN=new ListNode(1);
    //     head=reverse(head);
    //     newN.next=head;
    //     return newN;
    //  }
    //  head=reverse(head);
    //   return head;
    // }
    public static int helper(ListNode temp){
        if(temp==null){
            return 1;
        }
        int carry = helper(temp.next);
        int sum = temp.data + carry;
        temp.data = sum % 10;
        return sum / 10;
    }
    public static ListNode addOne(ListNode head){
        int carry=helper(head);
        if(carry==1){
            ListNode newNode=new ListNode(1);
            newNode.next=head;
            return newNode;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(9);
        head.next=new ListNode(9);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(9);
        print(head);
        ListNode newNode=addOne(head);
        print(newNode);
    }
}
