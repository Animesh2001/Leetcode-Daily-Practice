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
    
    public long[] printFirstNegativeInteger(long arr[], int N, int k)
    {
        int i=0,j=k-1,o=0;
        long ans[]=new long[N-k+1];
        Deque<Long>deque=new ArrayDeque<>();
        for(int l=0;l<=j;l++){
            while(deque.size()>0&&arr[l]<deque.peekLast()){
                if(deque.peekLast()>0){
                    deque.pollLast();
                }else{
                    break;
                }
            }
            deque.offerLast(arr[l]);
        }
        if(deque.peekFirst()<0){
            ans[o++]=deque.peekFirst();
        }else{
            ans[o++]=0;
        }
        j++;
        while(j<arr.length){
            if(arr[i]==deque.peekFirst()){
                deque.pollFirst();
            }
            i++;
            while(deque.size()>0&&arr[j]<deque.peekLast()){
                 if(deque.peekLast()>0){
                    deque.pollLast();
                }else{
                    break;
                }
            }
            deque.offerLast(arr[j]);
            if(deque.peekFirst()<0){
            ans[o++]=deque.peekFirst();
            }else{
                ans[o++]=0;
             }
             j++;  
        }
        return ans;
        
    }
}