//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    Node buildTree(int inorder[],int postorder[],int InS,int InE,int postS, int postE){
        if(InS>InE||postS>postE){
            return null;
        }
        Node root = new Node(postorder[postE]);
        
        int rootIndex = -1;
        for(int i=0;i<=InE;i++){
            if(inorder[i]==postorder[postE]){
                rootIndex=i;
                break;
            }
        }
        if(rootIndex==-1)return null;
        
        int leftInS = InS;
        int leftInE = rootIndex-1;
        int leftpostS = postS;
        int leftpostE = leftpostS+(leftInE-leftInS);
        int rightInS = rootIndex+1;
        int rightInE = InE;
        int rightpostS = leftpostE+1;
        int rightpostE = postE-1;
        
        root.left=buildTree(inorder,postorder,leftInS,leftInE,leftpostS,leftpostE);
        root.right=buildTree(inorder,postorder,rightInS,rightInE,rightpostS,rightpostE);
        return root;
    }
    
    
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        return buildTree(in,post,0,n-1,0,n-1);
    }
}
