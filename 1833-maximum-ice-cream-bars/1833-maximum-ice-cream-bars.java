class Solution {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int cost = 0;
        int count = 0;
        for (int i = 0; i < costs.length; i++) {
            if ( (costs[i]) + cost <= coins) {
                cost += costs[i];
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}
