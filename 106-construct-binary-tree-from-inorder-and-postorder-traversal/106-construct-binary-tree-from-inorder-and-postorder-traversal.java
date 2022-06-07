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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer>map=new HashMap<>();
        
        for(int i=0;i<inorder.length;i++)map.put(inorder[i],i);
        
        return buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
    }
    
    public TreeNode buildTree(int postorder[], int poststart, int postend, int[] inorder,int instart,int inend,Map<Integer,Integer>map){
        if(poststart>postend||instart>inend){
            return null;
        }
        
        TreeNode node = new TreeNode(postorder[postend]);
        int i = map.get(postorder[postend]);
        int diff = i-instart;
        node.left=buildTree(postorder,poststart,poststart+diff-1,inorder,instart,i-1,map);
        node.right=buildTree(postorder,poststart+diff,postend-1,inorder,i+1,inend,map);
        
        return node;
    }
}