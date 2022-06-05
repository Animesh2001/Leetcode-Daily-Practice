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
    
    public List<Integer> rightSideView(TreeNode root) {
        Queue<Pair>queue=new LinkedList<>();
        List<Integer>list=new ArrayList<>();
        Map<Integer,Integer>map=new TreeMap<>();
        queue.add(new Pair(root,0));
        if(root==null)return list;
        
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            map.put(p.i,p.node.val);
            if(p.node.left!=null)queue.add(new Pair(p.node.left,p.i+1));
            if(p.node.right!=null)queue.add(new Pair(p.node.right,p.i+1));
        }
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
}