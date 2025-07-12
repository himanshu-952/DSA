import java.util.*;
public class NexrGreaterelement {

    public static int[] greater(int arr[]){
        int newarr[]= new int[arr.length];
        Stack<Integer> s= new Stack<>();

       for (int i =arr.length-1; i >=0; i--) {
        while(!s.empty() && arr[s.peek()]<=arr[i]){
            s.pop();
         }
         if(s.empty()){
             newarr[i]=-1;
             
         }
         else{
             newarr[i]=arr[s.peek()];
             
         }
         s.push(i);
       }
       for (int i = 0; i < newarr.length; i++) {
        System.out.print(newarr[i]);
       }
       return newarr;
    }

    public static void main(String[] args) {
        int arr[]={6,7 ,0 ,8 ,3 ,5};
        greater(arr);
    }
}
