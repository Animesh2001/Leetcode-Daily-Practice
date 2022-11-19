//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
    
    public static Node buildTree(String str)
    {
        // Corner Case
        if(str.length()==0 || str.charAt(0)=='N')
            return null;
        
        // Creating array of Strings from input 
        // String after spliting by space
        String ip[] = str.split(" ");
        
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        
        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        
        // Starting from the second element
        int i = 1;
        while(queue.size()>0 && i < ip.length)
        {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N"))
            {
                    
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
            if(!currVal.equals("N"))
            {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
    public static Node inputTree(BufferedReader br) throws IOException
    {
        return buildTree(br.readLine().trim());
    }
    
    public static void inorder(Node root)
    {
        if (root == null)
           return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            Node node1 = Node.inputTree(br);
            
            
            Node node2 = Node.inputTree(br);
            
            Solution obj = new Solution();
            boolean res = obj.areAnagrams(node1, node2);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static boolean areAnagrams(Node node1, Node node2) {
        // code here
        Queue<Node>queue1=new LinkedList<>();
        Queue<Node>queue2=new LinkedList<>();
        if(node1==null&&node2!=null||node1!=null&&node2==null){
            return false;
        }
        queue1.add(node1);
        queue2.add(node2);
        
        
        
        HashMap<Integer,Integer>map=new HashMap<>();
        
        while(queue1.size()>0&&queue2.size()>0){
            
            int size1 = queue1.size();
            for(int i=0;i<size1;i++){
                Node temp = queue1.poll();
                map.put(temp.data,map.getOrDefault(temp.data,0)+1);
                if(temp.left!=null)queue1.add(temp.left);
                if(temp.right!=null)queue1.add(temp.right);
            }
            
            int size2=queue2.size();
            for(int i=0;i<size2;i++){
                Node temp = queue2.poll();
                if(!map.containsKey(temp.data)){
                    return false;
                }
                int f = map.get(temp.data);
                if(f==1){
                    map.remove(temp.data);
                }else{
                    map.put(temp.data,f-1);
                }
                if(temp.left!=null)queue2.add(temp.left);
                if(temp.right!=null)queue2.add(temp.right);
            }
            
            if(map.size()>0)return false;
            
        }
        
        if(map.size()==0&&queue1.size()==0&&queue2.size()==0){
            return true;
        }
        
        return false;
        
        
    }
}
        
