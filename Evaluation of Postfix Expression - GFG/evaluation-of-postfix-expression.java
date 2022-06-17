// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String s)
    {
        // Your code here
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='/'||s.charAt(i)=='*'){
                int op2=stack.pop();
                int op1=stack.pop();
                switch(s.charAt(i)){
                    case '+': stack.push(op1+op2);break;
                    case '*': stack.push(op1*op2);break;
                    case '/': stack.push(op1/op2);break;
                    case '-': stack.push(op1-op2);break;
                }
            }else{
                stack.push(s.charAt(i)-'0');
            }  
        }
        return stack.pop();
    }
    
}