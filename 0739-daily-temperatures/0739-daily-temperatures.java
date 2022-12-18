class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int n = temperatures.length;
        int ans[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (stack.size() > 0 && stack.peek()[0] <= temperatures[i]) {
                stack.pop();
            }
            if (stack.size() > 0) {
                ans[i] = stack.peek()[1] - i;
            } else {
                ans[i] = 0;
            }

            stack.push(new int[] { temperatures[i], i });
        }

        return ans;
    }
}
