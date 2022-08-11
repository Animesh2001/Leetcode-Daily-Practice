class Solution {
    
    public int uniquePath(int n ,int m,int [][]obstacleGrid,int dp[][]){
        if(n>=0&&m>=0&&obstacleGrid[n][m]==1){
            return 0;
        }
        if(n==0&&m==0){
            return 1;
        }
        if(n<0||m<0){
            return 0;
        }
       if(dp[n][m]!=-1)return dp[n][m];
        int up=uniquePath(n-1,m,obstacleGrid,dp);
        int left = uniquePath(n,m-1,obstacleGrid,dp);
        return dp[n][m]= up+left;
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][]=new int[m][n];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return uniquePath(m-1,n-1,obstacleGrid,dp);
    }
    
}