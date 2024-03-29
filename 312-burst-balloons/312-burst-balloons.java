class Solution {
    
    public int maxCoins(int i,int j, int nums[],int dp[][]){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int maximum = Integer.MIN_VALUE;
        for(int ind=i;ind<=j;ind++){
            int coins = nums[i-1]*nums[ind]*nums[j+1]+
                maxCoins(i,ind-1,nums,dp)+maxCoins(ind+1,j,nums,dp);
            maximum = Math.max(maximum,coins);
        }
        return dp[i][j]=maximum;
    }
    
    public int maxCoins(int[] nums) {
        int arr[]=new int[nums.length+2];
        for(int i=0;i<arr.length;i++){
            if(i==0){
                arr[i]=1;
            }
            else if(i==arr.length-1){
                arr[i]=1;
            }
            else{
                arr[i]=nums[i-1];
            }
        }
        
        int dp[][]=new int[nums.length+1][nums.length+1];
        
        for(int rows[]:dp)Arrays.fill(rows,-1);
        
        return maxCoins(1,nums.length,arr,dp);
    }
}