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
        int dp[][]=new int[arr.length+2][arr.length+2];
        // for(int rows[]:dp)Arrays.fill(rows,-1);
        // return minCost(1,cuts.length,arr,dp);
        
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp.length;j++){
        //         if(i>j){
        //             dp[i][j]=0;
        //         }
        //     }
        // }
        
        for(int i=cuts.length;i>=1;i--){
            for(int j=1;j<=cuts.length;j++){
                if(i>j)continue;
                int minimum = Integer.MAX_VALUE;
                for(int ind=i;ind<=j;ind++){
                    int cost = arr[j+1]-arr[i-1]+dp[i][ind-1]+dp[ind+1][j];
                    minimum = Math.min(minimum,cost);
                }
                dp[i][j]=minimum;
            }
        }
        return dp[1][cuts.length];
        
        
    }
}