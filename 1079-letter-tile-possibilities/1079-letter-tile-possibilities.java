class Solution {
    public HashSet<String> set = new HashSet<>();

    public int numTilePossibilities(String tiles) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : tiles.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        f(0, tiles.length(), map, "");
        return set.size();
    }

    public void f(int cl, int tl, HashMap<Character, Integer> map, String asf) {
        if (cl >= tl) {
            if (asf.length() > 0) {
                set.add(asf);
            }
            return;
        }

        for (char ch : map.keySet()) {
            if (map.get(ch) != 0) {
                map.put(ch, map.get(ch) - 1);
                f(cl + 1, tl, map, asf + ch);
                map.put(ch, map.get(ch) + 1);
            }
        }

        f(cl + 1, tl, map, asf);
    }
}
