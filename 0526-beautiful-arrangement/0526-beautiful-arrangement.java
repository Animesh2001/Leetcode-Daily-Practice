class Solution {
    public int count = 0;

    public int countArrangement(int n) {
        int arr[] = new int[n + 1];
        f(1, n+1, arr);
        return count;
    }

    public void f(int cl, int tl, int arr[]) {
        if (cl == tl) {
            count++;
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0 && (i % cl == 0 || cl % i == 0)) {
                arr[i] = cl;
                f(cl + 1, tl, arr);
                arr[i] = 0;
            }
        }
    }
}
