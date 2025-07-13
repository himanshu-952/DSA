import java.util.*;
import java.util.LinkedList;
public class StackByTwoQueue {
    public static class stack{

        Queue<Integer> a= new LinkedList<>();
        Queue<Integer> b= new LinkedList<>();
        
        public boolean empty(){
             return a.isEmpty();
        }

        public void add(int data){
            while(!a.isEmpty()){
                b.add(a.remove());
            }
            a.add(data);
            while(!b.isEmpty()){
                a.add(b.remove());
            }

        }

        public int remove(){
            if(empty()){
                return -1;
            }
            else{
                return a.remove();
            }
        }
        public int peek(){
            if(empty()){
                return -1;
            }
            else{
                return a.peek();
            }
        }


    }
    public static void main(String[] args) {
        stack s= new stack();
        s.add(1);
        s.add(2);
        s.add(3);

        while(!s.empty()){
            System.out.println(s.remove());
        }
    }
}
