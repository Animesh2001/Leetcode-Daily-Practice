class Solution {

    public int[][] merge(int[][] intervals) {
        Stack<int[]> st = new Stack<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        st.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int arr[] = intervals[i];
            if (arr[0] <= st.peek()[1]) {
                st.peek()[1] = Math.max(st.peek()[1], arr[1]);
            } else {
                st.push(intervals[i]);
            }
        }
        int ans[][] = new int[st.size()][2];
        int k = st.size() - 1;
        while (!st.isEmpty()) {
            ans[k--] = st.pop();
        }
        return ans;
    }
}
