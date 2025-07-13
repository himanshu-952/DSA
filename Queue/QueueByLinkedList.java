

public class QueueByLinkedList {

    public static class Node{
        int data;
        Node next=null;

        Node(int data){
            this.data=data;
        }
    }

    public static Node front;
    public static Node rear;

    public static boolean isempty(){
        return front==null&&rear==null;
        }

    public static void enque(int data){
        Node newNode=new Node(data);

        if(isempty()){
            front=rear=newNode;
        }
        else{
            rear.next=newNode;
            rear=newNode;
        }
    }

    public static int deque(){
        if(isempty()){
            System.out.println("empty");
            return -1;
        }
        if(front==rear){
            int result=front.data;
            front=rear=null;
            return  result;
        }
        int result=front.data;
        front=front.next;
        return result;
    }

    public static int peek(){
    if(isempty()){
        System.out.println("empty");
        return -1;
    }
    return front.data;
}


    public static void print(){
        Node pointer=front;
        while(pointer!=null){
            System.out.print(pointer.data+" ");
            pointer=pointer.next;
        }
    }

    public static void main(String[] args) {
        enque(1);
        enque(2);
        enque(3);
        deque();
        
        print();
        
    }
}
