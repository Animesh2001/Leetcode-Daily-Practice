/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        /*
        Approach: For each node in current level,
                  1. Store the first node of next level in a pointer
                  2. Have a pointer that will connect the nodes of next level in a level-order traversal manner
                  3. Move to the next level
        */
        
        
        Node firstNodeOfThisLevel = root;
        
        while(firstNodeOfThisLevel != null){
            
            Node dummyfirstNodeOfNextLevel = new Node(0);                       //Dummy node that will be situated before
                                                                                //first node of next level, with "next" 
                                                                                //pointing to the first node
            
            Node currentNodeOfNextLevel = dummyfirstNodeOfNextLevel;            //Node that will move in the next level
                                                                                //and build the connection
            
            for(Node currentNodeOfThisLevel = firstNodeOfThisLevel;             //For each node in this level
                currentNodeOfThisLevel != null;
                currentNodeOfThisLevel = currentNodeOfThisLevel.next){
                
                if(currentNodeOfThisLevel.left != null){                        //If this level node has left child
                    currentNodeOfNextLevel.next = currentNodeOfThisLevel.left;  //Build the connection
                    currentNodeOfNextLevel = currentNodeOfNextLevel.next;       //Move to next node
                }
                if(currentNodeOfThisLevel.right != null){                       //If this level node has right child
                    currentNodeOfNextLevel.next = currentNodeOfThisLevel.right; //Build the connection
                    currentNodeOfNextLevel = currentNodeOfNextLevel.next;       //Move to next node
                }
            }
            
            firstNodeOfThisLevel = dummyfirstNodeOfNextLevel.next;              //Since this dummy node's "next" points to 
                                                                                //the actual first node of the next level, 
                                                                                //move to it
        }
        
        return root;
    }
}