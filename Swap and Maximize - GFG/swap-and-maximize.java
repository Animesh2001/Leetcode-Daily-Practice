// { Driver Code Starts
//Initial Template for Java



//Initial Template for Java



import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java




class GFG
{
    void swap(long arr[],int i,int j){
        long temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
    long maxSum(long arr[] ,int n)
    {
    
        Arrays.sort(arr);
        int i = 1;
        int j = n-2;
        while(i<j){
            swap(arr,i,j);
            i+=2;
            j-=2;
        }
        
        long maxsum=0;
        int k=0;
        for(;k<n-1;k++){
            maxsum += Math.abs(arr[k]-arr[k+1]);
        }
        maxsum += Math.abs(arr[k]-arr[0]);
        return maxsum;
    }
}


// { Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            int n=Integer.parseInt(br.readLine());
//            String line = br.readLine();
//            String[] a2 = line.trim().split("\\s+");
//            int n =Integer.parseInt(a2[0]);
//            int k =Integer.parseInt(a2[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long arr[]=new long[n];
            for(int  i=0;i<n;i++)
            {
                arr[i]=Long.parseLong(a1[i]);
            }
            GFG ob=new GFG();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans=ob.maxSum(arr,n);
            System.out.println(ans);
        }
    }
}



  // } Driver Code Ends