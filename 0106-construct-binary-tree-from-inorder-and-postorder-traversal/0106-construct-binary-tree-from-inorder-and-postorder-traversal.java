/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   public TreeNode buildTree(int inorder[],int postorder[],int InS,int InE,int postS, int postE){
        if(InS>InE||postS>postE){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postE]);
        
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
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        return buildTree(inorder,postorder,0,n-1,0,n-1);
    }
}