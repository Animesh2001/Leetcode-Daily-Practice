class Solution {

    public boolean isValid(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    public int[][] updateMatrix(int[][] grid) {
        int[][] dist = new int[grid.length][grid[0].length];

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    visited[i][j] = true;
                    queue.add(new int[] { i, j });
                }
            }
        }

        int row[] = new int[] { -1, 0, 1, 0 };
        int col[] = new int[] { 0, 1, 0, -1 };

        int count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- != 0) {
                int arr[] = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int r = arr[0] + row[i];
                    int c = arr[1] + col[i];

                    if (isValid(r, c, grid) && !visited[r][c] && grid[r][c] != 0) {
                        dist[r][c] = count;
                        queue.add(new int[] { r, c });
                        visited[r][c] = true;
                    }
                }
            }

            count++;
        }

        return dist;
    }
}
