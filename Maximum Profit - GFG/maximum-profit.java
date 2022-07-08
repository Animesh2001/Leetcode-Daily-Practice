// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxProfit(int k, int n, int a[]) {
        // code here
        int[][][] dp=new int[n+1][2][k+1];
        
        for(int i=0; i<=n; i++){
            for(int b=0; b<=1; b++){
                dp[i][b][0] = 0;
            }
        }
        
        for(int b=0; b<=1; b++){
            for(int cap=0; cap<=k; cap++){
                dp[n][b][cap] = 0;
            }
        }
        
        for(int i=n-1; i>=0; i--){
            for(int b=0; b<=1; b++){
                for(int cap=1; cap<=k; cap++){
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
        
        return dp[0][1][k];
    }
}