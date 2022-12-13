class Solution {
    
    public int find_min(int row, int col, int matrix[][],int dp[][]){
        int n = matrix.length;
        if( row>=n || col>=n || col<0 )return Integer.MAX_VALUE;
        
        if(row == n-1){
            return matrix[row][col];
        }
        
        if(dp[row][col]!=-1)return dp[row][col];
        
        int left_diagonal =  find_min(row+1, col-1, matrix,dp);
        int right_diagonal =  find_min(row+1, col+1, matrix,dp);
        int down =  find_min(row+1, col, matrix,dp);
        
        return dp[row][col] = matrix[row][col] + Math.min(left_diagonal , Math.min(right_diagonal,down));
    }
    
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int dp[][] = new int[matrix.length][matrix.length];
        
        for(int rows[] : dp){
            Arrays.fill(rows,-1);
        }
        
        for(int i=0; i<matrix[0].length; i++){
            ans = Math.min(ans,find_min(0, i, matrix,dp));
        }
        
        return ans;
    }
}