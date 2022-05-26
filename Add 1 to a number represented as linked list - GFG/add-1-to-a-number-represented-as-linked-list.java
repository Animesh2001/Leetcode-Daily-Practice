// { Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        Node prev = null;
        Node curr = head;
        Node next=head.next;
        
        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=next;
            if(next!=null){
                next=next.next;
            }
        }
        int carry = 1;
        Node temp = prev;
        int ans1 = carry+temp.data;
        carry=ans1/10;
        int ans2 = ans1%10;
        temp.data=ans2;
        Node temp1=temp;
        temp=temp.next;
        
        while(temp!=null&&carry!=0){
            ans1 = carry+temp.data;
           carry=ans1/10;
             ans2 = ans1%10;
           temp.data=ans2;
            temp1=temp;
           temp=temp.next;
        }
        if(temp==null&&carry!=0){
            Node newNode = new Node(carry);
            temp1.next=newNode;
        }
         head=prev;
         prev = null;
         curr = head;
         next=head.next;
        
        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=next;
            if(next!=null){
                next=next.next;
            }
        }
        return prev;
        
    }
}
