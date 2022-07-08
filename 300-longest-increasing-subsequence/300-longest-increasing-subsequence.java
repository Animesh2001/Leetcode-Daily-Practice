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
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
      
        
        for(int i = n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                 int len = dp[i+1][j+1];
                if(j==-1||nums[i]>nums[j]){
                len = Math.max(len,1+dp[i+1][i+1]);
        }
          dp[i][j+1]=len;
        }
        }
        return dp[0][0];
    }
}