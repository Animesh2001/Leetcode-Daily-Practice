class Solution {
    
    public int f(int ind,int buy,int []arr,int dp[][]){
        if(ind>=arr.length)return 0;
        int profit=0;
        if(dp[ind][buy]!=-1)return dp[ind][buy];
        if(buy==1){
            profit = Math.max(-arr[ind]+f(ind+1,0,arr,dp),f(ind+1,1,arr,dp));
        }else{
            profit = Math.max(arr[ind]+f(ind+2,1,arr,dp),f(ind+1,0,arr,dp));
            
        }
        return dp[ind][buy]= profit;
    }
    
    public int maxProfit(int[] prices) {
        int dp[][]=new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return f(0,1,prices,dp);
    }
}