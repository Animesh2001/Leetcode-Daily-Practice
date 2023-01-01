class Solution {

    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Integer> check = new HashMap<>();
        String[] arr = s.split(" ");

        if (arr.length != pattern.length()) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(arr[i])) {
                    return false;
                }
            } else {
                if (check.containsKey(arr[i])) {
                    return false;
                }
                map.put(ch, arr[i]);
                check.put(arr[i], 1);
            }
        }

        return true;
    }
}
