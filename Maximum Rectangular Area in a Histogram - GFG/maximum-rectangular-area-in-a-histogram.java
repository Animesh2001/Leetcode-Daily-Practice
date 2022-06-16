// { Driver Code Starts
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
    
    public static class Pair{
        long num;
        int index;
        public Pair(long num,int index){
            this.num=num;
            this.index=index;
        }
    }
    
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        Stack<Pair>stack=new Stack<>();
        int nsr[]=new int[hist.length];
        int nsl[]=new int[hist.length];
        int k=0;
        
        for(int i=hist.length-1;i>=0;i--){
            if(stack.isEmpty())nsr[i]=hist.length;
            else if(stack.peek().num<hist[i])nsr[i]=stack.peek().index;
            else if(stack.peek().num>=hist[i]){
                while(!stack.isEmpty()&&stack.peek().num>=hist[i]){
                    stack.pop();
                }
                if(stack.isEmpty())nsr[i]=hist.length;
                else nsr[i]=stack.peek().index;
            }
            stack.push(new Pair(hist[i],i));
        }
       // Collections.reverse(nsr);
        
        stack=new Stack<>();
        for(int i=0;i<hist.length;i++){
            if(stack.isEmpty())nsl[i]=-1;
            else if(stack.peek().num<hist[i])nsl[i]=stack.peek().index;
            else if(stack.peek().num>=hist[i]){
                while(!stack.isEmpty()&&stack.peek().num>=hist[i]){
                    stack.pop();
                }
                if(stack.isEmpty())nsl[i]=-1;
                else nsl[i]=stack.peek().index;
            }
            stack.push(new Pair(hist[i],i));
        }
        long ans=Long.MIN_VALUE;
        long width[]=new long[hist.length];
        for(int i=0;i<hist.length;i++){
            width[i]=(long)(nsr[i]-nsl[i])-1;
        }
        for(int i=0;i<hist.length;i++){
            ans=Math.max(ans,hist[i]*width[i]);
        }
        return ans;
    }
        
}



