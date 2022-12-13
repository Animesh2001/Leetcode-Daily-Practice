//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
     public boolean isValid(int row, int col, int[][] board) {
            return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
        }
    
        public void dfs(boolean visited[][], int row, int col, int[][] board) {
            visited[row][col] = true;
    
            int r[] = new int[] { -1, 0, 1, 0 };
            int c[] = new int[] { 0, 1, 0, -1 };
    
            for (int i = 0; i < 4; i++) {
                int newrow = row + r[i];
                int newcol = col + c[i];
    
                if (isValid(newrow, newcol, board) && !visited[newrow][newcol] && board[newrow][newcol] == 1) {
                    dfs(visited, newrow, newcol, board);
                }
            }
        }
    int numberOfEnclaves(int[][] board) {

        // Your code here
          int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];

        for (int i = 0; i < m; i++) {
            if (board[0][i] == 1) {
                dfs(visited, 0, i, board);
            }

            if (board[n - 1][i] == 1) {
                dfs(visited, n - 1, i, board);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[j][0] == 1) {
                dfs(visited, j, 0, board);
            }

            if (board[j][m - 1] == 1) {
                dfs(visited, j, m - 1, board);
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    ans++;
                }
            }
        }

        return ans;
    }
}