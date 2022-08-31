/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Node cloneGraph(HashMap<Integer,Node>map,Node node){
        if(map.containsKey(node.val))return map.get(node.val);
        Node newNode = new Node(node.val);
        map.put(node.val,newNode);
        for(int i=0;i<node.neighbors.size();i++){
            Node tmp = cloneGraph(map,node.neighbors.get(i));
            newNode.neighbors.add(tmp);
        }
        return newNode;
    }
    
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        HashMap<Integer,Node>map=new HashMap<>();
        Node newNode =  cloneGraph(map,node);
        return newNode;
    }
}