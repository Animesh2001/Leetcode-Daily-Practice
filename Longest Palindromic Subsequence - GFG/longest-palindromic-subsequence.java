// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    public int lcs(int n, int m, String text1, String text2)
    {
        // your code here
        int t[][]=new int[n+1][m+1];
        
        //Initializing the matrix
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0)t[i][j]=0;
                if(j==0)t[i][j]=0;
            }
        }
        
        //Fill the rest of the matrix
         for(int i=1;i<n+1;i++){
             for(int j=1;j<m+1;j++){
                //if last two characters of the string are same
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    //call for length n-1 and m-1
                    t[i][j]=1+t[i-1][j-1];
                }
                 else{
                     t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                 }
            }
         }
        
        return t[n][m];
        
    }
    public String reverse(String s){
        String str="";
        for(int i=s.length()-1;i>=0;i--){
            str+=s.charAt(i);
        }
        return str;
    }
    
    
    public int longestPalinSubseq(String str1)
    {
        //code here
        String str2 = reverse(str1);
        return lcs(str1.length(),str2.length(),str1,str2);
        
        
    }
}