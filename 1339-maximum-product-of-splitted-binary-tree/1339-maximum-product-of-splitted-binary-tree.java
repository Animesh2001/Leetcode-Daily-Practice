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
    public long ans;

    public long fSum(TreeNode root) {
        if (root == null) return 0;
        return fSum(root.left) + fSum(root.right) + (long) root.val;
    }

    public long fGetSubtreeSum(TreeNode root, long total_sum) {
        if (root == null) return 0;
        long left = fGetSubtreeSum(root.left, total_sum);
        long right = fGetSubtreeSum(root.right, total_sum);
        long ss = left + right + root.val;
        ans = Math.max(ans, (ss) * (total_sum - ss));
        return ss;
    }

    public int maxProduct(TreeNode root) {
        long total_sum = fSum(root);
        fGetSubtreeSum(root, total_sum);
        return (int) (ans % (int) (Math.pow(10, 9) + 7));
    }
}
