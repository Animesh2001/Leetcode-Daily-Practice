class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalCost = 0, totalGas = 0;

        for (int i = 0; i < n; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
        }

        if (totalGas < totalCost) return -1;

        int gasInTank = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            gasInTank += gas[i % n] - cost[i % n];

            if (gasInTank < 0) {
                start = i + 1;
                gasInTank = 0;
            }
        }

        return gasInTank >= 0 ? start : -1;
    }
}
