class Solution {
    private int[][] DIRS = {{-1, 0}, {1, 0}, {0,-1}, {0, 1}};
    private void dfs(char[][] board, int row, int col, int r, int c){

        if(r<0 || r >= row || c<0 || c>=col || board[r][c] != 'O') return ;

        board[r][c] = 'T';
        for(int[] d: DIRS){
            dfs(board, row, col, r+d[0], c+d[1]);
        }

    }
    public void solve(char[][] board) {

        int row = board.length;
        int col = board[0].length;
        
        for(int i =0; i<row; i++){
            dfs(board, row, col, i, 0);
        }

         for(int i =0; i<row; i++){
            dfs(board, row, col, i, col-1);
        }

         for(int i =0; i<col; i++){
            dfs(board, row, col, 0, i);
        }

        for(int i =0; i<col; i++){
            dfs(board, row, col, row-1, i);
        }
 

       for(int i=0; i<row; i++){
        for(int j =0; j<col; j++){
            if(board[i][j] == 'T'){
                board[i][j] = 'O';
            }else{
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
       }
        
    }
}
