class Solution {

    public List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        List<Integer> newlist = new ArrayList<>();
        for (int i : num) temp.add(i);
        int carry = 0;
        int i = temp.size() - 1;
        for (; i >= 0 && k > 0; i--) {
            int f = temp.get(i);
            int s = k % 10;
            k /= 10;
            int ans = f + s + carry;
            carry = ans / 10;
            newlist.add(ans % 10);
        }
        while (i >= 0) {
            int f = temp.get(i);
            int ans = f + carry;
            newlist.add(ans % 10);
            carry = ans / 10;
            i--;
        }
        while (k > 0) {
            int ans = (k % 10) + carry;
            k = k / 10;
            carry = ans/10;
            newlist.add(ans%10);
        }
        while (carry > 0) {
            newlist.add(carry % 10);
            carry = carry / 10;
        }
        Collections.reverse(newlist);
        return newlist;
    }
}
