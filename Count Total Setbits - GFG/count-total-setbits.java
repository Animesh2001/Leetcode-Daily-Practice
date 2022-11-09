//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.countBits(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static int get2power(int n){
        int power = 0;
        while((1<<power)<=n){
            power++;
        }
        return power-1;
    }
    
    
    static int countBits(int N){
        // code here
        if(N==0){
            return 0;
        }
       int x = get2power(N);
       int bits_till_2powerx = (1<<x-1)*x;
       int after_2powerx = N-(1<<x)+1;
       int rest = N - (1<<x);
       return bits_till_2powerx+after_2powerx+countBits(rest);
    }
}