class Solution {

    public int gcd(int divisor, int dividend) {
        return divisor == 0 ? dividend : gcd(dividend % divisor, divisor);
    }

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcd = gcd(str1.length(), str2.length());

        return str1.substring(0, gcd);
    }
}
