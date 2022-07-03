// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static int f(int i,int j,int dp[][],int N,int [][]a){
        if(j<0||j>=a[0].length)return Integer.MIN_VALUE;
        if(i==0)return a[0][j];
        
        if(dp[i][j]!=-1)return dp[i][j];
        int s = a[i][j]+f(i-1,j,dp,N,a);
        int ld=a[i][j]+f(i-1,j-1,dp,N,a);
        int rd=a[i][j]+f(i-1,j+1,dp,N,a);
        return dp[i][j]=Math.max(s,Math.max(ld,rd));
    }
    
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
        int dp[][]=new int[N][N];
        for(int []rows:dp){
            Arrays.fill(rows,-1);
        }
        int maxi=Integer.MIN_VALUE;
        for(int j=0;j<N;j++){
            maxi=Math.max(maxi,f(N-1,j,dp,N,Matrix));
        }
        return maxi;
    }
}