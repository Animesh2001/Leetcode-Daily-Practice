class Solution {

    class Pair {
        char ch;
        int freq;

        public Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Pair arr[] = new Pair[map.size()];
        int k = 0;
        for (char ch : map.keySet()) {
            int freq = map.get(ch);
            Pair p = new Pair(ch, freq);
            arr[k++] = p;
        }
        Arrays.sort(
            arr,
            (a, b) -> {
                return b.freq - a.freq;
            }
        );

        StringBuilder str = new StringBuilder();

        for (Pair p : arr) {
            char ch = p.ch;
            int freq = p.freq;
            for (int i = 0; i < freq; i++) {
                str.append(ch);
            }
        }
        return str.toString();
    }
}
