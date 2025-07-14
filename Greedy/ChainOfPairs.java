import java.util.*;
public class ChainOfPairs {
    public static int countpairs(int[][] pair){
       
        int count=1;

        //sort
        Arrays.sort(pair ,Comparator.comparingInt(o->o[1]));
        int last=pair[0][1];
       int i=1;
       while(i<pair.length){
               if(pair[i][0]>last){
                count++;
                 last=pair[i][1];
               }
               i++;
       }
return count;
    }
    public static void main(String[] args) {
        int[][] pairs={ {5,24},{39,60},{2,85},{27,40},{50,90}};
        System.out.println(countpairs(pairs));
    }
}
