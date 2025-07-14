import java.util.*;
public class ActivitySelection {
    public static int MaxActivity(int st[] , int[] end){
      
        // create 2d array
      int  activities[][]= new int[st.length][3];

      for (int i = 0; i < activities.length; i++) {
        activities[i][0]=i;
        activities[i][1]=st[i];
        activities[i][2]=end[i];
      }

      // sort using comparators
      Arrays.sort(activities , Comparator.comparingDouble(o->o[2])); 

      //writing main code
      int Maxact=1;
      int lastend=activities[0][2];

      for (int i = 1; i < activities.length; i++) {
         if(activities[i][1]>=lastend){
            Maxact++;
            lastend=activities[i][2];
         }
      }
  return Maxact;

    }
    public static void main(String[] args) {
        int[] start={0,1,3,5,8};
        int[] end=  {6,2,4,9,9};
        System.out.println(MaxActivity(start, end));
    }
}
