class Solution {

    public String smallestNumber(String pattern) {
        String ans = "";
        Stack<Integer> st = new Stack<>();
        int num = 1;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'D') {
                st.push(num);
                num++;
            } else {
                st.push(num);
                num++;
                while (!st.isEmpty()) {
                    ans += st.pop();
                }
            }
        }
        st.push(num);
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }
}
