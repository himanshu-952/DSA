public class coinChange {

    // coin change is a variation of unbounded knapsack

    public static int countWays(int coin[]  , int change){
        int dp[][]= new int[coin.length+1][change+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[1].length; j++) {
                
                // valid
                if(coin[i-1]<=j){
                  
                    // include+exclude
                    dp[i][j]=dp[i][j-coin[i-1]]+dp[i-1][j];

                }
                else{
                    dp[i][j]= dp[i-1][j];
                }


            }
        }

        return dp[coin.length][change];
        
    }

    public static void main(String[] args) {
        int coin[]={1,2,3};
        int change=4;
        System.out.println(countWays(coin, change));
    }
}
