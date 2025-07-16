import java.util.*;
public class connectRopes {

    public static int costToConnect(int arr[]){

        PriorityQueue<Integer> pq= new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        int totalcost=0;

        while(pq.size()!=1){
            int min1= pq.remove();
            int min2= pq.remove();

            

            totalcost+=min1+min2;

            pq.add(min1+min2);

           
        }

          System.out.println(totalcost);

            return totalcost;

    }

    public static void main(String[] args) {
        
   int arr[]= new int[4];

   for (int i = 0; i < arr.length; i++) {
    System.out.println("Enter element " +(i+1));
       Scanner sc=new Scanner(System.in);
       arr[i]=sc.nextInt();
   }



        costToConnect(arr);

    }
}
