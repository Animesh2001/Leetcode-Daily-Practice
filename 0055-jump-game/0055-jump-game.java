class Solution {

    public boolean f(int i, int nums[], int dp[]) {
        if (i >= nums.length - 1) {
            return true;
        }
        if (nums[i] == 0) {
            dp[i] = 0;
            return false;
        }
        if (dp[i] != -1) {
            return dp[i] == 1;
        }

        for (int step = 1; step <= nums[i]; step++) {
            boolean ans = f(i + step, nums, dp);
            if (ans == true) {
                dp[i + step] = 1;
                return true;
            }
        }
        dp[i] = 0;
        return false;
    }

    public boolean canJump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return f(0, nums, dp);
    }
}
