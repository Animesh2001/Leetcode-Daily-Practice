class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                else {
                    int up = grid[i][j];
                    up += (i > 0) ? dp[i - 1][j] : (int)(1e9);
                    
                    int left = grid[i][j];
                    left += (j > 0) ? dp[i][j - 1] : (int)(1e9);
                    
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        
        return dp[row - 1][col - 1];
    }
}