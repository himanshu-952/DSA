import java.util.*;
public class CWMW {
    
    public static int maxwater(ArrayList<Integer> list){

        int h1=0 , h2=list.size()-1, widhth ,   area ,maxarea=0;
       while (h1<h2) {
        widhth=h2-h1;
        area = Math.min(list.get(h1), list.get(h2)) * widhth;

        if(area>maxarea){
            maxarea=area;
        }
        if(list.get(h1)<list.get(h2)){
         h1++;
        }
           else{
            h2--;
        }
       }
     return maxarea ;
      

    }
    
    public static void main(String[] args) {
        ArrayList<Integer> tower= new ArrayList<>();
        tower.add(1);
        tower.add(8);
        tower.add(6);
        tower.add(2);
        tower.add(5);
        tower.add(4);
        tower.add(8);
        tower.add(3);
        tower.add(7);
        System.out.println(maxwater(tower));

    }
}
