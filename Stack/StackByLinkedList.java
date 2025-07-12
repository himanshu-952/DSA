

public class StackByLinkedList {

    public static class Node{
        int data;
        Node next=null;
       public   Node(int data){
        this.data=data;
       } 
    }

    public class stack  {
    static Node head=null;

    public static boolean isempty(){

      return head==null;

    }

    public static void push(int data){
       Node newnode= new Node(data);
      if(isempty()){
       head=newnode;
        return;
      }
      else{
        newnode.next=head;
        head=newnode;
      }
    }

    public static int pop(){
       
        if(head==null){
            return -1;
        }
        int top= head.data;
    head=head.next;
    return top;
    }

    public static int peek(){
        if(isempty()){
            return -1;
        }

        else{
            return head.data;
        }
    }
  
    }

    public static void main(String[] args) {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while (!stack.isempty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
