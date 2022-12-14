class Solution {

    public int f(int i, int[] nums, int dp[]) {
        if (i == nums.length - 1) {
            return nums[i];
        }

        if (dp[i] != -1) return dp[i];

        int pick = nums[i];

        int notpick = Integer.MIN_VALUE;

        if (i + 2 <= nums.length - 1) {
            pick += f(i + 2, nums, dp);
        }

        notpick = f(i + 1, nums, dp);

        return dp[i] = Math.max(pick, notpick);
    }

    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return f(0, nums, dp);
    }
}
