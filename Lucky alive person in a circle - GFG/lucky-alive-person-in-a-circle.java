//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution{
     static int get(int n) {
        int num=0;
        int ans=0;
        while((1<<num)<=n){
            ans = (1<<num);
            num++;
        }
        return 2*(n-ans)+1;
    }
    static int find(int N){
        // code here
        return get(N);
        
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
           
            Solution ob = new Solution();
            System.out.println(ob.find(N));
        }
    }
}
// } Driver Code Ends