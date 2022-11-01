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
     public boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null||right==null){
            return left==right;
        }
        if(left.val==right.val){
            boolean l = isSymmetric(left.left,right.right);
            boolean r = isSymmetric(left.right,right.left);
            return l&&r;
        }
        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        
        return isSymmetric(root.left,root.right);
    }
}