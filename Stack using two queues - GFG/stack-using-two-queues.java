// { Driver Code Starts
import java.util.*;


class StackUsingQueues
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			Queues g = new Queues();
			
			int q = sc.nextInt();
			while(q>0)
			{
				int QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					g.push(a);
				}
				else if(QueryType == 2)
				System.out.print(g.pop()+" ");
			q--;
			}	
			System.out.println();
				
			
			
		t--;
		}
	}
}

// } Driver Code Ends



class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    //Function to push an element into stack using two queues.
    void push(int a)
    {
	    // Your code here	
	    q1.add(a);
    }
    
    //Function to pop an element from stack using two queues. 
    int pop()
    {
	    // Your code here
	    int ans=-1;
	    while(q1.size()>1){
	        q2.add(q1.remove());
	    }
	    if(q1.size()==1)ans=q1.remove();
	    Queue<Integer>temp=q1;
	    q1=q2;
	    q2=temp;
	    return ans;
	    
    }
	
}

