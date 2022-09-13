class Solution {

    public boolean isValid(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        return true;
    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int[][] fourDirections = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        int min_time = 0;

        while (!queue.isEmpty()) {
            int arr[] = queue.poll();
            min_time = Math.max(min_time, arr[2]);

            for (int i = 0; i < fourDirections.length; i++) {
                int new_row = arr[0] + fourDirections[i][0];
                int new_col = arr[1] + fourDirections[i][1];

               if (isValid(new_row, new_col, grid) && !visited[new_row][new_col] && grid[new_row][new_col] == 1) {
                    grid[new_row][new_col] = 2;
                    queue.add(new int[]{new_row, new_col, arr[2] + 1});
                    visited[new_row][new_col] = true;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return min_time;


    }


}