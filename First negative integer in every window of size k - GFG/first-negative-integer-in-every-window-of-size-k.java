// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int n, int k)
    {
        Deque<Integer>dq=new ArrayDeque<>();
        ArrayList<Long>ans=new ArrayList<>();
        
        //process first window of k size
        for(int i=0;i<k;i++){
            if(A[i]<0){
                dq.addLast(i);
            }
        }
        
        //store answer of first k size window
        if(dq.size()>0){
            ans.add(A[dq.getFirst()]);
        }else{
            ans.add((long)0);
        }
        
        //process for remaining windows
        for(int i=k;i<n;i++){
            
            if(!dq.isEmpty()&&i-dq.getFirst()>=k){
                dq.removeFirst();
            }
            
            //addition
            if(A[i]<0){
                dq.addLast(i);
            }
            
            //ans store
             if(dq.size()>0){
                ans.add(A[dq.getFirst()]);
             }else{
                ans.add((long)0);
             }
        }
        long[] arr=new long[ans.size()];
        
        for(int i=0;i<arr.length;i++){
            arr[i]=ans.get(i);
        }
        return arr;
    }
}