class Solution {
    
    public int profit(int ind,int []prices,int buy,int dp[][]){
        //base case
        if(ind==prices.length)return 0;
        
        int profit=0;
        if(dp[ind][buy]!=-1)return dp[ind][buy];
        
        //recursive calls & small calculations
        if(buy==1){
            profit=Math.max(-prices[ind]+profit(ind+1,prices,0,dp),0+profit(ind+1,prices,1,dp));
        }
        else{
            profit=Math.max(prices[ind]+profit(ind+1,prices,1,dp),0+profit(ind+1,prices,0,dp));
        }
        
        //return the maxprofit
        return dp[ind][buy]= profit;
    }
    
    
    public int maxProfit(int[] prices) {
        int dp[][]=new int[prices.length][2];
        for(int rows[]:dp)Arrays.fill(rows,-1);
        return profit(0,prices,1,dp);
    }
}