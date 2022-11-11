//{ Driver Code Starts
//Initial Template for Java
//Initial Template for Java

//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList; 


// } Driver Code Ends
//User function Template for Java

class Solution
{
    public ArrayList<String> graycode(int n)
    {
        //code here
        if(n==1){
            ArrayList<String>list=new ArrayList<>();
            list.add("0");
            list.add("1");
            return list;
        }
        // if(n==2){
        //     ArrayList<String>list=new ArrayList<>();
        //     list.add("00");
        //     list.add("01");
        //     list.add("11");
        //     list.add("10");
        //     return list;
        // }
        ArrayList<String>ans=graycode(n-1);
        ArrayList<String>final_ans=new ArrayList<>();
        for(int i=0;i<ans.size();i++){
            final_ans.add("0"+ans.get(i));
        }
        for(int i=ans.size()-1;i>=0;i--){
            final_ans.add("1"+ans.get(i));
        }
        return final_ans;
    }
}

//{ Driver Code Starts.

class BitWise
{
	static int n;
	static int k;
	
	// Driver Code
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); //Inputting the testcases
		
		while(t>0) //While testcases exist
		{
			
			n = Integer.parseInt(br.readLine()); //Input N
			
			Solution obj = new Solution();
			
			ArrayList<String> ans=obj.graycode(n);
			for(int i=0;i<ans.size();i++)
			    System.out.print(ans.get(i)+" ");
			    
			System.out.println();
            
            t--;
		}
	}
	
	
}

// } Driver Code Ends