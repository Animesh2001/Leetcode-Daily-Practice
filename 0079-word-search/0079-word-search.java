class Solution {
    
    public boolean isValid(char[][]board,int i,int j){
        int row = board.length;
        int col = board[0].length;
        return i>=0&&i<row&&j>=0&&j<col;
    }

    public boolean f(char[][] board, String word, int wi, int row, int col, boolean visited[][]) {
        if(wi==word.length()-1){
            return true;
        }
        
        visited[row][col]=true;
        
        if(isValid(board,row,col+1)&&!visited[row][col+1]&&board[row][col+1]==word.charAt(wi+1)){
            if(f(board,word,wi+1,row,col+1,visited)){
                return true;
            }
        }
        
        if(isValid(board,row,col-1)&&!visited[row][col-1]&&board[row][col-1]==word.charAt(wi+1)){
            if(f(board,word,wi+1,row,col-1,visited)){
                return true;
            }
        }
        
        if(isValid(board,row-1,col)&&!visited[row-1][col]&&board[row-1][col]==word.charAt(wi+1)){
            if(f(board,word,wi+1,row-1,col,visited)){
                return true;
            }
        }
        
        if(isValid(board,row+1,col)&&!visited[row+1][col]&&board[row+1][col]==word.charAt(wi+1)){
            if(f(board,word,wi+1,row+1,col,visited)){
                return true;
            }
        }
        
        visited[row][col]=false;
        return false;
        
    }

    public boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length];
        for (boolean rows[] : visited) {
            Arrays.fill(rows, false);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(f(board, word, 0, i, j, visited)){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}
