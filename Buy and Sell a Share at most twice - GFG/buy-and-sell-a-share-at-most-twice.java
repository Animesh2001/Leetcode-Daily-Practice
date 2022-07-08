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
            
            
            int[] price = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);
            
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int f(int ind,int buy,int cap,int []arr,int [][][]dp){
        if(cap==0)return 0;
        if(ind==arr.length)return 0;
        if(dp[ind][buy][cap]!=-1)return dp[ind][buy][cap];
        int profit=0;
        if(buy==1){
            profit = Math.max(-arr[ind]+f(ind+1,0,cap,arr,dp),f(ind+1,1,cap,arr,dp));
        }else{
            profit = Math.max(arr[ind]+f(ind+1,1,cap-1,arr,dp),f(ind+1,0,cap,arr,dp));
        }
        return dp[ind][buy][cap]=profit;
    }
    public static int maxProfit(int n, int[] a) {
        // code here
        //  int n = a.length;
        int[][][] dp=new int[n+1][2][3];
        
        for(int i=0; i<=n; i++){
            for(int b=0; b<=1; b++){
                dp[i][b][0] = 0;
            }
        }
        
        for(int b=0; b<=1; b++){
            for(int cap=0; cap<=2; cap++){
                dp[n][b][cap] = 0;
            }
        }
        
        for(int i=n-1; i>=0; i--){
            for(int b=0; b<=1; b++){
                for(int cap=1; cap<=2; cap++){
                    int profit = 0;
                    
                    if(b==1){
                        int buy = -a[i] + dp[i+1][0][cap];
                        int notBuy = dp[i+1][1][cap];
                        profit = Math.max(buy,notBuy);
                    }else{
                        int sell = a[i] + dp[i+1][1][cap-1];
                        int notSell = dp[i+1][0][cap];
                        profit = Math.max(sell,notSell);
                    }
                    dp[i][b][cap] = profit;
                }
            }
        }
        
        return dp[0][1][2];
    }
}
        
