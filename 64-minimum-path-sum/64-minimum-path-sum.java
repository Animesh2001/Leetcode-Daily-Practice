// class Solution {
//     public  int minSumPath(int n,int m,int[][] grid,int [][]dp){
//         if(n==0&&m==0){
//             return grid[n][m];
//         }
//         if(n<0||m<0)return Integer.MAX_VALUE;
//         if(dp[n][m]!=-1)return dp[n][m];
//         int up = grid[n][m]+minSumPath(n-1,m,grid,dp);
//         int left = grid[n][m]+minSumPath(n,m-1,grid,dp);
//         return dp[n][m]= Math.min(up,left);
//     }
    
//     public int minPathSum(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         int dp[][]=new int[n][m];
//         for(int rows[]:dp){
//             Arrays.fill(rows,-1);
//         }
//         return minSumPath(n-1,m-1,grid,dp);
//     }
// }
class Solution 
{
    static int[][] memo;
    public int minPathSum(int[][] grid) 
    {
        int m = grid.length-1;
        int n = grid[0].length-1;
        
        memo = new int[m+1][n+1];
        
        return find(grid, m, n, memo);
    }
    public int find(int grid[][], int m, int n, int[][] memo)
    {
        if(m==0 && n==0)
            return grid[0][0];
        
        else if(m<0 || n<0)
            return Integer.MAX_VALUE;
        
        else if(memo[m][n]!=0)
            return memo[m][n];
        else
            return memo[m][n] =  grid[m][n] + Math.min(find(grid, m-1, n, memo),find(grid, m, n-1, memo)); 
}
    }