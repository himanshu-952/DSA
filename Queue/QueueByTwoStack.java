import java.util.*;
public class QueueByTwoStack {
    public static class Queue{

      static  Stack<Integer> a=new Stack<>();
        static Stack<Integer> b=new Stack<>();

        public  void add(int data){
         if(a.empty()){
            a.push(data);
         }  
         else{
            while(!a.empty()){
                b.push(a.pop());
                
            }
            a.push(data);
            while(!b.empty()){
                a.push(b.pop());
                
            }
         }
        }
        public boolean empty(){
            return a.empty();
        }

        public  int peek(){
           if(a.empty()){
            System.out.println("empty");
            return -1;
           }
           else{
            return a.peek();
           }
        }

        public  int remove(){
            if(a.empty()){
                return -1;
            }
            else{
                return a.pop();
            }
        }
        
       

    }
public static void main(String[] args) {
    Queue q=new Queue();
    q.add(1);
    q.add(2);
    q.add(3);
    
     while(!q.empty()){
                System.out.println(q.remove());
             }

    
}
}
