//{ Driver Code Starts
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
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public HashSet<ArrayList<String>> set;
    
    boolean isValid(int row, int col, int[][]grid){
        return row>=0 && row<grid.length && col>=0 && col<grid[0].length;
    }
    
    void dfs(int row, int col, int prow, int pcol, boolean[][]visited, int[][]grid,ArrayList<String>list){
        visited[row][col] = true;
        String str = convert(row-prow,col-pcol);
        list.add(str);
        int r[] = new int[]{0,1,0,-1};
        int c[] = new int[]{1,0,-1,0};
        
        for(int i=0;i<4;i++){
            int newrow = row + r[i];
            int newcol = col + c[i];
            
            if(isValid(newrow,newcol,grid) && !visited[newrow][newcol] && grid[newrow][newcol]==1){
                dfs(newrow,newcol,prow,pcol,visited,grid,list);
            }
        }
    }
    
    String convert(int row, int col){
        return Integer.toString(row)+" "+Integer.toString(col);
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        
        int n = grid.length;
        int m = grid[0].length;
    
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        set = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j]&& grid[i][j]==1){
                    ArrayList<String>list=new ArrayList<>();
                    dfs(i,j,i,j,visited,grid,list);
                    set.add(list);
                }
            }
        }
        
        return set.size();
    }
}
