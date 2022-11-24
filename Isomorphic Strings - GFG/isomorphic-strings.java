//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
    {
        // Your code here
        if(str1.length()!=str2.length())return false;
        HashMap<Character,Character>map1 = new HashMap<>();
        for(int i=0;i<str1.length();i++){
            char ch = str1.charAt(i);
            if(!map1.containsKey(ch)){
                map1.put(ch,str2.charAt(i));
            }
            else{
                char chm = map1.get(ch);
                if(chm!=str2.charAt(i)){
                    return false;
                }
            }
        }
        
        HashMap<Character,Character>map2=new HashMap<>();
        for(int i=0;i<str2.length();i++){
            char ch = str2.charAt(i);
            if(!map2.containsKey(ch)){
                map2.put(ch,str1.charAt(i));
            }
            else{
                char chm = map2.get(ch);
                if(chm!=str1.charAt(i)){
                    return false;
                }
            }
        }
        
        for(char ch:map2.keySet()){
            char chm = map2.get(ch);
            char chmap1 = map1.get(chm);
            if(chmap1!=ch){
                return false;
            }
        }
        
        return true;
        
    }
}