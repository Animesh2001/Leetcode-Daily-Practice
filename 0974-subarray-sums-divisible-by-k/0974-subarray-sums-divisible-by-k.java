class Solution {

    public int subarraysDivByK(int[] arr, int k) {
        int i = 0, currsum = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        while (i < arr.length) {
            currsum += arr[i];
            int rem = currsum % k;
            if (rem < 0) rem += k;
            if (map.containsKey(rem)) {
                count += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
            i++;
        }
        return count;
    }
}
