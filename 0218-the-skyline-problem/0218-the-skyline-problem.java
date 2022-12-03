class Solution {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> points = new ArrayList<>();

        for (int i = 0; i < buildings.length; i++) {
            int[] start = new int[] { buildings[i][0], -buildings[i][2] };
            int[] end = new int[] { buildings[i][1], buildings[i][2] };
            points.add(start);
            points.add(end);
        }

        Collections.sort(
            points,
            (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            }
        );

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<List<Integer>> res = new ArrayList<>();
        int ch = 0;
        pq.add(0);

        for (int i = 0; i < points.size(); i++) {
            int nh = points.get(i)[1];
            if (nh < 0) { //starting
                pq.add(-nh);
            } else {
                pq.remove(nh);
            }

            if (ch != pq.peek()) {
                List<Integer> temp = new ArrayList<>();
                temp.add(points.get(i)[0]);
                temp.add(pq.peek());

                res.add(temp);
                ch = pq.peek();
            }
        }

        return res;
    }
}
