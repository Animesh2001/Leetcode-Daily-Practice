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
        int delete;
        public Pair(int num,int delete){
            this.num=num;
            this.delete=delete;
        }
    }
    
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        Stack<Pair>stack=new Stack<>();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            int popped=1;
            if(stack.isEmpty())arr[i]=popped;
            else if(stack.peek().num>price[i])arr[i]=popped;
            else if(stack.peek().num<=price[i]){
                while(!stack.isEmpty()&&stack.peek().num<=price[i]){
                    popped+=stack.peek().delete;
                    stack.pop();
                }
                arr[i]=popped;
            }
            stack.push(new Pair(price[i],popped));
        }
        return arr;
    }
    
}