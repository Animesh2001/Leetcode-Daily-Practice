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
    
    public int height(TreeNode root){
	  if(root==null) return 0;
	  int x=height(root.left);
	  int y=height(root.right);
	  return Math.max(x,y)+1;
  }
    public int diameterOfBinaryTree(TreeNode root) {
        //Your code goes here
		 if(root ==null) return 0;
		 int Lh=height(root.left);
		 int Rh=height(root.right);
         int left_diam = diameterOfBinaryTree(root.left);
         int right_diam = diameterOfBinaryTree(root.right);
		 return Math.max(Lh+Rh,Math.max(left_diam,right_diam));
		 
    }
}