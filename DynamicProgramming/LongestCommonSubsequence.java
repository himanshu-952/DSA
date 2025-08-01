import java.util.*;
public class LongestCommonSubsequence {

    public static int countLCS(String a , String b , int n , int m , int count){

        if(n<0 || m<0){
            return 0;
        }

        if(a.charAt(n)==b.charAt(m)){
            return count = 1+ countLCS(a, b, n-1, m-1, count);
        }
        else{
            return Math.max(countLCS(a, b, n, m-1, count), countLCS(a, b, n-1, m, count));
        }

    }

    // memoization

    public static int countLCSByMem(String a , String b , int n , int m ,int dp[][]){

        
        if(n<0 || m<0){
            return 0;
        }

        if(dp[n+1][m+1]!=-1){
            return dp[n+1][m+1];
        }

        if(a.charAt(n)==b.charAt(m)){
            return dp[n+1][m+1] = 1+ countLCSByMem(a, b, n-1, m-1, dp);
        }
        else{
            return dp[n+1][m+1]= Math.max(countLCSByMem(a, b, n, m-1, dp), countLCSByMem(a, b, n-1, m, dp));
        }

    }

    // by tabulation

    public static int countLCSByTab(String a , String b ){

        int dp[][]= new int[a.length()+1][b.length()+1];
        

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                
                // equal 
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                // not equal
                else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }
       return dp[a.length()][b.length()];
    }

    // variation - longest substring

    public static int longestSubstring(String a ,  String b){

        int dp[][]= new int[a.length()+1][b.length()+1] ;

        int max=0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=0;
                }

                if(dp[i][j]>max){
                    max= dp[i][j];
                }

            }
        }

        return max;
    }

    // longest increasing subsequece

    public static int longestIncreasingSubsequence(int arr[]){

      HashSet<Integer > hs= new HashSet<>();
      for (int i = 0; i < arr.length; i++) {
        hs.add(arr[i]);
      }

      int arr2[]= new int[hs.size()];
      int k=0;
      for (Integer set : hs) {
        arr2[k]=set;
        k++;
      }

      Arrays.sort(arr2);

     int dp[][]= new int[arr.length+1][arr2.length+1];

     for (int i = 1; i < dp.length; i++) {
        for (int j = 1; j < dp[0].length; j++) {
            if(arr[i-1]==arr2[j-1]){
                dp[i][j]=1+dp[i-1][j-1];
            }else{
                dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
     }
 return dp[arr.length][arr2.length];
    }

    // another variation is Edit Distance

    public static int editDistance(String a , String b){

        int dp[][] = new int[a.length()+1][b.length()+1];
        // Base case initialization
    for (int i = 0; i <= a.length(); i++) dp[i][0] = i;
    for (int j = 0; j <= b.length(); j++) dp[0][j] = j;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                
                //if equal characters

                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]= dp[i-1][j-1];
                }
                else{

                    
                    int add= 1+dp[i][j-1];
                    int delete=1+dp[i-1][j];
                    int replace=1+dp[i-1][j-1];

                    dp[i][j]=Math.min(add, Math.min(delete, replace));

                }

            }
        }
      return dp[a.length()][b.length()];
    }

    public static int shortcutForEditDistance(String a , String b){
        return Math.max(a.length(), b.length())-countLCSByTab(a, b);
    }

    public static void main(String[] args) {
        String s1="abcde";
        String s2= "ae";
        int dp[][ ]= new int[s1.length()+1][s2.length()+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }

        System.out.println(countLCS(s1, s2, s1.length()-1, s2.length()-1, 0));
       
        System.out.println(editDistance("intent", "content"));
        System.out.println(shortcutForEditDistance("intent", "content"));
    }
}
