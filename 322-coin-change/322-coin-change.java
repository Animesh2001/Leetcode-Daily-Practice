class Solution {
        public static int minimum(int ind,int arr[],int target,int dp[][]){
//         if(target==0)return 0;
        if(ind==0){
            if(target%arr[0]==0)return target/arr[0];
            else return Integer.MAX_VALUE-1;
        }
        if(dp[ind][target]!=-1)return dp[ind][target];
        int pick=Integer.MAX_VALUE-1;
        if(arr[ind]<=target){
            pick=1+minimum(ind,arr,target-arr[ind],dp);
        }
        int notpick = minimum(ind-1,arr,target,dp);
        return dp[ind][target]= Math.min(pick,notpick);
    }
    
    public int coinChange(int[] num, int x) {
         int dp[][]=new int[num.length][x+1];
        for(int rows[]:dp)Arrays.fill(rows,-1);
        
        int ans = minimum(num.length-1,num,x,dp);
        if(ans>=Integer.MAX_VALUE-1)return -1;
        return ans;
    }
}