import java.util.*;
public class FractionalKnapsack {
    
    public static void knapsackfill(int[]v , int[]w ,int maxcap){

        double capacity=maxcap;
        double maxvalue=0;
        ArrayList<Integer> items= new ArrayList<>();

        // sorting part
        double [][] cheakratio=new double[v.length][2];
       for (int i = 0; i < cheakratio.length; i++) {
           cheakratio[i][0]=i;
           cheakratio[i][1]=(double)v[i]/w[i];
       }

      Arrays.sort(cheakratio, (a, b) -> Double.compare(b[1], a[1]));

        for(int i=0 ; i<v.length ; i++){
            int index=(int) cheakratio[i][0];
            if(capacity==0){
                break;
            }
            if(capacity>=w[index]){
                maxvalue+=v[index];
                capacity-=w[index];
                items.add(index);
            }
            else{
                maxvalue+=(double)(v[index]/w[index])*(capacity);
                capacity-=w[index]-capacity;
                 items.add(index);
            }
        }
        while (!items.isEmpty()) {
             System.out.print(" add item : " + items.remove(0));
             System.out.println();
        }
  System.out.println(maxvalue);
    }

    public static void main(String[] args) {
        int [] value ={  100 , 120 ,60};
        int[]  weight={20,30 ,10};
        int maxcapacity=50;
        knapsackfill(value, weight, maxcapacity);
    }
}
