class Solution {
    
    public int minFallingPathSum(int i,int j,int row,int col,int [][]matrix,int [][]dp){
        if(j<0||i>row||j>col)return Integer.MAX_VALUE;
        if(i==row)return matrix[i][j];
        if(dp[i][j]!=-1)return dp[i][j];
        int down = minFallingPathSum(i+1,j,row,col,matrix,dp);
        int ld = minFallingPathSum(i+1,j-1,row,col,matrix,dp);
        int rd = minFallingPathSum(i+1,j+1,row,col,matrix,dp);
        return dp[i][j]=matrix[i][j]+Math.min(down,Math.min(ld,rd));
    }
    
    
    
    public int minFallingPathSum(int[][] matrix) {
         int min= Integer.MAX_VALUE;
        int n = matrix.length;
        int dp[][]=new int[n][n];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
         for(int j=0;j<matrix[0].length;j++){
            min=Math.min(min,minFallingPathSum(0,j,matrix.length-1,matrix.length-1,matrix,dp));
         }
        return min;
    }
}