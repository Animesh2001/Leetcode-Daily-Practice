class Solution {
    
    public int longestCommonSubsequence(String text1, String text2,int n,int m,int dp[][]){
        if(n==0||m==0){
            return 0;
        }
        if(dp[n][m]!=-1)return dp[n][m];
        
        if(text1.charAt(n-1)==text2.charAt(m-1)){
            return dp[n][m]= 1+ longestCommonSubsequence(text1,text2,n-1,m-1,dp);
        }
        
        return dp[n][m]= Math.max(longestCommonSubsequence(text1,text2,n-1,m,dp),longestCommonSubsequence(text1,text2,n,m-1,dp));
    }
    
    
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        int dp[][]=new int[text1.length()+1][text2.length()+1];
        // for(int rows[]:dp)Arrays.fill(rows,-1);
        // return longestCommonSubsequence(text1,text2,n,m,dp);
        
       for(int i=1;i<=n;i++){
           for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                     dp[i][j]= 1+ dp[i-1][j-1];
                }
                else{
                     dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }  
           }
       }
        return dp[text1.length()][text2.length()];
    }
}