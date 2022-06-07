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
    
    public int leftheight(TreeNode root){
        if(root==null){
            return 0;
        }
        return leftheight(root.left)+1;
    }
    
    public int rightheight(TreeNode root){
        if(root==null){
            return 0;
        }
        return rightheight(root.right)+1;
    }
    
    
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        int left = leftheight(root.left);
        int right = rightheight(root.right);
        
        //left and right height are equal direct calculate
        if(left==right){
            return (int)Math.pow(2,left+1)-1;
        }
        
        return countNodes(root.left)+countNodes(root.right)+1;
    }
}