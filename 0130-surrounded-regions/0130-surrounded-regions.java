class Solution {

    public boolean isValid(int row, int col, char[][] board) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

    public void dfs(boolean visited[][], int row, int col, char[][] board) {
        visited[row][col] = true;

        int r[] = new int[] { -1, 0, 1, 0 };
        int c[] = new int[] { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int newrow = row + r[i];
            int newcol = col + c[i];

            if (isValid(newrow, newcol, board) && !visited[newrow][newcol] && board[newrow][newcol] == 'O') {
                dfs(visited, newrow, newcol, board);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];

        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                dfs(visited, 0, i, board);
            }

            if (board[n - 1][i] == 'O') {
                dfs(visited, n - 1, i, board);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[j][0] == 'O') {
                dfs(visited, j, 0, board);
            }

            if (board[j][m - 1] == 'O') {
                dfs(visited, j, m - 1, board);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

        return;
    }
}
