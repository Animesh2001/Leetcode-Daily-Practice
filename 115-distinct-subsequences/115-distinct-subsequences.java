class Solution {
    
    public int f(String s,String t,int i,int j,int [][]dp){
        if(j==0)return 1;
        if(i==0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j]= f(s,t,i-1,j-1,dp)+f(s,t,i-1,j,dp);
        }else{
            return dp[i][j]= f(s,t,i-1,j,dp);
        }
    }
    
    public int numDistinct(String s, String t) {
        int dp[][]=new int[s.length()+1][t.length()+1];
        // for(int rows[]:dp){
        //     Arrays.fill(rows,-1);
        // }
        // return f(s,t,s.length(),t.length(),dp);
        
        for(int i=0;i<=s.length();i++){
            dp[i][0]=1;
        }
        
        for(int j=1;j<=t.length();j++){
            dp[0][j]=0;
        }
        
        for(int i=1;i<s.length()+1;i++){
            for(int j=1;j<t.length()+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        
        return dp[s.length()][t.length()];
        
        
    }
}