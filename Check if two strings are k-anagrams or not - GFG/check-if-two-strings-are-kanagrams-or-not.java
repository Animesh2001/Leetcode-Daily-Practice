//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
class GFG {
    public static void main(String[] args)
    {   Scanner sc = new Scanner(System.in);
    	int t=sc.nextInt();
    	while(t-->0)
    	{
    		String str1=sc.next();
    		String str2=sc.next();
    		int k=sc.nextInt();
            Solution ob = new Solution();
    		if (ob.areKAnagrams(str1, str2, k) == true)
    			System.out.println("1");
    		else
    			System.out.println("0");
    	}
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        // code here
        HashMap<Character,Integer>s1map=new HashMap<>();
        
        if(s1.length()!=s2.length())return false;
        
        for(int i=0;i<s1.length();i++){
            char chs1 = s1.charAt(i);
            s1map.put(chs1,s1map.getOrDefault(chs1,0)+1);
        }
        
        for(int i=0;i<s2.length();i++){
            char chs2 = s2.charAt(i);
            if(s1map.containsKey(chs2)){
                if(s1map.get(chs2)==1){
                    s1map.remove(chs2);
                }else{
                    s1map.put(chs2,s1map.getOrDefault(chs2,0)-1);
                }
            }
        }
        
        int ans = 0;
        
        for(char ch : s1map.keySet()){
            ans+=s1map.get(ch);
        }
        
        return ans<=k;
        
    }
}