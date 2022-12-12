//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    
    public boolean isValid(int row, int col, int[][]grid){
        return row>=0 && row<grid.length && col>=0 && col<grid[0].length;
    } 
    
    public int[][] nearest(int[][] grid)
    {
        // Code here
        
        int [][] dist = new int [grid.length][grid[0].length];
        
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        
        Queue<int[]>queue = new LinkedList<>();
        
        for(int i=0; i<grid.length ;i++){
            for(int j =0 ; j<grid[0].length ; j++){
                if(grid[i][j]==1){
                    visited[i][j]=true;
                    queue.add(new int[]{i,j});
                }
            }
        }
        
        int row [] = new int[]{-1,0,1,0};
        int col [] = new int[]{0,1,0,-1};
        
        int count = 1;
        
        while(!queue.isEmpty()){
           
            
            int size = queue.size();
            
            while(size--!=0){
                int arr[] = queue.poll();
                for(int i=0; i<4; i++){
                    int r = arr[0]+row[i];
                    int c = arr[1]+col[i];
                    
                    if(isValid(r,c,grid)&&!visited[r][c]&&grid[r][c]!=1){
                        dist[r][c] = count;
                        queue.add(new int[]{r,c});
                        visited[r][c]= true;
                    }
                }
            }
            
            count++;
        }
        
        return dist;
    }
}