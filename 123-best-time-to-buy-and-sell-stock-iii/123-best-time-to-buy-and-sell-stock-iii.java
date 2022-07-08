class Solution {
    
    public int f(int ind,int buy,int cap,int []arr,int [][][]dp){
        if(cap==0)return 0;
        if(ind==arr.length)return 0;
        if(dp[ind][buy][cap]!=-1)return dp[ind][buy][cap];
        int profit=0;
        if(buy==1){
            profit = Math.max(-arr[ind]+f(ind+1,0,cap,arr,dp),f(ind+1,1,cap,arr,dp));
        }else{
            profit = Math.max(arr[ind]+f(ind+1,1,cap-1,arr,dp),f(ind+1,0,cap,arr,dp));
        }
        return dp[ind][buy][cap]=profit;
    }
    
    public int maxProfit(int[] prices) {
        int dp[][][]=new int[prices.length][2][3];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return f(0,1,2,prices,dp);
    }
}