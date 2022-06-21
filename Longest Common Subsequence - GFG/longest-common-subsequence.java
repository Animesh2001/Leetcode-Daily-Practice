// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int n, int m, String text1, String text2)
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
    
}