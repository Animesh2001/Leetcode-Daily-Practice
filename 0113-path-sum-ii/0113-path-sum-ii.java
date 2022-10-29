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
    
    
    public static void helper(TreeNode root,List<Integer>temp,List<List<Integer>>list,int sum,int target){
        if(root==null)return;
        
        if(root.left==null&&root.right==null){
            temp.add(root.val);
            if(sum+root.val==target){
            	list.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        
        temp.add(root.val);
        if(root.left!=null){
            helper(root.left,temp,list,sum+root.val,target);
            temp.remove(temp.size()-1);
        }
        if(root.right!=null){
             helper(root.right,temp,list,sum+root.val,target);
       		 temp.remove(temp.size()-1);
        }
       
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>list=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        helper(root,temp,list,0,targetSum);
        return list;
    }
}