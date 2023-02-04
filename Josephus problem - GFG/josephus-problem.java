//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();//testcases
		while(T-->0)
		{
		    Solution obj=new Solution();
		    
		    int n,k;
		    //taking input n and k
		    n=sc.nextInt();
		    k=sc.nextInt();
		    
		    //calling josephus() function
		    System.out.println(obj.josephus(n,k));
		    
		    
		}
		
	}
}


// } Driver Code Ends


class Solution
{
    
    public int f(int n, int k){
        if(n == 1){
            return 1;
        }
        
        //recursion will get me the answer for n-1 numbers
        int ans = josephus( n-1, k );
        
        //now I needed to decode recursion answer for n numbers
        return ((ans+k-1)%n+1);
    }
    
   public int josephus(int n, int k)
    {
        //Your code here
        
        int ans = f(n,k);
        return ans;
        
        
        
    }

}

