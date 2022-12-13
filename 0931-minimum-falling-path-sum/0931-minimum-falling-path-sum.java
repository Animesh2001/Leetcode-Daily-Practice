class Solution {

    public int minFallingPathSum(int i, int j, int row, int col, int[][] matrix, int[][] dp) {
        if (j < 0 || i > row || j > col) return Integer.MAX_VALUE;
        if (i == row) return matrix[i][j];
        if (dp[i][j] != -1) return dp[i][j];
        int down = minFallingPathSum(i + 1, j, row, col, matrix, dp);
        int ld = minFallingPathSum(i + 1, j - 1, row, col, matrix, dp);
        int rd = minFallingPathSum(i + 1, j + 1, row, col, matrix, dp);
        return dp[i][j] = matrix[i][j] + Math.min(down, Math.min(ld, rd));
    }

    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int n = matrix.length;
        int dp[][] = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1) dp[i][j] = matrix[i][j]; else {
                    int down = Integer.MAX_VALUE, ld = Integer.MAX_VALUE, rd = Integer.MAX_VALUE;
                    down = dp[i + 1][j];
                    if (j > 0) ld = dp[i + 1][j - 1];
                    if (j < n - 1) rd = dp[i + 1][j + 1];

                    dp[i][j] = matrix[i][j] + Math.min(down, Math.min(ld, rd));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[0][i]);
        }
        return min;
    }
}
