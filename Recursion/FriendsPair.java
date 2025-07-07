public class FriendsPair {

    public static int solution(int n , int dp[]){
        if(n==0 || n==1){
            return 1;
        }

        if(dp[n]!=0){
            return dp[n];
        }
         
        return dp[n]= solution(n-1 , dp)+(n-1)*solution(n-2 , dp);
    }

    public static void main(String[] args) {
        System.out.println(solution(2 , new int[3]));
    }
}
