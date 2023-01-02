class Solution {

    public boolean detectCapitalUse(String word) {
        int capitals = 0;
        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) capitals++;
        }
        if (capitals == word.length() || capitals == 0) return true;
        return capitals == 1 && Character.isUpperCase(word.charAt(0));
    }
}
