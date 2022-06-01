// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}


// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    
    static Node merge(Node root,Node fl){
        Node dummy=new Node(-1);
        Node head = dummy;
        Node tail = dummy;
        Node temp1 = root, temp2 = fl;
        
        while(temp1!=null&&temp2!=null){
             if(temp1.data<temp2.data){
                 tail.next=temp1;
                 tail=tail.next;
                 temp1=temp1.next;
             }else{
                 tail.next=temp2;
                 tail=tail.next;
                 temp2=temp2.next;
             }
        }
        if(temp1!=null)tail.next=temp1;
        if(temp2!=null)tail.next=temp2;
        return head.next;
    }
    
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head==null||head.next==null)return head;
        Node slow = head, fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node head2 = slow.next;
        slow.next=null;
        Node part1 = mergeSort(head);
        Node part2 = mergeSort(head2);
        return merge(part1,part2);
        
        
    }
}


