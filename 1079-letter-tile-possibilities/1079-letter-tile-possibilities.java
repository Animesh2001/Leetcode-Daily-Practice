class Solution {
    public HashSet<String> set = new HashSet<>();

    public int numTilePossibilities(String tiles) {
        boolean vis[] = new boolean[tiles.length()];

        f(0, tiles.length(), vis, "", tiles);
        return set.size();
    }

    public void f(int cl, int tl, boolean vis[], String asf, String tiles) {
        if (cl >= tl) {
            if (asf.length() > 0) {
                set.add(asf);
            }
            return;
        }

        for (int i = 0; i < tiles.length(); i++) {
            if (!vis[i]) {
                vis[i] = true;
                f(cl + 1, tl, vis, asf + tiles.charAt(i), tiles);
                vis[i] = false;
            }
        }

        f(cl + 1, tl, vis, asf, tiles);
    }
}
