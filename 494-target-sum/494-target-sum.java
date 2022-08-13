class Solution {
    public int count(int arr[],int target){
        int dp[][]=new int[arr.length][target+1];
        
        for(int i=0;i<=target;i++){
            if(arr[0]==0&&i==0){
                dp[0][i]=2;
            }
            else if(i==0||arr[0]==i){
                dp[0][i]=1;
            }
            else{
                dp[0][i]=0;
            }
        }
        
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<=target;j++){
                int pick=0;
                if(arr[i]<=j){
                    pick=dp[i-1][j-arr[i]];
                }
                int notpick=dp[i-1][j];
                dp[i][j]=pick+notpick;
            }
        }
        return dp[arr.length-1][target];
        
    }
    
    
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum-target<0||(sum-target)%2!=0){
            return 0;
        }
        int x = (sum-target)/2;
        return count(nums,x);
    }
}