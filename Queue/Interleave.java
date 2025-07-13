import java.util.*;
import java.util.LinkedList;

public class Interleave {

    public static Queue inter(Queue<Integer> q){
        int n=q.size();

        Queue <Integer> q1= new LinkedList<>();
        for(int i=0 ; i<n/2; i++){
           q1.add(q.peek());
           q.remove();
        }
        while(!q1.isEmpty()){
            q.add(q1.remove());
           
            q.add(q.remove());
            
        }
        return q;

    }
    public static void main(String[] args) {
        Queue<Integer> q= new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        inter(q);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
