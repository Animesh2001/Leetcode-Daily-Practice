// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

static int isSubsetSum(int n, int arr[], int sum,int t[][]){
            if(sum==0){
            return 1;
        }
        if(n==0&&sum>0){
            return 0;
        }
        if(t[n][sum]!=-1)return t[n][sum];
        
        if(arr[n-1]<=sum){
            if(isSubsetSum(n-1,arr,sum-arr[n-1],t)!=0||isSubsetSum(n-1,arr,sum,t)!=0){
                return t[n][sum]=1;
            }else{
                return t[n][sum]=0;
            }
        }else{
            return t[n][sum]= isSubsetSum(n-1,arr,sum,t);
        }
           
}

    static Boolean isSubsetSum(int n, int arr[], int sum){
        // code here
         int t[][]=new int[n+1][sum+1];
         for(int i=0;i<n+1;i++){
             for(int j=0;j<sum+1;j++){
                 t[i][j]=-1;
             }
         }
         
         return isSubsetSum(n,arr,sum,t)==1?true:false;
        
        
        
    }
}