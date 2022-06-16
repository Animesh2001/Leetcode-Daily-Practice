// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}// } Driver Code Ends



class Solution
{
    public static class Pair{
        int num;
        int index;
        public Pair(int num,int index){
            this.num=num;
            this.index=index;
        }
    }
    
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        Stack<Pair>stack=new Stack<>();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            if(stack.isEmpty())arr[i]=1;
            else if(stack.peek().num>price[i])arr[i]=1;
            else if(stack.peek().num<=price[i]){
                while(!stack.isEmpty()&&stack.peek().num<=price[i]){
                    stack.pop();
                }
                if(stack.isEmpty())arr[i]=i+1;
                else arr[i]=i-stack.peek().index;
            }
            stack.push(new Pair(price[i],i));
        }
        return arr;
    }
    
}