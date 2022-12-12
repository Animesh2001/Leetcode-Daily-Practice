class Solution {

    public int longestSquareStreak(int[] nums) {
        HashMap<Long, Integer> map = new HashMap<>();

        for (int elem : nums) {
            map.put((long) elem, 1);
        }

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            long square = (long) (nums[i] * nums[i]);
            int count = 1;
            while (map.containsKey(square)) {
                count++;
                square = square * square;
            }
            ans = Math.max(ans, count);
        }

        return ans < 2 ? -1 : ans;
    }
}
