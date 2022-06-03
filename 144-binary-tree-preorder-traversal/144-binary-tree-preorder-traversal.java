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
    public List<Integer> preorderTraversal(TreeNode root) {
        //first print and go to left till you get the null with pushing on stack
        //as soon as got a null pop from stack and pointer point to the right
        //do this same as till in inorder i.e., **!stack.isEmpty()||curr!=null**
        List<Integer>list=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        TreeNode curr = root;
        while(!stack.isEmpty()||curr!=null){
            if(curr!=null){
                list.add(curr.val);
                stack.push(curr);
                curr=curr.left;
            }else{
                TreeNode node = stack.pop();
                curr=node.right;
            }
        }
        return list;
    }
}