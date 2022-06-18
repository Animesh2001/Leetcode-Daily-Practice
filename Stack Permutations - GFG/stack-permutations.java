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
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int[] B = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.isStackPermutation(N, A, B);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int isStackPermutation(int N, int[] arr1, int[] arr2) {
        // code here
         int i=0;
         int j=0;
         Stack<Integer>s=new Stack<>();
         while(i<arr1.length&&j<arr2.length){
             while(i<arr1.length){
                 s.push(arr1[i]);
                 if(arr1[i]==arr2[j])break;
                 i++;
             }
             while(s.size()>0&&j<arr2.length&&i<arr1.length){
                 if(s.peek()==arr2[j]){
                     s.pop();
                     j++;
                 }else{
                     break;
                 }
            }
             i++;
         }
         return s.size()>0?0:1;
    }
}
        
