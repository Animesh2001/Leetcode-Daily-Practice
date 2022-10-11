class Solution {
    
    public static String reverse(String str){
        String r = "";
        for(int i=str.length()-1;i>=0;i--){
            r+=str.charAt(i);
        }
        return r;
    }
    
    public static int substring(String str1,String str2,int ind1,int ind2,int dp[][]){
        if(ind1==str1.length()||ind2==str2.length()){
            return 0;
        }
        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];
        if(str1.charAt(ind1)==str2.charAt(ind2)){
            return dp[ind1][ind2]=1+substring(str1,str2,ind1+1,ind2+1,dp);
        }
        return dp[ind1][ind2]=Math.max(substring(str1,str2,ind1,ind2+1,dp)
        ,substring(str1,str2,ind1+1,ind2,dp));
        
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][]=new int[n][n];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return substring(s,reverse(s),0,0,dp);
    }
}