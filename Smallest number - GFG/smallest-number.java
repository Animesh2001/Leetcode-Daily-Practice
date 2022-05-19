// { Driver Code Starts
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
            String[] inp=read.readLine().split(" ");
            int S=Integer.parseInt(inp[0]);
            int D=Integer.parseInt(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.smallestNumber(S,D));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution{
    static String smallestNumber(int S, int D){
        // code here
         if(D==1&&S<=9){
            return String.valueOf(S);
        }
        if(D==1&&S>9){
            return "-1";
        }
        String str = "";
        while(S>9&&D>0){
            D--;
            str="9"+str;
            S-=9;
        }
        if(D==0){
            if(S==0)return str;
            else return "-1";
        }
        if(D==1){
            str=String.valueOf(S)+str;
            return str;
        }
        int first = 1;
        int second = S-1;
        str= String.valueOf(second)+str;
        D--;
        for(int i=1;i<D;i++){
            str="0"+str;
        }
        str=String.valueOf(1)+str;
        return str;
    
    }
}