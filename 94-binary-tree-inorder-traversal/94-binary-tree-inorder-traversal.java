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
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer>list=new ArrayList<>();
         TreeNode curr = root;
         Stack<TreeNode>stack=new Stack<>();
        while(curr!=null||!stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }else{
                TreeNode node = stack.pop();
                list.add(node.val);
                curr=node.right;
            }
        }
        return list;
    }
}