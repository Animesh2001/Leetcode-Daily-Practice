// { Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} // } Driver Code Ends




class Solution 
{
     public static int f(int ind,int prev_ind,int []nums,int n,int [][]dp){
        if(ind==n)return 0;
        if(dp[ind][prev_ind+1]!=-1)return dp[ind][prev_ind+1];
        //not take
       int len = f(ind+1,prev_ind,nums,n,dp);
        
        //take
        if(prev_ind==-1||nums[ind]>nums[prev_ind]){
            len = Math.max(len,1+f(ind+1,ind,nums,n,dp));
        }
        return dp[ind][prev_ind+1]=len;
    }
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int nums[])
    {
        // code here
         int dp[][]=new int[nums.length][nums.length+1];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return f(0,-1,nums,nums.length,dp);
    }
} 