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
    public List<Integer> postorderTraversal(TreeNode root) {
       Stack<TreeNode>stack1=new Stack<>();
       Stack<Integer>stack2=new Stack<>();
        List<Integer>list=new ArrayList<>();
        if(root==null)return list;
       stack1.push(root);
       while(!stack1.isEmpty()){
           TreeNode popped= stack1.pop();
           stack2.push(popped.val);
           if(popped.left!=null)stack1.push(popped.left);
           if(popped.right!=null)stack1.push(popped.right);
       }
        
        while(!stack2.isEmpty()){
            list.add(stack2.pop());
        }
        return list;
    }
}