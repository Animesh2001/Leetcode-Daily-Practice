class Solution {
    
    public int minCost(int i,int j,int[]cuts,int dp[][]){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int minimum = Integer.MAX_VALUE;
        for(int ind=i;ind<=j;ind++){
            int cost = cuts[j+1]-cuts[i-1]+minCost(i,ind-1,cuts,dp)+minCost(ind+1,j,cuts,dp);
            minimum = Math.min(minimum,cost);
        }
        return dp[i][j]=minimum;
    }
    
    
    public int minCost(int n, int[] cuts) {
       int arr[]=new int[cuts.length+2];
        
        arr[0]=0;
        arr[arr.length-1]=n;
        
        for(int i=0;i<cuts.length;i++){
            arr[i+1]=cuts[i];
        }
        Arrays.sort(arr);
        int dp[][]=new int[arr.length][arr.length];
        for(int rows[]:dp)Arrays.fill(rows,-1);
        return minCost(1,cuts.length,arr,dp);
        
    }
}