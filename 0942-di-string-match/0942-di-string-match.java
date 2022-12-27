class Solution {

    public int[] diStringMatch(String pattern) {
        int ans[] = new int[pattern.length() + 1];
        int k = 0;
        Stack<Integer> st = new Stack<>();
        int num = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'D') {
                st.push(num);
                num++;
            } else {
                st.push(num);
                num++;
                while (!st.isEmpty()) {
                    ans[k++] = st.pop();
                }
            }
        }
        st.push(num);
        while (!st.isEmpty()) {
            ans[k++] = st.pop();
        }
        return ans;
    }
}
