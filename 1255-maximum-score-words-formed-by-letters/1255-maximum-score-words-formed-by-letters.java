class Solution {
    public int max = 0;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        HashMap<Character, Integer> letter = new HashMap<>();
        for (int i = 0; i < letters.length; i++) {
            letter.put(letters[i], letter.getOrDefault(letters[i], 0) + 1);
        }
        ArrayList<String> list = new ArrayList<>();
        solve(0, words, list, letter, score);
        return max;
    }

    public boolean isstrvalid(String str, HashMap<Character, Integer> letter, HashMap<Character, Integer> container) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (!letter.containsKey(ch)) return false;
            if (map.get(ch) > letter.get(ch)) return false;
        }
        for (char ch : map.keySet()) {
            if (container.containsKey(ch) && map.get(ch) + container.get(ch) > letter.get(ch)) {
                return false;
            }
        }
        return true;
    }

    public void solve(int i, String[] words, ArrayList<String> list, HashMap<Character, Integer> letter, int[] score) {
        if (i == words.length) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (String str : list) {
                if (isstrvalid(str, letter, map)) {
                    for (char ch : str.toCharArray()) {
                        map.put(ch, map.getOrDefault(ch, 0) + 1);
                        if (map.get(ch) > letter.get(ch)) {
                            return;
                        }
                    }
                }
            }
            int currscore = 0;
            for (char ch : map.keySet()) {
                currscore += (score[ch - 'a'] * map.get(ch));
            }
            max = Math.max(max, currscore);
            return;
        }

        solve(i + 1, words, list, letter, score);
        list.add(words[i]);
        solve(i + 1, words, list, letter, score);
        list.remove(list.size() - 1);
    }
}
