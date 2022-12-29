class Solution {

    public int minSwaps(String s) {
        int maxclose = 0;
        int extraclose = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
               extraclose-=1;
            } else {
                extraclose+=1;
            }
            maxclose = Math.max(maxclose, extraclose);
        }
        return ((maxclose + 1)/2 );
    }
}
