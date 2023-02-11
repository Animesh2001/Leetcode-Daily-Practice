class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        permuteUnique(map, 1, nums.length, list);
        return ans;
    }

    public void permuteUnique(HashMap<Integer, Integer> map, int cs, int ts, List<Integer> list) {
        if (cs > ts) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int num : map.keySet()) {
            if (map.get(num) > 0) {
                map.put(num, map.get(num) - 1);
                list.add(num);
                permuteUnique(map, cs + 1, ts, list);
                list.remove(list.size() - 1);
                map.put(num, map.get(num) + 1);
            }
        }
    }
}
