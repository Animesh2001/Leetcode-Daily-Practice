class Solution {
    public int numSquares(int n) {
        int dp[]=new int[n+1];
        
        dp[0]=0;
        dp[1]=1;
        
        for(int i=2;i<n+1;i++){
            int min = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                int rem = i-j*j;
                if(min>dp[rem]){
                    min=dp[rem];
                }
            }
            dp[i]=min+1;
        }
        
        return dp[n];
    }
}