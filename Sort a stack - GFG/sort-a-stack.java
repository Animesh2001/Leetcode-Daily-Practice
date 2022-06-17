// { Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG{
    
    public void insertAtCorrectPosition(Stack<Integer>s,int x)
    {
        //base case
        //is stack is empty or contains one element
        if(s.isEmpty()||s.peek()<x){
            s.push(x);
            return;
        }
        
        //store the top element
        int top_element=s.pop();
        
        //recursion will put x in its correct sorted position in stack
        insertAtCorrectPosition(s,x);
        
        
        //push the top_element after getting the sorted stack
        s.push(top_element);
        
        return;
        
        
    }
    
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		
		//base case when stack is empty
		if(s.isEmpty()){
		   return s;
		}
		
		//keep the top element
		int top=s.pop();
		
		//recursion will sort the rest elements on the stack in descending order
		s=sort(s);
		
		//we insert the top at its correct position
		insertAtCorrectPosition(s,top);
		
		//at last return the sorted stack
		return s;
	    }
}