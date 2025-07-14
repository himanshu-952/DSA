import java.util.ArrayList;

public class IndianCoins {

    public static int countchange(int value){
        int denominations[]={1,2,5,10,20,50,100,500};
        int count=0;
        ArrayList<Integer> a= new ArrayList<>();
        
         for (int j =  denominations.length-1; j>=0; ) {
            if(value==0){
                break ;
            }
              if(value<denominations[j]){
                j--;
              }
              else if (value>=denominations[j]) {
                value-=denominations[j];
                count++;
                a.add(denominations[j]);
                
              }
         }
         System.out.print("currency required = ");
         for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i)+" + ");
         }
         System.out.print("0");
         System.out.println();
         System.out.println("count =" + count);
        return count;
    }

    public static void main(String[] args) {
        countchange(10336);
    }
}
