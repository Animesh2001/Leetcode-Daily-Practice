//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static boolean isValid(int row, int col, char[][] board) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

    static void dfs(boolean visited[][], int row, int col, char[][] board) {
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
    
    static char[][] fill(int n, int m, char board[][])
    {
        // code here
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
        
        return board;

    }
}