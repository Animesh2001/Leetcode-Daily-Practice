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
    
    public class Pair{
        int diameter;
        int height;
        
        public Pair(int diameter,int height){
            this.diameter=diameter;
            this.height=height;
        }
    }
    
    public Pair diameter(TreeNode root){
        if(root==null){
            return new Pair(0,0);
        }
        
        Pair left = diameter(root.left);
        Pair right = diameter(root.right);
        int height=Math.max(left.height,right.height)+1;
        int option1=left.diameter;
        int option2=right.diameter;
        
        int diameter=Math.max((left.height+right.height),Math.max(left.diameter,right.diameter));
        return new Pair(diameter,height);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
      
        Pair p = diameter(root);
        return p.diameter;
        
        
    }
}