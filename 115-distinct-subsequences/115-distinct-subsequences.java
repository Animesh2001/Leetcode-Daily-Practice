class Solution {
    
    public int count(int i,int j,String str1, String str2,int dp[][]){
        if(i==0&&j>0)return 0;
        if(i>=0&&j==0)return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        if(str2.charAt(j-1)==str1.charAt(i-1)){
            return dp[i][j]=count(i-1,j-1,str1,str2,dp)+count(i-1,j,str1,str2,dp);
        }
        return dp[i][j]=count(i-1,j,str1,str2,dp);
    }
    
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][]=new int[n+1][m+1];
        // for(int rows[]:dp)Arrays.fill(rows,-1);
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int j=1;j<=m;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(t.charAt(j-1)==s.charAt(i-1)){
                     dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][m];
        // return count(n,m,s,t,dp);
    }
}