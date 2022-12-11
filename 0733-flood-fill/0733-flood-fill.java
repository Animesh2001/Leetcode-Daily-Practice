class Solution {

    public boolean isValid(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int visited[][] = new int[image.length][image[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { sr, sc });
        visited[sr][sc] = 1;
        int initial = image[sr][sc];
        image[sr][sc] = color;

        int r[] = new int[] { -1, 0, 1, 0 };
        int c[] = new int[] { 0, -1, 0, 1 };

        while (!queue.isEmpty()) {
            int arr[] = queue.peek();
            queue.remove();

            for (int i = 0; i < 4; i++) {
                int row = arr[0] + r[i];
                int col = arr[1] + c[i];

                if (isValid(image, row, col) && image[row][col] == initial && visited[row][col] == 0) {
                    visited[row][col] = 1;
                    image[row][col] = color;
                    queue.add(new int[] { row, col });
                }
            }
        }

        return image;
    }
}
