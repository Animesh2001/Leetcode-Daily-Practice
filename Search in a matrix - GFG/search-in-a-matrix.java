// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int mat[][] = new int[n][m];
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                  mat[i][j] = sc.nextInt();
            }
            
            int x = sc.nextInt();
            
            System.out.println (new Sol().matSearch(mat, n, m, x));
        }
        
    }
}// } Driver Code Ends


class Sol
{
    public static int matSearch(int matrix[][], int N, int M, int target)
    {
        // your code here
        int r = 0, c = matrix[0].length - 1;
		while (r <= matrix.length - 1 && c >= 0) {
			if (target == matrix[r][c]) return 1;
			else if (matrix[r][c] > target) c--;
			else r++;
		}
		return 0;
    }
}