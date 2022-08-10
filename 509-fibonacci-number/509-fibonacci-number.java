class Solution {
    
    public int fib(int n,int dp[]){
        
        int prev2=0;
        int prev=1;
        
        for(int i=2;i<=n;i++){
            int curri = prev+prev2;
            prev2=prev;
            prev=curri;
        }
        return n==0?prev2:prev;
    }
    
    
    public int fib(int n) {
       int dp[]=new int[n+1];
       for(int i=0;i<dp.length;i++){
           dp[i]=-1;
       } 
       return fib(n,dp); 
    }
}