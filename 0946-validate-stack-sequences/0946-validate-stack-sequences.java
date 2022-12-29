class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int m = popped.length;
        Stack<Integer> st = new Stack<>();
        int pop = 0;
        int push = 0;

        while (push < n && pop < m) {
            st.push(pushed[push]);
            push++;
            while (!st.isEmpty() && st.peek() == popped[pop]) {
                st.pop();
                pop++;
            }
        }
        return st.isEmpty();
    }
}
