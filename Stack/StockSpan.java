import java.util.*;
public class StockSpan {

    public static int[] countspan(int arr[]){
        Stack<Integer> s=new Stack<>();
        s.push(0);
        int todayprice;
    
        int newarr[]=new int[arr.length];
        newarr[0]=1;
        int span;
        for(int i=1 ; i<arr.length ; i++){
            todayprice=arr[i];
            while(!s.empty()&&arr[s.peek()]<=todayprice){
                s.pop();
            }
            if(s.empty()){
                span=i+1;
                newarr[i]=span;
                s.push(i);
            }
            else{
                span=i-s.peek();
                newarr[i]=span;
                s.push(i);
            }

        }
        for (int i = 0; i < newarr.length; i++) {
            System.out.print(newarr[i] + " ");
        }
        return newarr;
       }
       


    public static void main(String[] args) {
        
        int arr[]={100 , 80 , 60 , 70 , 60 ,85 ,100};
   
        countspan(arr);
        
    }
}
