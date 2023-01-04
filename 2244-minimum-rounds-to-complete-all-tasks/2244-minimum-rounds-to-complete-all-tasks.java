class Solution {

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : tasks) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int val : map.values()) {
            if (val == 1) return -1;
            if (val % 3 != 0) {
                count += 1;
            }
            count += val / 3;
        }
        return count;
    }
}
