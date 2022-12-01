class Solution {

    public int count_vowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (
                str.charAt(i) == 'a' ||
                str.charAt(i) == 'e' ||
                str.charAt(i) == 'i' ||
                str.charAt(i) == 'o' ||
                str.charAt(i) == 'u' ||
                str.charAt(i) == 'A' ||
                str.charAt(i) == 'E' ||
                str.charAt(i) == 'I' ||
                str.charAt(i) == 'O' ||
                str.charAt(i) == 'U'
            ) {
                count++;
            }
        }
        return count;
    }

    public boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;

        int first_half_vowels = count_vowels(s.substring(0, mid));
        int second_half_vowels = count_vowels(s.substring(mid, s.length()));

        return first_half_vowels == second_half_vowels;
    }
}
