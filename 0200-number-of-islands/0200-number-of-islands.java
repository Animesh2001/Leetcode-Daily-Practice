class Solution {

    public boolean isValid(char[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    public int numIslands(char[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] { i, j });
                    while (!queue.isEmpty()) {
                        int arr[] = queue.poll();
                        int row = arr[0];
                        int col = arr[1];
                        if (isValid(grid, row - 1, col) && grid[row - 1][col] == '1' && !visited[row - 1][col]) {
                            queue.add(new int[] { row - 1, col });
                            visited[row - 1][col] = true;
                        }
                        if (isValid(grid, row + 1, col) && grid[row + 1][col] == '1' && !visited[row + 1][col]) {
                            queue.add(new int[] { row + 1, col });
                            visited[row + 1][col] = true;
                        }
                        if (isValid(grid, row, col - 1) && grid[row][col - 1] == '1' && !visited[row][col - 1]) {
                            queue.add(new int[] { row, col - 1 });
                            visited[row][col - 1] = true;
                        }
                        if (isValid(grid, row, col + 1) && grid[row][col + 1] == '1' && !visited[row][col + 1]) {
                            queue.add(new int[] { row, col + 1 });
                            visited[row][col + 1] = true;
                        }
                    }
                }
            }
        }
        return count;
    }
}
