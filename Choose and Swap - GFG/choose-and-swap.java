// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        Solution obj = new Solution();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String A = read.readLine().trim();
            
            String ans = obj.chooseandswap(A);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution{
    
    
    String chooseandswap(String A){
        // Code Here
        
        //ALERT------------------
        //These is the way to write set which use to store in natural order
        SortedSet<Character> set = new TreeSet<>();
        
        //ALERT------------------
        //These is the way to convert a string to character array
       char ch[]= A.toCharArray();
        for(int i=0;i<ch.length;i++){
            set.add(ch[i]);
        }
        
        for(int i=0;i<ch.length;i++){
            set.remove(ch[i]);
            if(set.size()==0)break;
            if(ch[i]>set.first()){
                char ch1 = set.first();
                char ch2 = ch[i];
                
                for(int j=0;j<ch.length;j++){
                    if(ch[j]==ch1){
                       ch[j]=ch2;
                    }else if(ch[j]==ch2){
                        ch[j]=ch1;
                    }
                }
                break;
            }
        }
        
        //These is the way to convert char array to string
        return String.valueOf(ch);
        
    }
    
}