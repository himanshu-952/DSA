public class Powxn {
     class Solution{
      public double myPow(double x, int n){
        double dp[]= new double[n+1];
        dp[0]=1;
        dp[1]=x;
        for (int i = 2; i <= dp.length; i++) {
            if(n%2==0){
                dp[i]=dp[n/2]*dp[n/2];
            }
            else{
                dp[i]=x*dp[n/2]*dp[n/2];
            }
        }
        return dp[n];
      }
    }
}
