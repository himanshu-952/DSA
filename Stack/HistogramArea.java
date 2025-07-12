import java.util.*;
public class HistogramArea {

    public static int maxarea(int arr[]){
        Stack<Integer> s= new Stack<>();
      
       int maxarea=0;
       int currentarea;
       int[] leftend=new int[arr.length];
      int[] rightend=new int[arr.length];
     
      for (int i = arr.length-1; i>=0; i--) {
        while(!s.empty()&&arr[s.peek()]>=arr[i]){
            s.pop();
        }
        if(s.empty()){
            rightend[i]=arr.length;
        }
        else{
            rightend[i]=s.peek();
            
        }
        s.push(i);
      }
s=new Stack<>();
      for (int i = 0; i < arr.length; i++) {
         while(!s.empty()&&arr[i]<=arr[s.peek()]){
            s.pop();
         }
        
         if(s.empty()){
            leftend[i]=-1;
          }
          else{
            leftend[i]=s.peek();
          }
          s.push(i);
      }
      for (int i = 0; i < rightend.length; i++) {
        int curr=arr[i];
        currentarea=(rightend[i]-leftend[i]-1)*curr;
        maxarea=Integer.max(currentarea, maxarea);
      }
      
return maxarea;
       }
    
    


    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3};
        System.out.println(maxarea(arr));
    }

}