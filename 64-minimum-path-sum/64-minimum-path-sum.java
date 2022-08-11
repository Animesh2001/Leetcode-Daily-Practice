class Solution {
    public  int minSumPath(int n,int m,int[][] grid,int [][]dp){
        if(n<0||m<0)return Integer.MAX_VALUE;
        if(n==0&&m==0){
            return grid[n][m];
        }
        if(dp[n][m]!=-1)return dp[n][m];
        
        
      
        int up = minSumPath(n-1,m,grid,dp);
        int left = minSumPath(n,m-1,grid,dp);
        return dp[n][m]=grid[n][m]+Math.min(up,left);
    }
    
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][]=new int[n][m];
        // for(int rows[]:dp){
        //     Arrays.fill(rows,-1);
        // }
        // return minSumPath(n-1,m-1,grid,dp);
        
        dp[0][0]=grid[0][0];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0&&j==0)dp[i][j]=grid[i][j];
                else{
                    int up = Integer.MAX_VALUE;
                    int left=Integer.MAX_VALUE;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j]=grid[i][j]+Math.min(up,left);
                }
            }
        }
        return dp[n-1][m-1];
        
    }
}
 