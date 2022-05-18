// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.Collections;


class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
            int N = sc.nextInt();
            int[] Arr = new int[N];
            for (int i = 0; i < N; ++i){
                Arr[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            int ans = ob.minSubset(Arr,N);
            System.out.println(ans);
            t--;
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution { 
    int minSubset(int[] Arr,int N) { 
        Arrays.sort(Arr);
        long sum = 0;
        long count = 0;
        long total_sum=0;
        
        for(int i=0;i<N;i++){
            total_sum+=Arr[i];
        }
        int j=N-1;
        while(j>=0&&sum<=total_sum){
            sum+=Arr[j];
            total_sum-=Arr[j];
            count++;
            j--;
        }
        return (int)count;
    }
}