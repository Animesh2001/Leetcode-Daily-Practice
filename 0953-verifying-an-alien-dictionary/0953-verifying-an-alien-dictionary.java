class Solution {

    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!words[i].equals(words[i + 1])) {
                for (int j = 0; j < words[i].length(); j++) {
                    if (j == words[i + 1].length()) return false;
                    int ch1 = map.get(words[i].charAt(j));
                    int ch2 = map.get(words[i + 1].charAt(j));
                    if (ch1 > ch2) {
                        return false;
                    } else if (ch1 < ch2) {
                        break;
                    }
                }
            }
        }

        return true;
    }
}
