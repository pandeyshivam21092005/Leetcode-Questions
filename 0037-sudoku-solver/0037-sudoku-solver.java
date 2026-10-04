class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }
    private boolean backtrack(char[][] board){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){

                 // Find empty cell
                if(board[row][col]=='.'){

                    // Try 1 to 9
                    for(char num='1';num<='9';num++){
                        if(isValid(board,row,col,num)){

                            // Place number
                            board[row][col]=num;

                            // Recursively solve
                            if(backtrack(board)){
                                return true;
                            }

                            // Backtrack
                            board[row][col]='.';
                        }
                    }

                    // No number worked
                    return false;
                }
            }
        }

         // No empty cell -> Sudoku solved
        return true;
    }

    private boolean isValid(char[][] board,int row,int col,char num){

         // Check row
        for(int j=0;j<9;j++){
            if(board[row][j]==num){
                return false;
            }
        }

         // Check column
        for(int i=0;i<9;i++){
            if(board[i][col]==num){
                return false;
            }
        }

         // Find 3x3 box
        int startrow=(row/3)*3;
        int startcol=(col/3)*3;

        // Check 3x3 box
        for(int i=startrow;i<startrow+3;i++){
            for(int j=startcol;j<startcol+3;j++){
                if(board[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }
}