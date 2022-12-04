class Solution {

    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int[] prev_avg = new int[n];
        int[] next_avg = new int[n];

        long prev_sum = 0;

        for (int i = 0; i < n; i++) {
            prev_sum += nums[i];
            int avg = (int)(prev_sum / (i + 1));
            prev_avg[i] = avg;
        }

        long next_sum = 0;

        for (int i = n - 1; i >= 0; i--) {
            next_sum += nums[i];
            int avg = (int)(next_sum / (long)(n - i));
            next_avg[i] = avg;
        }

        int min_avg_diff = Integer.MAX_VALUE;
        int min_index = -1;

        for (int i = 0; i < n; i++) {
            int pca = prev_avg[i];
            int nca = 0;
            int ni = n - (n - i - 1);
            if (ni != n) {
                nca = next_avg[ni];
            }
            int abs_diff = Math.abs(pca - nca);
            if (abs_diff < min_avg_diff) {
                min_avg_diff = abs_diff;
                min_index = i;
            }
        }

        return min_index;
    }
}
