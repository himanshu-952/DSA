import java.util.*;

public class Chocola {
    public static int mincost(Integer[]h , Integer[]v){
     Arrays.sort(v , Comparator.reverseOrder());
     Arrays.sort(h , Comparator.reverseOrder());
    


     int vercut=1;
     int horcut=1;
     int result=0;
     int Htrack =0;
     int Vtrack=0;

     
     while(Htrack<h.length && Vtrack<v.length){
        if(h[Htrack]>=v[Vtrack]){
            result+=h[Htrack]*vercut;
            horcut++;
            Htrack++;
        }
        else{
            result+=v[Vtrack]*horcut;
            vercut++;
            Vtrack++;
        }
     }

     while(Htrack<h.length){
         result+=h[Htrack]*vercut;
            horcut++;
            Htrack++;
     }

     while(Vtrack<v.length){
         result+=v[Vtrack]*horcut;
            vercut++;
            Vtrack++;
     }

     System.out.println(result);
     return result;

     }
     

    
    public static void main(String[] args) {
        Integer[] vert={2,1,3,1,4};
        Integer[] hor={4,1,2};
        mincost(hor, vert);
    }
}
