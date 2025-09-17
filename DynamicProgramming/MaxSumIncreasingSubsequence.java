package DynamicPrograming;

public class MaxSumIncreasingSubsequence {
    class Solution {
    public int maxSumIncreasingSubsequence(int[] arr, int n) {
          int dp[]= new int[n];
          dp[0]=arr[0];
          
          int maxSum=0;
          for(int i=1; i<dp.length; i++){
            int currSum=arr[i];
             for(int j=0 ; j<i ; j++){
                // valid
                if(arr[i]>arr[j]){
                   currSum+=arr[j];
                }
             }
             maxSum=Math.max(currSum , maxSum);
          }
          return maxSum;
    }
}
}
