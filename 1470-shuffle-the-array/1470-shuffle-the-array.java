class Solution {

    public int[] shuffle(int[] nums, int n) {
        int arr[] = new int[2 * n];

        int i = 0;
        int j = n;
        int k = 0;
        while (i < n) {
            arr[k++] = nums[i];
            arr[k++] = nums[j];
            i++;
            j++;
        }
        return arr;
    }
}
