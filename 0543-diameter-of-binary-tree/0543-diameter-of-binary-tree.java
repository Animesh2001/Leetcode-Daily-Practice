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
    
    public int height = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int  diameter = 0;
        height(root,diameter);
        return height;
        
    }
    
    
    public int height(TreeNode node, int diameter){
        if(node==null){
            return 0;
        }
        
        int lh = height(node.left,diameter);
        int rh = height(node.right, diameter);
        
        diameter = Math.max(diameter,lh+rh);
        height = Math.max(height,diameter);
        
        return 1+Math.max(lh,rh);
        
        
    }
    
}