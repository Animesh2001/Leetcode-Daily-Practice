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
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String s){
        // code here
        
         int acquire = -1;
        int release = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        char repeating = '\0';
        int size = Integer.MIN_VALUE;
        boolean flag = false;
        while (acquire < s.length() - 1) {
            while (acquire < s.length() - 1 && flag == false) {
                acquire++;
                char ch = s.charAt(acquire);
                if (map.containsKey(ch)) {
                    flag = true;
                    repeating = ch;
                }
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                size = Math.max(size, map.size());
            }

            while (release < acquire && flag == true) {
                release++;
                char ch = s.charAt(release);
                if (ch == repeating) {
                    flag = false;
                }
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            }
        }
        return size == Integer.MIN_VALUE ? 0 : size;
        
    }
}