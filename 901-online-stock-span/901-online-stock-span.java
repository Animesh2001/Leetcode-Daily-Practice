 public class Pair{
        int val;
        int ind;
        
        public Pair(int val,int ind){
            this.val=val;
            this.ind=ind;
        }
    }
    

class StockSpanner {

   
    Stack<Pair>stack=new Stack<Pair>();
    int i=0;
    
    
    public StockSpanner() {
        stack=new Stack<Pair>();
    }
    
    public int next(int price) {
        int ans = 0;
        if(stack.size()==0)ans=i+1;
        else{
            while(stack.size()>0&&stack.peek().val<=price){
                stack.pop();
            }
            if(stack.size()>0){
                ans = i-stack.peek().ind;
            }
            else {
                ans=i+1;
            }
        }
        stack.push(new Pair(price,i));
        i++;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */