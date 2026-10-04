class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row=new boolean[9][9];
        boolean[][] col=new boolean[9][9];
        boolean[][] box=new boolean[9][9];

        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(board[r][c]=='.'){
                    continue;
                }
                 int num=board[r][c]-'1';
                 // Find 3x3 box number
                 int boxIndex=(r/3)*3+(c/3);

                 // Duplicate found
                 if(row[r][num]||col[c][num]||box[boxIndex][num]){
                    return false;
                 }

                  // Mark number as used
                row[r][num]=true;
                col[c][num]=true;
                box[boxIndex][num]=true;
            }
        }
        return true;

    }
}