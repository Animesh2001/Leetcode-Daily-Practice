// { Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SpeStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			Stack<Integer> s=new Stack<>();
			GfG g=new GfG();
			while(!g.isEmpty(s)){
			    g.pop(s);
			}
			while(!g.isFull(s,n)){
				g.push(sc.nextInt(),s);
			}
		System.out.println(g.min(s));
		}
	}
}// } Driver Code Ends


/*Complete the function(s) below*/
class GfG{
    static int m=Integer.MAX_VALUE;
	public void push(int a,Stack<Integer> s)
	   {
	    //add code here.
	        s.push(a);
	    }
	public int pop(Stack<Integer> s)
        {
            //add code here.
            return !s.isEmpty()?s.pop():-1;
	    }
	public int min(Stack<Integer> stack)
        {
           //add code here.
           int temp=stack.peek();
           while(!stack.isEmpty()){
               if(temp>stack.peek())temp=stack.peek();
               stack.pop();
           }
           return temp;
           
	    }
	public boolean isFull(Stack<Integer>s, int n)
        {
           //add code here.
           return s.size()==n;
	    }
	public boolean isEmpty(Stack<Integer>s)
        {
           //add code here.
           return s.isEmpty();
	    }
}