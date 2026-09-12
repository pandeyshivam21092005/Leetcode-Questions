class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        // Initialize boundaries
        int top=0;   // Starting row
        int bottom=matrix.length-1;  // ending row
        int left=0;  // Starting column
        int right=matrix[0].length-1;  // ending column

        // Loop until all elements are traversed
        while(left<=right&& top<=bottom){
            // Traverse the top row from left to right
            for(int i=left;i<=right;i++){
                ans.add(matrix[top][i]);
            }
            top++; // Move the top boundary downward

            // Traverse the right column from top to bottom
            for(int i=top;i<=bottom;i++){
                ans.add(matrix[i][right]);
            }
            right--; // Move the right boundary leftward

            // Traverse the bottom row from right to left (only if rows remain)
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary upward
            }

            // Traverse the left column from bottom to top (only if columns remain)
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    ans.add(matrix[i][left]);
                }
                left++; // Move the left boundary rightward
            }
        }
        return ans;

    }
}