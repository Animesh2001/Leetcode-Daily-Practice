class Solution {
    
    public int findSubset(int n,int []nums,int target,int[][]dp){
       if(n==0){
           if(target==nums[0])return 1;
           else return 0;
       }
        if(target==0)return 1;
        if(dp[n][target]!=-1)return dp[n][target];
        if(nums[n]<=target){
            if(findSubset(n-1,nums,target-nums[n],dp)!=0||findSubset(n-1,nums,target,dp)!=0){
                return dp[n][target]=1;
            }
        }
        else if(findSubset(n-1,nums,target,dp)!=0)return dp[n][target]=1;
        return dp[n][target]=0;
    }
    
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2==0){
            boolean dp[][]=new boolean[nums.length][(sum/2)+1];
            // for(int rows[]:dp)Arrays.fill(rows,-1);
            // return findSubset(nums.length-1,nums,sum/2,dp)==1;
            int target=sum/2;
            for(int i=0;i<nums.length;i++){
                dp[i][0]=true;
            }
            if(target==nums[0])
            dp[0][target]=true;
            for(int i=1;i<nums.length;i++){
                for(int j=1;j<sum/2+1;j++){
                    if(nums[i]<=j){
                        dp[i][j]=dp[i-1][j-nums[i]]||dp[i-1][j];
                    }
                    else dp[i][j]=dp[i-1][j];
                }
            }
            return dp[nums.length-1][sum/2];
        }
        return false;
    }
}