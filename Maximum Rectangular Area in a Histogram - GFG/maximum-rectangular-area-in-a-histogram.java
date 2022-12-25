//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    public static long[] getnsr(long hist[], long n){
        long nsr[] = new long[hist.length];
        Stack<Integer>st = new Stack<>();
        for(int i = hist.length-1; i>=0; i--){
            while(!st.isEmpty()&&hist[st.peek()]>=hist[i]){
                st.pop();
            }
            nsr[i]= (st.isEmpty())?hist.length:st.peek();
            st.push(i);
        }
        return nsr;
    }
    
    public static long[] getnsl(long hist[], long n){
        long[] nsl = new long[hist.length];
        Stack<Integer>st = new Stack<>();
        for(int i=0; i<hist.length; i++){
            while(!st.isEmpty()&&hist[st.peek()]>=hist[i]){
                st.pop();
            }
            if(st.isEmpty()) nsl[i]=-1;
            else nsl[i] = st.peek();
            st.push(i);
        }
        return nsl;
    }
    
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        long nsl[] = getnsl(hist,n);
        long nsr[] = getnsr(hist,n);
        
        long max = Integer.MIN_VALUE;
        for(int i=0; i<hist.length; i++){
            long ans = (nsr[i]-nsl[i]-1)*hist[i];
            max = Math.max(ans,max);
        }
        return max;
        
    }
        
}



