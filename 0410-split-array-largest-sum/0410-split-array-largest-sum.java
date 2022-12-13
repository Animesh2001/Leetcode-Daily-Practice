class Solution {

    public boolean isSplitPossible(int mid, int[] nums, int s) {
        int curr_sum = 0;
        int sa = 1;
        for (int i = 0; i < nums.length; i++) {
            curr_sum += nums[i];
            if (curr_sum > mid) {
                sa++;
                curr_sum = nums[i];
            }
        }

        return sa <= s;
    }

    public int splitArray(int[] nums, int m) {
        int lo = Integer.MIN_VALUE;

        int hi = 0;

        for (int elem : nums) {
            lo = Math.max(lo, elem);
            hi += elem;
        }

        int ans = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (isSplitPossible(mid, nums, m)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }
}
