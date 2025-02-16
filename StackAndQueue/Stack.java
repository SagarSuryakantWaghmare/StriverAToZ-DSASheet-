// Stack 
/*
 * What is Stack?
 * Stack is LIFO data Structure
 * LIFO Stands from the last in first out.
 * Implement using array
 */
public class Stack {
    public static class StackImplementUsingArray{
        int[]array=new int[10];
        int total=10;
        int length=0;
        int size=0;
        public void push(int val){
            array[length]=val;
            length++;
            size++;
        }
        public int pop(){
            int val=array[size-1];
            length--;
            size--;
            return val;
        }
        public  int size(){
            return size;
        }
        public  boolean isEmpty(){
            return size==0;
        }
        public  boolean isFull(){
            return size==total;
        }
        public void printArray(){
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        StackImplementUsingArray st=new StackImplementUsingArray();
        st.push(1);
        st.push(6);
        st.push(8);
        st.push(20);
        st.push(3);
        st.printArray();
        System.out.println(st.pop());
        System.out.println(st.size());
        System.out.println(st.isEmpty());
        System.out.println(st.isFull());
    }
}