public class TilingProblem {

    public static int countWays(int n , int dp[]){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n]!=0){
        return dp[n];
        }
        return dp[n]=countWays(n-1, dp)+countWays(n-2, dp);
    }

    public static void main(String[] args) {
        System.out.println(countWays(3, new int[4]));
    }
}
