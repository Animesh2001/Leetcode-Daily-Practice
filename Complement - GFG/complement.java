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
            String str = br.readLine().trim();

            Vector<Integer> ans = new Solve().findRange(str, n);
            if (ans.size() == 1) {
                System.out.println(ans.get(0));
            } else {
                System.out.println(ans.get(0) + " " + ans.get(1));
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solve {

    Vector<Integer> findRange(String str, int n) {
        // code here
        int count = 0;
        int l = -1;
        int r = -1;
        int max = 0;
        int ansL = -1;
        int ansR = -1;
        
        for(int i=0; i<n; i++){
            if(str.charAt(i)=='0'){
                count++;
            }
            else{
                count--;
                if(count<0){
                    count = 0;
                    l = -1;
                }
            }
            
            if(count==1&&l==-1){
                l=i;
            }
            
            
            if(count > max ){
                max = count;
                ansL = l;
                ansR = i;
            }
            
        }
        
        Vector<Integer>vector = new Vector<>();
        if(ansL==-1){
            vector.add(-1);
        }else{
            vector.add(ansL+1);
            vector.add(ansR+1);
        }
        
        return vector;
        
    }
}