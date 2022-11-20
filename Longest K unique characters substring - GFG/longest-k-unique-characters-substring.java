//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int acquire = -1;
        int release = -1;
        
        HashMap<Character,Integer>map=new HashMap<>();
        int ans = -1;
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            
            while(acquire<s.length()-1){
                acquire++;
                char ch = s.charAt(acquire);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.size()>k){
                    break;
                }
                if(map.size()==k)
                ans = Math.max(ans,acquire-release);
                flag1=true;
            }
            
            while(release<acquire){
                release++;
                char ch = s.charAt(release);
                flag2=true;
                if(map.get(ch)==1){
                    map.remove(ch);
                    break;
                }else{
                    map.put(ch,map.get(ch)-1);
                }
                
            }
            
            if(flag1==false&&flag2==false){
                break;
            }
            
        }
        return ans;
    }
}