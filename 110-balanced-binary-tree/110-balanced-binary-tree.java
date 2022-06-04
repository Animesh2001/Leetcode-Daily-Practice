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
    
    
//if we separately call the recursion for left & right after checking for root only it will be O(n*h) ~ O(n*n) for skew tree.
        
   //OPTIMIZATION O(n*n)~O(n):-
   //In the height function itself check the condition if leftheight-rightheight is greater than 1 then return -1
   //and while calling left and right recursively check if either of the result is -1 then just return -1
   //In our final function check if height==-1 return false else return true
    
    
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        
        // if either of the result is -1 return -1;
        int leftHeight = height(root.left);
        if(leftHeight==-1)return -1;
        int rightHeight = height(root.right);
        if(rightHeight==-1)return -1;
        
        //if difference of height is greater than 1 return -1 instead of height;
        if(Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }
        
        return Math.max(leftHeight,rightHeight)+1;
    }
    
    public boolean isBalanced(TreeNode root) {
        if(height(root)==-1){
            return false;
        }
        return true;
    }
}