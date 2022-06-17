// { Driver Code Starts
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
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer>stack=new Stack<>();
    	int number_of_celebrities = M.length;
    	for(int i=0;i<number_of_celebrities;i++){
    	    stack.push(i);
    	}
    	
    	while(stack.size()>1){
    	int celebrity1 = stack.pop();
    	int celebrity2 = stack.pop();
    	    if(M[celebrity1][celebrity2]==0){
    	        stack.push(celebrity1);
    	    }
    	    else {
    	        stack.push(celebrity2);
    	    }
    	}
    	
         if(stack.size()==1){
             int candidate=stack.pop();
             boolean rowCheck=false;
             boolean colCheck=false;
             int zeroCount=0;
             int oneCount=0;
             for(int i=0;i<n;i++){
                 if(M[candidate][i]==0){
                     zeroCount++;
                 }
             }
             if(zeroCount==n){
                 rowCheck=true;
             }
             
             for(int i=0;i<n;i++){
                 if(M[i][candidate]==1){
                     oneCount++;
                 }
             }
             if(oneCount==n-1){
                 colCheck=true;
             }
             if(rowCheck==true&&colCheck==true){
                 return candidate;
             }
         }
         return -1;
    }
}