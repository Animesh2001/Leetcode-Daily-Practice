class Solution {
    
    public int lis(int ind,int prev_ind,int nums[],int dp[][]){
        if(ind==nums.length)return 0;
        if(dp[ind][prev_ind+1]!=-1)return dp[ind][prev_ind+1];
        //not take
        int nottake=lis(ind+1,prev_ind,nums,dp);
        
        int take=0;
        if(prev_ind==-1||nums[ind]>nums[prev_ind]){
            take= 1+lis(ind+1,ind,nums,dp);
        }
        return dp[ind][prev_ind+1]= Math.max(nottake,take);
    }
    
    
    public int lengthOfLIS(int[] nums) {
        int dp[][]=new int[nums.length+1][nums.length+1];
        for(int rows[]:dp)Arrays.fill(rows,-1);
        return lis(0,-1,nums,dp);
    }
}