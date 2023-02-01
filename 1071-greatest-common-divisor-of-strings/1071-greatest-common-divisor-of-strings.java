class Solution {

    public int lcm(int divisor, int dividend) {
        if (dividend % divisor == 0) {
            return divisor;
        }

        return lcm(dividend % divisor, divisor);
    }

    public String gcdOfStrings(String str1, String str2) {
        int los1 = str1.length();
        int los2 = str2.length();
        int cd = lcm(los1, los2);

        String ds = str1.substring(0, cd);
        boolean flag = true;
        for (int i = 0; i < str1.length(); i += cd) {
            if (!str1.substring(i, i + cd).equals(ds)) {
                return "";
            }
        }

        for (int i = 0; i < str2.length(); i += cd) {
            if (!str2.substring(i, i + cd).equals(ds)) {
                return "";
            }
        }

        return ds;
    }
}
