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
         Stack<Integer>s=new Stack<>();
         int j=0;
         
         for(int i=0;i<arr1.length;i++){
             //push the elements of arr1 as they come
             s.push(arr1[i]);
             
             
             //check if stack top is equal to arr2[j] and pop it till its same
             while(!s.isEmpty()&&s.peek()==arr2[j]){
                 s.pop();
                 j++;
             }
         }
         
         //at last if something is remaining on the stack then false or else return true
         return s.size()==0?1:0;
    }
}
        
