// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        if(N<M)return -1;
        int end = 0;
        int ans = -1;
        for(int i=0;i<A.length;i++){
            end+=A[i];
        }
        int start = 0;
        while(start<=end){
            int mid= start+(end-start)/2;
            if(isValid(mid,A,M)){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
    public static boolean isValid(int mid,int []A,int M){
        int student=1,sum=0;
        for(int i=0;i<A.length;i++){
            if(sum+A[i]<=mid){
                sum+=A[i];
            }
            else{
                student++;
                if(student>M||A[i]>mid){
                    return false;
                }
                sum=A[i];
            }
        }
        return true;
    }
}