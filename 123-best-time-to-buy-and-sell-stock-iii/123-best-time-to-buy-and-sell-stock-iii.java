class Solution {
    
    public int profit(int ind,int number,int buy,int []prices,int dp[][][]){
        if(ind==prices.length)return 0;
        if(number==0)return 0;
        if(dp[ind][number][buy]!=-1)return dp[ind][number][buy];
        int maxprofit=0;
        if(buy==1){
            maxprofit= Math.max(-prices[ind]+profit(ind+1,number,0,prices,dp),0+profit(ind+1,number,1,prices,dp));
        }
        else{
            maxprofit= Math.max(+prices[ind]+profit(ind+1,number-1,1,prices,dp),0+profit(ind+1,number,0,prices,dp));
        }
        return dp[ind][number][buy]= maxprofit;
    }    
    
    public int maxProfit(int[] prices) {
        int dp[][][]=new int[prices.length][3][2];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<2;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return profit(0,2,1,prices,dp);
    }
}