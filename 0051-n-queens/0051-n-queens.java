class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] board=new char[n][n];

        // Fill board with '.'
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }

        backtrack(0,board,ans,n);
        return ans;
    }

    private void backtrack(int row,char[][] board,List<List<String>> ans,int n){

        // All queens placed
        if(row==n){
            List<String> temp= new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        // Try every column in current row
        for(int col=0;col<n;col++){
            if(isSafe(row,col,board,n)){

                // Place queen
                board[row][col]='Q';

                // Move to next row
                backtrack(row+1,board,ans,n);

                // Remove queen
                board[row][col]='.';
            }
        }
    }

    private boolean isSafe(int row,int col,char[][] board,int n){

        // Check column
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        // Check upper-left diagonal
        for(int i=row-1, j=col-1;i>=0&& j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        // Check upper-right diagonal
        for(int i=row-1, j=col+1;i>=0&& j<n;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}