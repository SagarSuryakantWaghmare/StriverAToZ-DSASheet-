public class ConvertArrayIntoLinkedList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val,ListNode next,ListNode prev){
            this.val=val;
            this.next=null;
        }
    }
    public static void printList(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void convertToLL(int[]arr){
      ListNode head=new ListNode(arr[0]);
      ListNode temp=head;
      for(int i=1;i<arr.length;i++){
        ListNode node=new ListNode(arr[i]);
        temp.next=node;
        temp = temp.next;
      }
      printList(head);
      lengthOfLL(head);
    }
    public static void lengthOfLL(ListNode head){
        ListNode temp=head;
        int len=0;
        while (temp!=null){
            len++;
            temp=temp.next;
            
        }
        System.out.println(len);
    }
    


    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        convertToLL(arr);
    }
}