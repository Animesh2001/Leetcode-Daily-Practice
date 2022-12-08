class Solution {

    public boolean isValid(int grid[][], int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int min = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] pop = queue.poll();
                int row = pop[0];
                int col = pop[1];
                if (isValid(grid, row - 1, col) && grid[row - 1][col] == 1) {
                    queue.add(new int[] { row - 1, col });
                    grid[row - 1][col] = 2;
                    fresh--;
                }
                if (isValid(grid, row, col + 1) && grid[row][col + 1] == 1) {
                    queue.add(new int[] { row, col + 1 });
                    grid[row][col + 1] = 2;
                    fresh--;
                }
                if (isValid(grid, row + 1, col) && grid[row + 1][col] == 1) {
                    queue.add(new int[] { row + 1, col });
                    grid[row + 1][col] = 2;
                    fresh--;
                }
                if (isValid(grid, row, col - 1) && grid[row][col - 1] == 1) {
                    queue.add(new int[] { row, col - 1 });
                    grid[row][col - 1] = 2;
                    fresh--;
                }
            }
            if (queue.size() > 0) min++;
        }

        return fresh != 0 ? -1 : min;
    }
}
