// { Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.findMaxProduct(n, arr);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int findMaxProduct(int n, int[] arr) {
        long M = 1000000007;
        if(n==1)return arr[0];
        int count_odd=0;
        long product = 1;
        int count_zero = 0;
        int largest_negative = Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                largest_negative=Math.max(largest_negative,arr[i]);
                count_odd++;
            }
            else if(arr[i]==0){
                count_zero++;
                continue;
            }
            
            product=(product*arr[i])%M;
            
        }
        if(count_zero==n){
            return 0;
        }
        else if(count_odd==1&&count_zero>0&&count_zero+count_odd==n){
            return 0;
        }
        
        else if(count_odd%2==1){
            return (int)(product/largest_negative);
        }
        
        return (int)product;
        
        
        
        
    }
}
        
