class Solution {

    public void reverse(int arr[], int i, int j) {
        int li = i;
        int ri = j;

        while (li < ri) {
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;
            li++;
            ri--;
        }

        return;
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        //reverse part1
        reverse(nums, 0, n - k - 1);

        //reverse part2
        reverse(nums, n - k, n - 1);

        //reverse whole array
        reverse(nums, 0, n - 1);
    }
}
