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

//first check if leftheight and rightheight are equal return 2^height-1 as it is complete tree

//else separately count the nodes for left subtree + right subtree + 1 for root and return

//also take care of functions left height and right height

// TC is O((logn)^2) ->
//for traversing the height of tree at any instance will not be more than log(n) Complete Tree
//at max you will travel for logn nodes

// SC is O(log(n)) ->
//height of the tree at max can go upto log(n) not more than that as complete tree can't be skew trees.

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