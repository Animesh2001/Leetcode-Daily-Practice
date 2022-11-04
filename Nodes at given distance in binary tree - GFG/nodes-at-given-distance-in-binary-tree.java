//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    public static Node getTarget(Node root,int target){
        if(root==null){
            return null;
        }
        if(root.data==target){
            return root;
        }
        Node left=getTarget(root.left,target);
        Node right = getTarget(root.right,target);
        return left==null?right:left;
    }
    
    
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
          ArrayList<Integer>list=new ArrayList<>();
        Queue<Node>queue=new LinkedList<>();
        Map<Node,Node>map=new HashMap<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            Node front = queue.poll();
            if(front.left!=null){
                queue.add(front.left);
                map.put(front.left,front);
            }
            if(front.right!=null){
                queue.add(front.right);
                map.put(front.right,front);
            }
        }
        Node temp = getTarget(root,target);
        Set<Node>visited= new HashSet();
        visited.add(temp);
        queue.add(temp);
        while(k>0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node front = queue.poll();
                if(map.containsKey(front)&&!visited.contains(map.get(front))){
                    queue.add(map.get(front));
                    visited.add(map.get(front));
                }
                if(front.left!=null&&!visited.contains(front.left)){
                    queue.add(front.left);
                    visited.add(front.left);
                }
                if(front.right!=null&&!visited.contains(front.right)){
                    queue.add(front.right);
                    visited.add(front.right);
                }
            }
            k--;
        }
        
        while(!queue.isEmpty()){
            list.add(queue.poll().data);
        }
        Collections.sort(list);
        return list;
    }
};