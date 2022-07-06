class Solution {
    
    public int f(String s, String t,int i,int j){
        if(i==0&&j==0)return 0;
        if(i==0&&j>0)return j;
        if(i>0&&j==0)return i;
        
        if(s.charAt(i-1)==t.charAt(j-1)){
            return f(s,t,i-1,j-1);
        }else{
            return Math.min(1+f(s,t,i-1,j-1),Math.min(1+f(s,t,i-1,j),1+f(s,t,i,j-1)));
        }
    }
    
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int dp[][]=new int[n+1][m+1];
        
        dp[0][0]=0;
        
        for(int i=1;i<n+1;i++){
            dp[i][0]=i;
        }
        
        for(int j=1;j<m+1;j++){
            dp[0][j]=j;
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[n][m];
    }
}