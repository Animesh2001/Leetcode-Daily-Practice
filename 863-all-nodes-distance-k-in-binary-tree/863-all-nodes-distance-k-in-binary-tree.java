/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer>list=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        Map<TreeNode,TreeNode>map=new HashMap<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode front = queue.poll();
            if(front.left!=null){
                queue.add(front.left);
                map.put(front.left,front);
            }
            if(front.right!=null){
                queue.add(front.right);
                map.put(front.right,front);
            }
        }
        
        Set<TreeNode>visited=new HashSet();
        visited.add(target);
        queue.add(target);
        while(k>0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode front = queue.poll();
                if(map.containsKey(front)&&!visited.contains(map.get(front))){
                    queue.add(map.get(front));
                    visited.add(map.get(front));
                }
                if(front.left!=null&&!visited.contains(front.left)){
                    queue.add(front.left);
                    visited.add(front.left);
                }
                if(front.right!=null&&!visited.contains(front.right)){
                    queue.add(front.right);
                    visited.add(front.right);
                }
            }
            k--;
        }
        
        while(!queue.isEmpty()){
            list.add(queue.poll().val);
        }
        return list;
    }
}