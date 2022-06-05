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
        TreeNode node;
        int i;
        public Pair(TreeNode node,int i){
            this.node=node;
            this.i=i;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        Queue<Pair>queue=new LinkedList<>();
        queue.add(new Pair(root,0));
        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int min =queue.peek().i;
            int first = 0;
            int last = 0;
            for(int i=0;i<size;i++){
                Pair p = queue.poll();
                if(i==0)first=p.i;
                if(i==size-1)last=p.i; 
                int currid = p.i-min;
                if(p.node.left!=null)queue.add(new Pair(p.node.left,currid*2+1));
                if(p.node.right!=null)queue.add(new Pair(p.node.right,currid*2+2));
            }
            ans=Math.max(ans,(last-first+1));
        }
        return ans;
    }
}