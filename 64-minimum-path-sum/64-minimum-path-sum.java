class Solution {
    
    public int minPathSum(int i,int j,int row,int col,int [][]grid,int [][]dp){
        if(i==row&&j==col)return grid[i][j];
        if(i>row||j>col)return Integer.MAX_VALUE;
        if(dp[i][j]!=-1)return dp[i][j];
        int down=minPathSum(i+1,j,row,col,grid,dp);
        int right =minPathSum(i,j+1,row,col,grid,dp);
        return dp[i][j]= grid[i][j]+Math.min(down,right);
    }
    
    public int minPathSum(int[][] grid) {
        int row=grid.length-1;
        int col=grid[0].length-1;
        int dp[][]=new int[row+1][col+1];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return minPathSum(0,0,row,col,grid,dp);
        
        // for(int i=row;i>=0;i--){
        //     for(int j=col;j>=0;j--){
        //         if(i==row&&j==col)dp[i][j]=grid[i][j];
        //         else{
        //             dp[i][j]= grid[i][j]+Math.min(dp[i+1][j],dp[i][j+1]);
        //         }
        //     }
        // }
        // return dp[0][0];
    }
}