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
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
      public boolean compare(HashMap<Character, Integer> smap, HashMap<Character, Integer> pmap) {
        for (char sch : smap.keySet()) {
            if ((int)pmap.getOrDefault(sch, 0)!=(int)smap.get(sch)) {
                return false;
            }
        }
        return true;
    }

    public int findAnagrams(String s, String p) {
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> pmap = new HashMap<>();
        int count = 0;
        
        if(p.length()>s.length())return 0;
        
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < p.length(); i++) {
            char ch = s.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
        }

        int j = 0;
        int i = p.length();

        while (i < s.length()) {
            if (compare(pmap, smap)) {
                count++;
            }
            char cha = s.charAt(i);
            smap.put(cha, smap.getOrDefault(cha, 0) + 1);

            char chr = s.charAt(i - p.length());
            if (smap.get(chr) == 1) {
                smap.remove(chr);
            } else {
                smap.put(chr, smap.get(chr) - 1);
            }
            i++;
        }

        if (compare(pmap, smap)) {
            count++;
        }
        
        return count;
    }

    int search(String pat, String txt) {
        // code here
        
        return findAnagrams(txt,pat);
    }
}