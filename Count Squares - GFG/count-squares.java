// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countSquares(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int countSquares(int x) {
        // code here
        long start = 0;
        long end = x;
        long ans=-1;
        
        while(start<=end){
            long mid = start+(end-start)/2;
            
            // if((mid*mid)==x){
            //     return (int)mid;
            // }
             if((mid*mid)<x){
                ans=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return (int)ans;
    }
}