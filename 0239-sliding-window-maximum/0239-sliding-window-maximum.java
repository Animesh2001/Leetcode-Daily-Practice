class Solution {

    public int[] get_nge(int nums[]) {
        int nge[] = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            nge[i] = (st.isEmpty()) ? nums.length : st.peek();
            st.push(i);
        }

        return nge;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int nge[] = get_nge(nums);
        int ans[] = new int[nums.length - k + 1];
        int l = 0;
        int i = 0;
        int j = 0;

        while (i <= nums.length - k) {
            int max_size = i + k - 1;
            j = i;
            while (nge[j] <= max_size) {
                j = nge[j];
            }
            ans[l++] = nums[j];
            i++;
        }

        return ans;
    }
}
