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
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean subset(int[]nums,int n,int sum,boolean t[][]){
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0){
                    t[i][j]=false;
                }
                if(j==0){
                    t[i][j]=true;
                }
            }
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(nums[i-1]<=j){
                    t[i][j]=t[i-1][j-nums[i-1]]||t[i-1][j];
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][sum];
        
    }

	public int minDifference(int nums[], int n) 
	{ 
	    // Your code goes here
	     //calculate the sum
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        boolean t[][]=new boolean[nums.length+1][sum+1];
        subset(nums,nums.length,sum,t);
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<=sum/2;i++){
            if(t[nums.length][i]==true)list.add(i);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++){
            ans=Math.min(ans,sum-(2*list.get(i)));
        }
        return ans;
	} 
}
