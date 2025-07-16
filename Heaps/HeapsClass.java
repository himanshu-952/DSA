
import java.util.*;

public class HeapsClass {

    static class Heap {
        static ArrayList<Integer> list = new ArrayList<>();
        static ArrayList<Double> listofdouble= new ArrayList<>();

        public static void insert(int data) {
            list.add(data); 
            int child = list.size() - 1;
            int parent = (child - 1) / 2;

           
            while (parent >= 0 && list.get(child) < list.get(parent)) {
                int temp = list.get(child);
                list.set(child, list.get(parent));
                list.set(parent, temp);

                child = parent;
                parent = (child - 1) / 2;
            }
        }

        public static int peek(){
            return list.get(0);
        }

        public static int deleteheap(){
            int temp=list.get(list.size()-1);
            list.set(list.size()-1  , list.get(0));
            list.set(0 , temp);
        int heap=     list.remove(list.size()-1);

        heapify(0);

        return heap;

        }

        private static void heapify(int curr){

            int left=2*(curr)+1;
            int right=2*(curr)+2;
            int min= curr;

           
           if(left<list.size() && list.get(left)<=list.get(min)){
            min=left;
           }
           if(right<list.size() && list.get(right)<list.get(min)){
            min =right;
           }
            
           if(min!=curr){
            int temp = list.get(min);
            list.set(min, list.get(curr));
            list.set(curr, temp);

            heapify(min);
           }


            

        }

         private static void heapifyMax(int curr , int size){

            int length=size;
            int left=2*(curr)+1;
            int right=2*(curr)+2;
            int min= curr;

           
           if(left<length && list.get(left)>list.get(min)){
            min=left;
           }
           if(right<length && list.get(right)>list.get(min)){
            min =right;
           }
            
           if(min!=curr){
            int temp = list.get(min);
            list.set(min, list.get(curr));
            list.set(curr, temp);

            heapifyMax(curr, size);
           }
        }

        public static void heapSort(){
            for(int i=list.size()/2 ; i>=0 ; i--){
                heapifyMax(i, list.size()-1);
            }

          
        for(int i=list.size()-1 ; i>=0 ;i-- ){
        
        
           swap(0,i);
          heapifyMax(0, i);

        }



        }

        public static void swap(int a , int b){
            int temp=list.get(a);
             list.set(a , list.get(b));
             list.set(b, temp);
        }

        public static int kNeareast(int cars[][]){

         for(int i=0 ; i<cars.length ; i++){
            double dist= Math.sqrt(Math.pow(cars[i][0], 2)+Math.pow(cars[i][1], 2));
            list.add((int)dist);
         }

         heapify(0);

         System.out.println("Nearest car is at "+Heap.peek()+" distance.");

         return Heap.peek();

        }

        public static void printHeap() {
            System.out.println(list);
        }
    }

    public static void main(String[] args) {

        int cars[][]={
            {3,3},
            {5,-1},
            {-2,4}
        };
       
      Heap.kNeareast(cars);
        
        
      
    }
}
