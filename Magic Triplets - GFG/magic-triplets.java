//{ Driver Code Starts
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
            String[] S = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int ans = ob.countTriplets(nums);
            System.out.println(ans);         
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public int countTriplets(int[] nums){
        // code here
        int count=0;
        for(int j=1;j<nums.length-1;j++){
            int count_prev=0;
            for(int i=j-1;i>=0;i--){
                if(nums[i]<nums[j])count_prev++;
            }
            int count_next = 0;
            for(int k=j+1;k<nums.length;k++){
                if(nums[k]>nums[j])count_next++;
            }
            count+=(count_prev*count_next);
        }
        return count;
    }
}