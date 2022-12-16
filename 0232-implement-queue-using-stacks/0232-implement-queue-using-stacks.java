class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int top = -1;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);

        if (s1.size() == 1) {
            top = s1.peek();
        }
    }

    public int pop() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int ans = s2.pop();
        if (s2.size() >= 1) top = s2.peek();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return ans;
    }

    public int peek() {
        return top;
    }

    public boolean empty() {
        return s1.size() == 0;
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
