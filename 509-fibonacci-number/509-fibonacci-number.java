class Solution {
    
    public int fib(int n,int dp[]){
        dp[0]=0;
        if(n>0)
        dp[1]=1;
        
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    
    
    public int fib(int n) {
       int dp[]=new int[n+1];
       for(int i=0;i<dp.length;i++){
           dp[i]=-1;
       } 
       return fib(n,dp); 
    }
}