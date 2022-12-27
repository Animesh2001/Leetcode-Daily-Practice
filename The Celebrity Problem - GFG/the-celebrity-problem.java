//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    boolean knows(int f, int s, int mat[][]){
        return mat[f][s]==1;
    }
    
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer>stack = new Stack<>();
    	
    	for(int i =0; i<n; i++){
    	    stack.push(i);
    	}
    	
    	while(stack.size()>1){
    	    int f = stack.pop();
    	    int s = stack.pop();
    	    
    	    if(knows(f,s,M))stack.push(s);
    	    else stack.push(f);
    	}
    	
    	int c = stack.pop();
    	
    	for(int i =0; i<n; i++){
    	    if(M[c][i]!=0){
    	        return -1;
    	    }
    	    if(M[i][c]!=1&&i!=c){
    	        return -1;
    	    }
    	}
    	
    	return c;
    	
    }
}