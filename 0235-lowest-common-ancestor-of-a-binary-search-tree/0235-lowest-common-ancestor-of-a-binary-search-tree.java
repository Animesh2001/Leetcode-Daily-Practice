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
        if(root==null){
            return null;
        }
        if(root.val==a.val||root.val==b.val){
            return root;
        }
        if(a.val<root.val&&b.val>root.val||a.val>root.val&&b.val<root.val){
            TreeNode leftNode = lowestCommonAncestor(root.left,a,b);
            TreeNode rightNode = lowestCommonAncestor(root.right,a,b);
            if(leftNode!=null&&rightNode!=null){
                return root;
            }
            return leftNode==null?rightNode:leftNode;
        }
        if(a.val<root.val&&b.val<root.val){
            return lowestCommonAncestor(root.left,a,b);
        }
            return lowestCommonAncestor(root.right,a,b);
    }
}