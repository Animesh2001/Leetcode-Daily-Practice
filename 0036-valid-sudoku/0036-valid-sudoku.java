class Solution {

    public boolean isValid(char[][] board, int row_start, int row_end, int col_start, int col_end) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=row_start;i<=row_end;i++){
            for(int j=col_start;j<=col_end;j++){
                char ch = board[i][j];
                if(ch=='.'){
                    continue;
                }
                else if(map.containsKey(ch)){
                    return false;
                }else{
                    map.put(ch,1);
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                if(!isValid(board,i,i+3-1,j,j+3-1)){
                    return false;
                }
            }
        }
        HashMap<Character,Integer>map1;
        HashMap<Character,Integer>map2;
        
        for(int i=0;i<9;i++){
            map1=new HashMap<>();
            map2=new HashMap<>();
            for(int j=0;j<9;j++){
                char ch = board[i][j];
                if(map1.containsKey(ch)){
                    return false;
                }else if(ch!='.'){
                    map1.put(ch,1);
                }
                ch = board[j][i];
                if(map2.containsKey(ch)){
                    return false;
                }else if(ch!='.'){
                    map2.put(ch,1);
                }
            }
        }
        
        return true;
    }
}
