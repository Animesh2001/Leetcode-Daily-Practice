//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int numerator = Integer.parseInt(S[0]);
            int denominator = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            String ans = ob.fractionToDecimal(numerator, denominator);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String  fractionToDecimal(int numerator, int denominator)
    {
        // code here
        int quotient = numerator/denominator;
        
        int remainder = numerator%denominator;
        
        StringBuilder str = new StringBuilder();
        str.append(quotient);
        
        if(remainder==0){
            return str.toString();
        }
        else{
            str.append('.');
            HashMap<Integer,Integer>map=new HashMap<>();
            while(remainder!=0){
                if(map.containsKey(remainder)){
                    int index = map.get(remainder);
                    str.insert(index,'(');
                    str.append(')');
                    break;
                }else{
                    map.put(remainder,str.length());
                    remainder=remainder*10;
                    quotient=remainder/denominator;
                    remainder = remainder%denominator;
                    str.append(quotient);
                    
                }
            }
        }
        
        return str.toString();
        
        
           
        
    }
}