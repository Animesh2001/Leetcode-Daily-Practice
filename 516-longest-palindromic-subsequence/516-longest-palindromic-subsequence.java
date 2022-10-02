class Solution {
    
   public String reverse_string(String s){
       String r = "";
       for(int i=s.length()-1;i>=0;i--){
           r+=s.charAt(i);
       }
       return r;
   }

    public int longestPalindromeSubseq(String s) {
        String  r = reverse_string(s);
        
        int n = s.length();
        int dp[][]=new int[n+1][n+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==r.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}