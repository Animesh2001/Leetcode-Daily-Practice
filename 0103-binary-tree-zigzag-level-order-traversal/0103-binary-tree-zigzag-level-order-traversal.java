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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        Queue<TreeNode>queue=new LinkedList<>();
        List<List<Integer>>list=new ArrayList<>();
        if(root==null)return list;
        queue.add(root);
        //maintain a flag
        int flag=0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer>sublist=new ArrayList<>();
            
            for(int i=0;i<size;i++){
                TreeNode front = queue.poll();
                if(front.left!=null)queue.add(front.left);
                if(front.right!=null)queue.add(front.right);
                //according to flag enter in the sublist
                if(flag==0){
                    sublist.add(front.val);
                }else{
                    sublist.add(0,front.val);
                }
            }
            
            //change the flag
            flag= flag==0?1:0;
            list.add(sublist);
        }
        
        
        return list;
        
    }
}