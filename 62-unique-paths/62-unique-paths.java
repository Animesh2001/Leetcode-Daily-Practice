class Solution {
    
    public int uniquePaths(int m,int n, int i, int j ,int matrix[][]){
        //base case
        if(i==m-1&&j==n-1){
            return matrix[i][j]= 1;    
        }
        if(matrix[i][j]!=-1)return matrix[i][j];
        //recursive calls
        int right =0,bottom=0;
        
        if(j+1<n){
           right = uniquePaths(m,n,i,j+1,matrix);
        }
        
        if(i+1<m){
          bottom = uniquePaths(m,n,i+1,j,matrix);
        }
        
        return matrix[i][j]=right+bottom;
        
    }
    
    public int uniquePaths(int m, int n) {
        
        int matrix[][]=new int[m+1][n+1];
        
        for(int rows[]:matrix){
            Arrays.fill(rows,-1);
        }
       return  uniquePaths(m,n,0,0,matrix);
    }
}