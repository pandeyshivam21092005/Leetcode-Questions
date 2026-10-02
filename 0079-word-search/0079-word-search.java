class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(backtrack(board,word,i,j,0)) return true;
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word,int r,int c,int idx){

        // Word completely matched
        if(idx==word.length()) return true;

        // Out of bounds
        if(r<0 ||r>=board.length || c<0 || c>=board[0].length) return false;

        // Character doesn't match
        if(board[r][c]!=word.charAt(idx)) return false;

        // Mark current cell as visited
        char temp=board[r][c];
        board[r][c]='#';

        boolean found=
                      backtrack(board,word,r+1,c,idx+1)||
                      backtrack(board,word,r-1,c,idx+1)||
                      backtrack(board,word,r,c+1,idx+1)||
                      backtrack(board,word,r,c-1,idx+1);
        
        // Restore cell
        board[r][c]=temp;

        return found;
    }
}