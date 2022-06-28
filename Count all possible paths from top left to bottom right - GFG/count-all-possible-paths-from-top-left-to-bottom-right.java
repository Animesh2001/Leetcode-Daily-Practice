// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int m = Integer.parseInt(input[0]); 
            int n = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m,n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    long numberOfPaths(int m, int n)
    {
        // code here
        long dp[][]=new long[m][n];
        long M = 1000000007;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0)dp[0][0]=1;
                else{
                    long up = 0, left=0;
                    if(i>0)up=dp[i-1][j]%M;
                    if(j>0)left=dp[i][j-1]%M;
                    dp[i][j]=(up+left)%M;
                }
            }
        }
        
        return dp[m-1][n-1]%M;
    }
}