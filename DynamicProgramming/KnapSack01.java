public class KnapSack01 {

    // recursion

    public static int maxProfByRecursion(int item[][], int r ,  int kw  ){

       if(r==item.length|| kw==0){
        return 0;
       }

       if(item[r][1]>kw){

        return  maxProfByRecursion(item,  r+1, kw);

  
       }

       else{

            int include=item[r][0]+ maxProfByRecursion(item , r+1, kw-item[r][1]);
            int exclude= maxProfByRecursion(item ,  r+1, kw);

        return Math.max(include, exclude);

       }

       

    }

    // By Memoization

    public static int maxProfByMem(int item[][], int r ,  int kw ,int dp[][]){

          if(r==item.length|| kw==0){
        return 0;
       }

       if(dp[r][kw]!=-1){
        return dp[r][kw];
       }

       if(item[r][1]>kw){

       return dp[r][kw]=  maxProfByMem(item,  r+1, kw , dp);

  
       }

       else{

            int include=item[r][0]+ maxProfByMem(item , r+1, kw-item[r][1] , dp);
            int exclude= maxProfByMem(item ,  r+1, kw , dp);

        return dp[r][kw]= Math.max(include, exclude);

       }


    }

    public static int maxProfByTab(int item[][] , int kw){

       int dp[][]= new int[item.length+1][kw+1];
       int maxprofit=0;
       for (int i = 0; i < dp.length; i++) {
        dp[i][0]=0;
       }

       for (int i = 0; i < dp[0].length; i++) {
        dp[0][i]=0;
       }

       for (int i = 1; i < dp.length; i++) {
        for (int j = 1; j < dp[0].length; j++) {
            
            int val=item[i-1][0];
            int wt= item[i-1][1];

            if(wt<=j){

                //include
            dp[i][j]=Math.max(val+dp[i-1][j-wt], dp[i-1][j]);
            if(dp[i][j]>maxprofit){
                maxprofit=dp[i][j];
            }

            }

            else{

                // exclude
                dp[i][j]=dp[i-1][j];
                if(dp[i][j]>maxprofit){
                maxprofit=dp[i][j];
            }

            }

        }
       }

       return maxprofit;

    }


    // variation of 01 knapsack is targetSumSubset

    public static boolean targetSum(int n[] , int k){

        boolean dp[][]= new boolean[n.length+1][k+1];
            for (int i = 0; i < dp.length; i++) {
                dp[i][0]=true;
            }
        
            for (int i = 1; i < dp.length; i++) {
             
                for (int j = 1; j < dp[0].length; j++) {

                   
                    
                    // include
                    if(n[i-1]<=j){

                        boolean include=dp[i-1][j-n[i-1]];
                         boolean exclude = dp[i-1][j];
                         dp[i][j]=include | exclude;
                    }

                    else{
                    // exclude

                   dp[i][j] = dp[i-1][j];

                    
                    }

                }
                
            }
        
return dp[n.length][k];
    }

     public static int unboundedKnapsack(int item[][] , int kw){

       int dp[][]= new int[item.length+1][kw+1];
       int maxprofit=0;
       for (int i = 0; i < dp.length; i++) {
        dp[i][0]=0;
       }

       for (int i = 0; i < dp[0].length; i++) {
        dp[0][i]=0;
       }

       for (int i = 1; i < dp.length; i++) {
        for (int j = 1; j < dp[0].length; j++) {
            
            int val=item[i-1][0];
            int wt= item[i-1][1];

            if(wt<=j){

                //include
            dp[i][j]=Math.max(val+dp[i][j-wt], dp[i-1][j]);
            if(dp[i][j]>maxprofit){
                maxprofit=dp[i][j];
            }

            }

            else{

                // exclude
                dp[i][j]=dp[i-1][j];
                if(dp[i][j]>maxprofit){
                maxprofit=dp[i][j];
            }

            }

        }
       }

       return maxprofit;

    }

    

    public static void main(String[] args) {
        int intem[][]={{15 , 2}, {14,5},{10,1}, {45,3}, {30,4}};
        System.out.println(maxProfByRecursion(intem,  0, 7));

        int dp[][] = new int[intem.length+1][8];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }

        int n[]={4,7,1,3,5};

        System.out.println(maxProfByMem(intem, 0, 7, dp));

        System.out.println(maxProfByTab(intem, 7));

        System.out.println(targetSum(n, 100));

        System.out.println(unboundedKnapsack(intem, 7));
       
    }
}
