import java.util.*;
public class SlidingWindow {

    static class data implements Comparable<data>{
        int value , idx;

        public data(int val , int idx){
            this.value=val;
            this.idx=idx;
        }

        @Override
        public  int compareTo(data b){
            return b.value- this.value;
        }

    }

    public static void main(String[] args) {
        
        int arr[]={5 ,7 ,-1 ,4 ,3};

        int k=3;
        int res[]= new int[arr.length-k+1];
        PriorityQueue<data> pq= new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
           pq.add(new data(arr[i], i));
            
        }

        res[0]=pq.peek().value;

        for (int i = k; i < arr.length; i++) {
         
            while(pq.size()>0 && pq.peek().idx<=i-k){
                pq.remove();
            }

            pq.add(new data(arr[i], i));

            res[i-k+1]=pq.peek().value;


            
        }

        for (int i = 0; i < res.length; i++) {
              System.out.print(res[i]+" ");
        }

    }
}
