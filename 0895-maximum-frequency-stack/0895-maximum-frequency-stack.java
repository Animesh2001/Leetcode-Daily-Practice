class FreqStack {

    Map<Integer,Stack>psm;
    Map<Integer,Integer>fm;
    int max_freq = 0;
    public FreqStack() {
        psm = new HashMap<>();
        fm = new HashMap<>();
    }
    
    public void push(int val) {
        fm.put(val,fm.getOrDefault(val,0)+1);
        max_freq = Math.max(max_freq,fm.get(val));
        int cf = fm.get(val);
        if(!psm.containsKey(cf)){
            Stack <Integer> stack = new Stack<>();
            stack.push(val);
            psm.put(cf,stack);
        }else{
            psm.get(cf).push(val);
        }
    }
    
    public int pop() {
        Stack<Integer>stack = psm.get(max_freq);
        int elem = stack.peek();
        stack.pop();
        fm.put(elem,fm.get(elem)-1);
        if(psm.get(max_freq).isEmpty()){
            psm.remove(max_freq);
            max_freq--;
        }
        return elem;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */