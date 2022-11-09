class StockSpanner {

    Stack<int[]>stack;
    
    public StockSpanner() {
        stack=new Stack<>();
    }
    
    public int next(int price) {
        if(stack.isEmpty()||stack.peek()[0]>price){
           stack.push(new int[]{price,1});
            return 1;
        }
            int count=1;
            while(!stack.isEmpty()){
                if(stack.peek()[0]<=price){
                    count+=stack.peek()[1];
                    stack.pop();
                }else{
                    break;
                }
            }
            stack.push(new int[]{price,count});
            return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */