class Solution {

    public String removeDuplicates(String s) {
        StringBuilder str = new StringBuilder(s);
        int i = 0, j = i + 1;
        while (j < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                str.deleteCharAt(i);
                str.deleteCharAt(i);
                if (i > 0) {
                    i--;
                }
                j = i + 1;
            } else {
                i++;
                j++;
            }
        }
        return str.toString();
    }
}
