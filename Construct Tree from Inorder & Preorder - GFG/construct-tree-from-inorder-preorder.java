//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{
    public static Node buildTree(int inorder[],int preorder[],int instart,int inend,int prestart, int preend,int n){
             if(instart>inend||prestart>preend){
                 return null;
             }
             
             Node root = new Node(preorder[prestart]);
             int find=-1;
             for(int i=instart;i<=inend;i++){
                 if(inorder[i]==preorder[prestart]){
                     find=i;
                     break;
                 }
             }
             if(find==-1){
                 return null;
             }
             
             root.left=buildTree(inorder, preorder, instart, find-1,prestart+1,prestart+(find-instart),n);
             root.right=buildTree(inorder, preorder,find+1,inend,prestart+(find-instart)+1,preend,n);
             return root;
              
              
    }
    
    
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        return buildTree(inorder,preorder,0,n-1,0,n-1,n);
    }
}
