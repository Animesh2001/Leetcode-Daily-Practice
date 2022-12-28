class MinStack {
    Stack<int[]> allData;
    int min;

    public MinStack() {
        allData = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        allData.push(new int[] { val, min });
        if (val < min) {
            min = val;
        }
    }

    public void pop() {
        int[] popped = allData.pop();
        if (min == popped[0]) {
            min = popped[1];
        }
    }

    public int top() {
        return allData.peek()[0];
    }

    public int getMin() {
        return min;
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
