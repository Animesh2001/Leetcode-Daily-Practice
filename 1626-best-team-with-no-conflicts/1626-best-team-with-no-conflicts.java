class Solution {

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int[][] ageScorePair = new int[n][2];

        for (int i = 0; i < n; i++) {
            ageScorePair[i][0] = ages[i];
            ageScorePair[i][1] = scores[i];
        }

        Arrays.sort(ageScorePair, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int ans = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int curPlayer = ageScorePair[i][1];
            dp[i] = curPlayer;
            for (int j = 0; j < i; j++) {
                if (ageScorePair[j][1] <= ageScorePair[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + ageScorePair[i][1]);
                }
            }
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}
