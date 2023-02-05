//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku. 
    
    static boolean isValid(int[][] board, int row, int col, int val){
      
      for(int i=0;i<board[0].length; i++){
          if(board[row][i] == val){
              return false;
          }
      }
      
      for(int j=0; j<board.length; j++){
          if(board[j][col] == val){
              return false;
          }
      }
      
      int rk = 3*(row/3);
      int ck = 3*(col/3);
      
      for(int i=rk;i<rk+3; i++){
          for(int j=ck; j<ck+3; j++){
              if(board[i][j]==val){
                  return false;
              }
          }
      }
      
      return true;
  }


 public static boolean solveSudoku(int[][] board, int i, int j) {
    // write yopur code here
    
    //base case
    if(i == 9 && j == 0){
        return true;
    }
    
    else if(j == 9){
        return solveSudoku(board, i+1, 0);
    }
    else if(board[i][j]!=0){
       return solveSudoku(board, i, j+1);
    }
    else{
        for(int val = 1; val<=9; val++){
            if(isValid(board,i,j,val)){
                board[i][j]=val;
                if(solveSudoku(board, i, j+1))return true;
                board[i][j] = 0;
            }
        }
    }
    
    return false;
  }

    
    static boolean SolveSudoku(int board[][])
    {
        // add your code here
        return solveSudoku(board, 0, 0);
        
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int board[][])
    {
        // add your code here
        for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        System.out.print(board[i][j] + " ");
      }
    }
    }
}