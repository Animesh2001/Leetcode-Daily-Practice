//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.fillingBucket(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    //100000007
    
    static int mod = 100000000;
    
    static int akansha(int N,int dp[]){
            if(N==0)return 1;
            if(N<0)return 0;
            if(dp[N]!=-1)return dp[N];
            int count_one = akansha(N-1,dp);
            int count_two = akansha(N-2,dp);
            
          return dp[N]=(count_one+count_two)%mod;
    }
    
    static int fillingBucket(int N) {
        // code here
       int dp[]=new int[N+1]; //declare dp array
    //   Arrays.fill(dp,-1); //memset
    //   return akansha(N,dp);
    dp[0]=1;
    for(int i=1;i<=N;i++){
         int count_one = dp[i-1];
         int count_two=0;
         if(i>1)count_two= dp[i-2];
         dp[i]=(count_one+count_two)%mod;
    }
    return dp[N];
     
    }
};