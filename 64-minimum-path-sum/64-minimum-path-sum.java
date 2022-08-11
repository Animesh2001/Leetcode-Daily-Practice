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
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return minSumPath(n-1,m-1,grid,dp);
    }
}
 