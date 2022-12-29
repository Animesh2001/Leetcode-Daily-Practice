class Solution {

    public String minRemoveToMakeValid(String str) {
        StringBuilder s = new StringBuilder(str);
        Stack<int[]> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(new int[] { 1, i });
            } else if (s.charAt(i) == ')') {
                if (!st.isEmpty() && st.peek()[0] == 1) {
                    st.pop();
                } else {
                    st.push(new int[] { -1, i });
                }
            }
        }
        while (!st.isEmpty()) {
            s.deleteCharAt(st.pop()[1]);
        }

        return s.toString();
    }
}
