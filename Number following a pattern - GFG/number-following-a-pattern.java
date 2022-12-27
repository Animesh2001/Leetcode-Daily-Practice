//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String pattern){
        // code here
         String ans = "";
        Stack<Integer> st = new Stack<>();
        int num = 1;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'D') {
                st.push(num);
                num++;
            } else {
                st.push(num);
                num++;
                while (!st.isEmpty()) {
                    ans += st.pop();
                }
            }
        }
        st.push(num);
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }
}
