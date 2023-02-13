class Solution {

    public int countOdds(int low, int high) {
        int length = high - low + 1;
        if ((length & 1) != 1) return length / 2;
        if ((low & 1) == 1) return (length / 2) + 1;
        else return length / 2;
    }
}
