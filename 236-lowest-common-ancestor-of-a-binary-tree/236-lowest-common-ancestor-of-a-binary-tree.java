/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        
        if(root==null||root==a||root==b)return root;
        
        TreeNode left = lowestCommonAncestor(root.left,a,b);
        TreeNode right = lowestCommonAncestor(root.right,a,b);
        
        if(left==null)return right;
        else if(right==null)return left;
        else return root;
    }
}