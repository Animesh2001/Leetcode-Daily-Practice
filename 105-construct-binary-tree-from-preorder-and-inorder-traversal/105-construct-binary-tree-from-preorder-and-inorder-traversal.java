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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)map.put(inorder[i],i);
        TreeNode root = buildTree(preorder,inorder,map,0,preorder.length-1,0,inorder.length-1);
        
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, Map<Integer,Integer>map,int prestart,int preend,int leftstart, int leftend){
        //if reach the base case return null.
        if(prestart>preend||leftstart>leftend){
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[prestart]);
        int i = map.get(preorder[prestart]);
        int diff = (i-leftstart);
        node.left  = buildTree(preorder,inorder,map,prestart+1,prestart+diff,leftstart,i-1);
        node.right = buildTree(preorder,inorder,map,prestart+diff+1,preend,i+1,leftend);
        
        return node;
    }
}