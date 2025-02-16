public class StackUsingLL {
    public static class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data=data;
            this.next=null;
        }

    }
    public static class Stack{
        ListNode top;
        int size=0;
        void push(int x){
            ListNode newNode=new ListNode(x);
            newNode.next=top;
            top=newNode;
            size++;
        }
        int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            int val=top.data;
            top=top.next;
            size--;
            return val;

        }
        int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            int val=top.data;
            return val;
        }
        int getSize(){
            return size;
        }
        boolean isEmpty(){
            return size==0;
        }
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop()); // Output: 30
        System.out.println(stack.peek()); // Output: 20
        System.out.println(stack.getSize()); // Output: 2
    }
    
}
