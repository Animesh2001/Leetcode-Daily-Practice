class Solution {
    public int change(int t, int[] arr) {
            int dp[][]=new int[arr.length][t+1];
            for(int i=0;i<=t;i++){
                if(i%arr[0]==0)dp[0][i]=1;
                else dp[0][i]=0;
            }

            for(int i=1;i<arr.length;i++){
                for(int j=0;j<=t;j++){
                   int pick=0;
                   if(arr[i]<=j){
                       pick=dp[i][j-arr[i]];
                   }

                   int notpick=dp[i-1][j];
                   dp[i][j]=pick+notpick;
                }
            }

            return dp[arr.length-1][t];
    }
}