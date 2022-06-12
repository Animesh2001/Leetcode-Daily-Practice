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
    
    public TreeNode searchforparent(TreeNode root,int key){
        if(root==null){
            return null;
        }
        
        if(root.left!=null&&root.left.val==key){
            return root;
        }
        
        if(root.right!=null&&root.right.val==key){
            return root;
        }
        
        TreeNode parent = searchforparent(root.left,key);
        return parent==null?searchforparent(root.right,key):parent;
        
    }
    
//     public TreeNode insert(TreeNode root,int key){
        
//     }
    
    public TreeNode deleteNode(TreeNode root, int key) {
         if(root==null)return null;
        
        if(root.val==key){
             if(root.left!=null){
                    TreeNode temp=root.left;
                    while(temp.right!=null){
                        temp=temp.right;
                    }
                    temp.right=root.right;
                    root=root.left;
                }
                else{
                    root=root.right;
                }
        }
        
        
        TreeNode parent = searchforparent(root,key);
        if(parent!=null){
            if(parent.left!=null&&parent.left.val==key){
                if(parent.left.left!=null){
                    TreeNode temp=parent.left.left;
                    while(temp.right!=null){
                        temp=temp.right;
                    }
                    temp.right=parent.left.right;
                    parent.left=parent.left.left;
                }
                else{
                    parent.left=parent.left.right;
                }
            }
            else if(parent.right.val==key){
                 if(parent.right.left!=null){
                    TreeNode temp=parent.right.left;
                    while(temp.right!=null){
                        temp=temp.right;
                    }
                    temp.right=parent.right.right;
                    parent.right=parent.right.left;
                }
                else{
                    parent.right=parent.right.right;
                }
            }
        }
        return root;
    }
}