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
    
    public int getMax(TreeNode root){
       if(root.right!=null){
          return getMax(root.right);
       }else{
           return root.val;
       }
    } 
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;
        
        if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }
        else{
            //work
            if(root.left!=null&&root.right!=null){
               int lmax = getMax(root.left);
               root.val=lmax;
               root.left=deleteNode(root.left,lmax);
               return root;
            }else if(root.left!=null){
                return root.left;
            }else if(root.right!=null){
                return root.right;
            }else{
                return null;
            }
        }
        return root;
    }
}