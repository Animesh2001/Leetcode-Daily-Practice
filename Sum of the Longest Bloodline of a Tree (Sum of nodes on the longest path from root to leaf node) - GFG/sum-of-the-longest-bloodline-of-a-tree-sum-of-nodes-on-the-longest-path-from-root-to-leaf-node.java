// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 


class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}

class GFG {
    
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    public static void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
		    String s = br.readLine();
	    	Node root = buildTree(s);
		    Solution obj = new Solution();
		    int res = obj.sumOfLongRootToLeafPath(root);
		    System.out.println(res);
		}
	}
}// } Driver Code Ends


//User function Template for Java

/*
node class of binary tree
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution{
    
    public class Pair{
        int depth;
        int sum;
        
        public Pair(int depth,int sum){
            this.depth=depth;
            this.sum=sum;
        }
    }
    
    public Pair helper(Node root){
        //base case
        if(root==null){
            return new Pair(0,0);
        }
        Pair ans = new Pair(0,0);
        Pair option1 = helper(root.left);
        Pair option2 = helper(root.right);
        
        if(option1.depth>option2.depth){
            return new Pair(option1.depth+1,option1.sum+root.data);
        }
        if(option2.depth>option1.depth){
            ans = new Pair(option2.depth+1,option2.sum+root.data);
        }
        
        if(option1.depth==option2.depth){
            if(option1.sum+root.data>option2.sum+root.data){
                ans = new Pair(option1.depth+1,option1.sum+root.data);
            }else{
                ans = new Pair(option2.depth+1,option2.sum+root.data);
            }
        }
        return ans;
    }
    
    public int sumOfLongRootToLeafPath(Node root)
    {
        //code here
        Pair p = helper(root);
        return p.sum;
        
    }
}