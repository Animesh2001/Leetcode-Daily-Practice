class Solution {

    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int numofinsertions = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (st.isEmpty()) {
                    st.push(c);
                } else {
                    if (st.peek() != '(') {
                        numofinsertions++;
                        st.pop();
                        st.pop();
                    }
                    st.push(c);
                }
            } else {
                if (st.isEmpty()) {
                    numofinsertions++;
                    st.push('(');
                    st.push(c);
                } else {
                    if (st.peek() != '(') {
                        st.pop();
                        st.pop();
                    } else {
                        st.push(c);
                    }
                }
            }
        }

        if (st.isEmpty()) {
            return numofinsertions;
        } else {
            while (!st.isEmpty()) {
                char c = st.pop();
                if (c == '(') {
                    numofinsertions += 2;
                } else {
                    numofinsertions++;
                    st.pop(); //for '('
                }
            }
        }

        return numofinsertions;
    }
}
