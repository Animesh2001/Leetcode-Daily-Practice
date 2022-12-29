class Solution {

    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
            } else if (st.size() > 0 && st.peek() == '(') {
                st.pop();
            } else {
                st.push(')');
            }
        }

        return st.size();
    }
}
