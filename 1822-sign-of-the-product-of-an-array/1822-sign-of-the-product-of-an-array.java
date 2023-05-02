class Solution {

    public int arraySign(int[] nums) {
        int count = 0;
        for (int elem : nums) {
            if (elem == 0) {
                return 0;
            } else if (elem < 0) count++;
        }
        return count % 2 == 0 ? 1 : -1;
    }
}
