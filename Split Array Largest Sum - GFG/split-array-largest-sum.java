//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    
     static boolean isSplitPossible(int mid, int[] nums, int s) {
        int curr_sum = 0;
        int sa = 1;
        for (int i = 0; i < nums.length; i++) {
            curr_sum += nums[i];
            if (curr_sum > mid) {
                sa++;
                curr_sum = nums[i];
            }
        }

        return sa <= s;
    }
    
    static int splitArray(int[] nums , int N, int m) {
        // code here
        
        int lo = Integer.MIN_VALUE;

        int hi = 0;

        for (int elem : nums) {
            lo = Math.max(lo, elem);
            hi += elem;
        }

        int ans = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (isSplitPossible(mid, nums, m)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
        
    }
};