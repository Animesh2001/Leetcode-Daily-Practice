class Solution {

    public int numRabbits(int[] answer) {
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == 0) {
                count++;
                continue;
            } else if (map.containsKey(answer[i])) {
                int val = map.get(answer[i]);
                if (val == 1) {
                    map.remove(answer[i]);
                } else {
                    map.put(answer[i], map.get(answer[i]) - 1);
                }
            } else {
                count = count + answer[i] + 1;
                map.put(answer[i], answer[i]);
            }
        }

        return count;
    }
}
