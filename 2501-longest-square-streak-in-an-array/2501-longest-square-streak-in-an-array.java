class Solution {

    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer, Integer> map = new HashMap<>();

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int perfect = (int) Math.sqrt(nums[i]);

            if (perfect * perfect == nums[i] && map.containsKey(perfect)) {
                map.put(nums[i], map.get(perfect) + 1);
            } else {
                map.put(nums[i], 1);
            }

            res = Math.max(res, map.get(nums[i]));
        }

        return res < 2 ? -1 : res;
    }
}
