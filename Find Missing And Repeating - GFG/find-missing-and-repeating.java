//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int xor = 0;
        for(int i:arr)xor^=i;
        
        for(int i=1;i<=arr.length;i++){
            xor^=i;
        }
        
        int rmsb = (xor & -xor);
        int x = 0, y = 0;
        for(int i:arr){
            if((i&rmsb)==0){
                x^=i;
            }else{
                y^=i;
            }
        }
        
        for(int i=1;i<=arr.length;i++){
            if((i&rmsb)==0){
                x^=i;
            }else{
                y^=i;
            }
        }
        
        int count_x=0;
        int count_y=0;
        
        for(int i:arr){
            if(i==x)count_x++;
            if(i==y)count_y++;
        }
        
        if(count_x>count_y){
            return new int[]{x,y};
        }
        
        return new int[]{y,x};
    }
}