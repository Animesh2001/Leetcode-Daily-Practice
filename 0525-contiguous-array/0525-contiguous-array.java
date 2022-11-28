class Solution {

    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0;

        int max_length = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum += -1;
            } else {
                sum += 1;
            }

            if (map.containsKey(sum)) {
                int index = map.get(sum);
                max_length = Math.max(max_length, i - index);
            } else {
                map.put(sum, i);
            }
        }

        return max_length;
    }
}
