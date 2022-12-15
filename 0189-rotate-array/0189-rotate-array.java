class Solution {

    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n;

        ArrayList<Integer> list = new ArrayList<>();
        if (k != 0) {
            int diff = n - k;

            for (int i = diff; i < n; i++) {
                list.add(nums[i]);
            }

            for (int i = 0; i < diff; i++) {
                list.add(nums[i]);
            }
            int j = 0;
            for (int elem : list) {
                nums[j++] = elem;
            }
        }
        return;
    }
}
