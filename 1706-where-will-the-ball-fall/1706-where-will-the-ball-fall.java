class Solution {
    
    public boolean valid(int grid[][],int row,int col){
        return (row>=0&&col>=0&&row<grid.length&&col<grid[0].length);
    }
    
    public int findBall(int [][]grid,int row, int col,int [][]dp){
        if(row==grid.length){
            return col;
        }
        if(dp[row][col]!=-2){
            return dp[row][col];
        }
        
        if(valid(grid,row,col)){
            if(grid[row][col]==1){
                if(valid(grid,row,col+1)&&grid[row][col+1]==1){
                    return dp[row][col]= findBall(grid,row+1,col+1,dp);
                }else{
                    return dp[row][col] = -1;
                }
            }
            
            if(grid[row][col]==-1){
                if(valid(grid,row,col-1)&&grid[row][col-1]==-1){
                    return dp[row][col]=findBall(grid,row+1,col-1,dp);
                }else{
                    return dp[row][col]= -1;
                }
            }
        }
        return -1;
    }
    
    
    public int[] findBall(int[][] grid) {
        int dp[][]=new int[grid.length][grid[0].length];
        for(int []row:dp){
            Arrays.fill(row,-2);
        }
        int ans[]=new int[grid[0].length];
        int k=0;
        for(int i=0;i<ans.length;i++){
            ans[k++]=findBall(grid,0,i,dp);
        }
        return ans;
    }
}