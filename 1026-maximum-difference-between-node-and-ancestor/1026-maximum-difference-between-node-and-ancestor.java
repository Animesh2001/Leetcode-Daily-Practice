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
    public static int ans;

    public void f(ArrayList<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        for (int elem : list) {
            int diff = Math.abs(elem - root.val);
            ans = Math.max(ans, diff);
        }
        list.add(root.val);
        f(list, root.left);
        f(list, root.right);
        list.remove(Integer.valueOf(root.val));
    }

    public int maxAncestorDiff(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ans = Integer.MIN_VALUE;
        f(list, root);
        return ans;
    }
}
