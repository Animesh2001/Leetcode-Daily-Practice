class MinStack {
    Stack<Integer> allData;
    Stack<Integer> minData;

    public MinStack() {
        allData = new Stack<>();
        minData = new Stack<>();
    }

    public void push(int val) {
        if (allData.size() == 0) {
            allData.push(val);
            minData.push(val);
        } else {
            allData.push(val);
            if (minData.peek() >= val) {
                minData.push(val);
            }
        }
    }

    public void pop() {
        int popped = allData.pop();
        if (minData.peek() == popped) {
            minData.pop();
        }
    }

    public int top() {
        return allData.peek();
    }

    public int getMin() {
        return minData.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
