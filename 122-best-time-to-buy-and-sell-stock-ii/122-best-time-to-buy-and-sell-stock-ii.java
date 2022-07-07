class Solution {
    
    public static int f(int ind,int buy,int n,int []arr,int dp[][]){
        if(ind==n)return 0;
        if(dp[ind][buy]!=-1)return dp[ind][buy];
        int profit = 0;
        
        //you can buy
        if(buy==1){
            profit = Math.max(-arr[ind]+f(ind+1,0,n,arr,dp),0+f(ind+1,1,n,arr,dp));
        }else{
            profit = Math.max(arr[ind]+f(ind+1,1,n,arr,dp),0+f(ind+1,0,n,arr,dp));
        }
        return dp[ind][buy]=profit;
    }
    
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int dp[][]=new int[n+1][2];
     
        dp[n][0]=0;
        dp[n][1]=0;
        
         for(int i=n-1;i>=0;i--){
             for(int j=0;j<2;j++){
                 if(j==1){
                     dp[i][j]=Math.max(-arr[i]+dp[i+1][0],dp[i+1][1]);
                 }else{
                     dp[i][j]=Math.max(arr[i]+dp[i+1][1],dp[i+1][0]);
                 }
             }
         }
        
        return dp[0][1];
        
        
    }
}