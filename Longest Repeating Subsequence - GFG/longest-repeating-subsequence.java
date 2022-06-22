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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str1)
    {
        // code here
        String str2="";
        for(int i=0;i<str1.length();i++){
            str2+=str1.charAt(i);
        }
        
        int n=str1.length();
        int m=str2.length();
        
        int t[][]=new int[n+1][m+1];
        
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0){
                    t[i][j]=0;
                }
                if(j==0){
                    t[i][j]=0;
                }
            }
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)&&i!=j){
                    t[i][j]=1+t[i-1][j-1];
                }else{
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[n][m];
        
    }
}