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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void f(int []nums,int []dp){
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]&&dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                }
            }
        }
    }
    
    public void reverse(int nums[]){
        int i=0,j=nums.length-1;
        while(i<j){
            int temp=nums[j];
            nums[j]=nums[i];
            nums[i]=temp;
            i++;
            j--;
        }
        return;
    }
    
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        
        int dp1[]=new int[nums.length];
        f(nums,dp1);
        int dp2[]=new int[nums.length];
        
        reverse(nums);
        f(nums,dp2);
        reverse(dp2);
        int maxi=0;
        for(int i=0;i<nums.length;i++){
            maxi=Math.max(maxi,dp1[i]+dp2[i]-1);
        }
        return maxi;
        
        
    }
}