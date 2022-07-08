class Solution {
    
    public int f(int ind,int prev_ind,int []nums,int n,int [][]dp){
        if(ind==n)return 0;
        if(dp[ind][prev_ind+1]!=-1)return dp[ind][prev_ind+1];
        //not take
       int len = f(ind+1,prev_ind,nums,n,dp);
        
        //take
        if(prev_ind==-1||nums[ind]>nums[prev_ind]){
            len = Math.max(len,1+f(ind+1,ind,nums,n,dp));
        }
        return dp[ind][prev_ind+1]=len;
    }
    
    public int lengthOfLIS(int[] nums) {
        int dp[][]=new int[nums.length][nums.length+1];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return f(0,-1,nums,nums.length,dp);
    }
}