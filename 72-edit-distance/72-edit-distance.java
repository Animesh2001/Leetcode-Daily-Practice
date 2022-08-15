class Solution {
    
    public int count(int i,int j,String str1,String str2,int dp[][]){
        if(j==0)return i;
        if(i==0)return j;
        if(dp[i][j]!=-1)return dp[i][j];
        if(str1.charAt(i-1)==str2.charAt(j-1)){
            return dp[i][j]=count(i-1,j-1,str1,str2,dp);
        }
        
        return dp[i][j]= 1+Math.min(count(i-1,j,str1,str2,dp),Math.min(count(i-1,j-1,str1,str2,dp),count(i,j-1,str1,str2,dp)));
        
    }
    
    
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int dp[][]=new int[n+1][m+1];
        // for(int rows[]:dp)Arrays.fill(rows,-1);
        
        // return count(n,m,word1,word2,dp);
        
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        
        for(int j=0;j<=m;j++){
            dp[0][j]=j;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                     dp[i][j]=dp[i-1][j-1];
                }

                else  dp[i][j]= 1+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
            }
        }
        return dp[n][m];
        
    }
}