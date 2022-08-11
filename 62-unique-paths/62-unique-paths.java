class Solution {
    
    public int uniquePath(int m,int n,int dp[][]){
        //condition satisfied
        if(m==0&&n==0){
            return 1;
        }
        if(m<0||n<0)return 0;
        if(dp[m][n]!=-1)return dp[m][n];
        int up = uniquePath(m-1,n,dp);
        int left = uniquePath(m,n-1,dp);
        return dp[m][n]=up+left;
    }
    
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int []rows:dp){
            Arrays.fill(rows,-1);
        }
        return uniquePath(m-1,n-1,dp);
        
    }
}