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
            
            int[] a = IntArray.input(br, 3);
            
            
            int[] S1 = IntArray.input(br, a[0]);
            
            
            int[] S2 = IntArray.input(br, a[1]);
            
            
            int[] S3 = IntArray.input(br, a[2]);
            
            Solution obj = new Solution();
            int res = obj.maxEqualSum(a[0],a[1],a[2], S1, S2, S3);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int maxEqualSum(int N1,int N2,int N3, int[] S1, int[] S2, int[] S3) {
        // code here
        int sum1=0,sum2=0,sum3=0;
        int i=0,j=0,k=0;
        
        for(int s:S1){
            sum1+=s;
        }
        
         for(int s:S2){
            sum2+=s;
        }
        
         for(int s:S3){
            sum3+=s;
        }
        
        int min =Math.min(sum1,Math.min(sum2,sum3));
        
        while((sum1!=sum2||sum2!=sum3||sum3!=sum1)&&i<S1.length&&j<S2.length&&k<S3.length){
            while(sum1>min&&i<S1.length){
                sum1-=S1[i];
                i++;
            }
             while(sum2>min&&j<S2.length){
                sum2-=S2[j];
                j++;
            }
             while(sum3>min&&k<S3.length){
                sum3-=S3[k];
                k++;
            }
            min=Math.min(sum1,Math.min(sum2,sum3));
        }
        if(sum1==sum2&&sum2==sum3&&sum3==sum1){
            return min;
        }
        return 0;
    }
}
        
