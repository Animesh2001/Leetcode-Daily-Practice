//{ Driver Code Starts
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
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String input)
    {
        // code here
        
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        
        String ans = "";
        
        for(int i = 0; i<input.length(); i++){
            
            char ch = input.charAt(i);
            
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            queue.add(ch);
            
            while(!queue.isEmpty()){
                if(map.get(queue.peek())>1){
                    queue.poll();
                }
                else{
                    ans += queue.peek();
                    break;
                }
            }
            
            if(queue.isEmpty()){
                ans+='#';
            }
        }
        
        return ans;
        
    }
}