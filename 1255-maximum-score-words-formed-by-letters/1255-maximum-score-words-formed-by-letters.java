class Solution {

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int freq[] = new int[26];
        for (int i = 0; i < letters.length; i++) {
            freq[letters[i] - 'a']++;
        }
        return solve(words, freq, score, 0);
    }

    public int solve(String words[], int[] freq, int[] score, int idx) {
        if (idx == words.length) {
            return 0;
        }

        int n = 0 + solve(words, freq, score, idx + 1); //No

        int sword = 0;
        boolean flag = true;
        String word = words[idx];
        for (int i = 0; i < word.length(); i++) {
            if (freq[word.charAt(i) - 'a'] == 0) {
                flag = false;
            }
            freq[word.charAt(i) - 'a']--;
            sword += score[word.charAt(i) - 'a'];
        }

        int s = 0;
        if (flag) {
            s = sword + solve(words, freq, score, idx + 1);
        }

        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }

        return Math.max(n, s);
    }
}
