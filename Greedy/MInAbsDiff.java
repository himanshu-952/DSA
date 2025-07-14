import java.util.Arrays;

public class MInAbsDiff {
    public static int minabsdiff(int[]a,int[]b){
        Arrays.sort(a);
        Arrays.sort (b);
        int diff=0;
        for(int i=0 ; i<a.length;i++){
            diff+=Math.abs(a[i]-b[i]);
     
        }
              return diff;
    }
    public static void main(String[] args) {
        int[] a={4 ,8 ,01 , 5};
        int[] b={3,2,6,5}; 
        System.out.println(minabsdiff(a, b));
    }
}
