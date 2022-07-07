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
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
         int dp[][]=new int[n][2];
        
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        
      return f(0,1,n,prices,dp);
    }
}