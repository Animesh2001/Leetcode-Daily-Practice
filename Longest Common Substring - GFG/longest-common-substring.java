// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String s1, String s2, int n, int m){
        // code here
        
        int t[][]=new int[n+1][m+1];
        
        //Initialization
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0)t[i][j]=0;
                if(j==0)t[i][j]=0;
            }
        }
        int result=0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    t[i][j]=1+t[i-1][j-1];
                     result = Math.max(result,t[i][j]);
                }else{
                    t[i][j]=0;
                }
            }
        }
        
        return result;
        
    }
}