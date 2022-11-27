class Solution {

    public int bestClosingTime(String customers) {
        int n = customers.length();
        int prev_n[] = new int[n];
        int next_y[] = new int[n];
        int cnt_n = 0;
        int cnt_y = 0;
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'N') {
                cnt_n++;
            }
            prev_n[i] = cnt_n;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (customers.charAt(i) == 'Y') {
                cnt_y++;
            }
            next_y[i] = cnt_y;
        }

        int min_penalty = Integer.MAX_VALUE;
        int min_penalty_index = -1;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (next_y[i] < min_penalty) {
                    min_penalty = next_y[i];
                    min_penalty_index = i;
                }
                continue;
            }
            int count_no = prev_n[i - 1];
            int count_yes = next_y[i];

            int ans = count_no + count_yes;
            if (ans < min_penalty) {
                min_penalty = ans;
                min_penalty_index = i;
            }
        }

        if (cnt_n < min_penalty) {
            min_penalty_index = n;
        }

        return min_penalty_index;
    }
}
