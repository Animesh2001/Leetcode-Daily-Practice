class Solution {
    
    public int f(String s, String p, int i,int j,int dp[][]){
        if(i==0&&j==0)return 1;
        if(i==0&&j>0)return 0;
        if(i>0&&j==0){
            for(int k=0;k<i;k++){
                if(s.charAt(k)!='*')return dp[i][j]=0;
            }
            return 1;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i-1)==p.charAt(j-1)||s.charAt(i-1)=='?'){
           return dp[i][j]= f(s,p,i-1,j-1,dp);
        }
        //ALERT : You need to consider not taking '*' and then taking it.
        //Watch Strivers video once for this step.
        if(s.charAt(i-1)=='*'){
            if(f(s,p,i-1,j,dp)==1||f(s,p,i,j-1,dp)==1){
              return  dp[i][j]=1;
            }
            return dp[i][j]=0;
        }
        return 0;
    }
    
    public boolean isMatch(String s, String p) {
        
        int m = s.length();
        int n= p.length();
        
        //memoization
        boolean dp[][]=new boolean[n+1][m+1];
//         for(int rows[]:dp){
//             Arrays.fill(rows,-1);
//         }
        
//         return f(p,s,n,m,dp)==1;
        
        //tabulation 
        dp[0][0]=true;
        for(int i=1;i<n+1;i++){
          boolean flag=true;
            for(int k=1;k<=i;k++){
                if(p.charAt(k-1)!='*'){
                   flag = false;
                }
            }
            dp[i][0]=flag;
        }
        for(int j=1;j<m+1;j++){
            dp[0][j]=false;
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
          if(p.charAt(i-1)==s.charAt(j-1)||p.charAt(i-1)=='?'){
           dp[i][j]= dp[i-1][j-1];
        }
        //ALERT : You need to consider not taking '*' and then taking it.
        //Watch Strivers video once for this step.
          else if(p.charAt(i-1)=='*'){
              dp[i][j]= dp[i-1][j]||dp[i][j-1];
        }
          else dp[i][j]=false;
            
          }
        }
        return dp[n][m];
        
}
}